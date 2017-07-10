package oracle.fodemo.supplier.model;

import java.sql.Timestamp;

import javax.ejb.EJBContext;

import javax.naming.InitialContext;

import javax.naming.NamingException;

import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 * AuditableEntityListener is used to populate audit/history fields
 *
 */
public class AuditableEntityListener {
    // Change it in real business scenario , as per the usecase
    private final String SUPPLIER_PORTAL = "SUPPLIER_PORTAL";
    protected static InitialContext ctx;

    public AuditableEntityListener() {
        try {
            if (ctx == null)
                ctx = new InitialContext();
        } catch (NamingException e) {
            System.out.println(e.getMessage());
        }

    }

    @PreUpdate
    public void preUpdate(Object entity) {
        if (entity instanceof Auditable) {
            Auditable auditable = (Auditable)entity;
            Timestamp now = new Timestamp(System.currentTimeMillis());
            auditable.setLastUpdatedBy(getCallerIdentity());
            auditable.setLastUpdateDate(now);
            if (auditable.getObjectVersionId() == null) {
                // a hack for those entities which dont need the version integrity
                auditable.setObjectVersionId(new Long(0));

            }
        }

    }

    @PrePersist
    public void PrePersist(Object entity) {
        if (entity instanceof Auditable) {
            Auditable auditable = (Auditable)entity;
            Timestamp now = new Timestamp(System.currentTimeMillis());
            String callerIdentity = getCallerIdentity();
            auditable.setCreatedBy(callerIdentity);
            auditable.setCreationDate(now);
            auditable.setLastUpdatedBy(callerIdentity);
            auditable.setLastUpdateDate(now);
            if (auditable.getObjectVersionId() == null) {
                // a hack for those entities which dont need the version integrity
                auditable.setObjectVersionId(new Long(1));
             }
        }

    }

    @PreRemove
    public void PreRemove(Auditable auditable) {
        //Add your code here
    }

    @PostLoad
    public void PostLoad(Auditable auditable) {
        //Add your code here
    }

    private String getCallerIdentity() {
        try {
            EJBContext ejbCtx = (EJBContext)ctx.lookup("java:comp/EJBContext");
            String callerPrincipal =
                ejbCtx.getCallerPrincipal().getName(); // get identity with JAAS

            return callerPrincipal;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return SUPPLIER_PORTAL;
        }
    }

}
