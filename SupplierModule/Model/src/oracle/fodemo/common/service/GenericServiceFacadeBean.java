package oracle.fodemo.common.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import oracle.fodemo.supplier.model.LookupCode;
import oracle.fodemo.supplier.model.LookupCodePK;

@Stateless(name = "GenericServiceFacade", mappedName = "SupplierModule_2.0-Model-GenericServiceFacade")
@Remote
@Local
public class GenericServiceFacadeBean implements GenericServiceFacade,
                                                 GenericServiceFacadeLocal {
    @PersistenceContext(unitName="Model")
    private EntityManager em;

    public GenericServiceFacadeBean() {
    }

    public Object queryByRange(String jpqlStmt, int firstResult,
                               int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public LookupCode persistLookupCode(LookupCode lookupCode) {
        em.persist(lookupCode);
        return lookupCode;
    }

    public LookupCode mergeLookupCode(LookupCode lookupCode) {
        return em.merge(lookupCode);
    }

    public void removeLookupCode(LookupCode lookupCode) {
        lookupCode = em.find(LookupCode.class, new LookupCodePK(lookupCode.getLanguage(), lookupCode.getLookupCode(), lookupCode.getLookupType()));
        em.remove(lookupCode);
    }

    /** <code>select o from LookupCode o </code> */
    public List<LookupCode> getLookupCodeFindAll() {
        return em.createNamedQuery("LookupCode.findAll").getResultList();
    }

    /** <code>select o from LookupCode o where o.language=:language and o.lookupType=:lookupType</code> */
    public List<LookupCode> getLookupCodeFindCodesByType(String language,
                                                         String lookupType) {
        return em.createNamedQuery("LookupCode.findCodesByType").setParameter("language", language).setParameter("lookupType", lookupType).getResultList();
    }
}
