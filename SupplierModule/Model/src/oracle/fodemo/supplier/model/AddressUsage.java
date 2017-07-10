package oracle.fodemo.supplier.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@NamedQueries({
  @NamedQuery(name = "AddressUsage.findAll", query = "select o from AddressUsage o")
})
@EntityListeners({AuditableEntityListener.class})
@Table(name = "ADDRESS_USAGES")
public class AddressUsage implements Serializable, Auditable {
    @Id
    @Column(name="ADDRESS_USAGES_ID", nullable = false)
    @GeneratedValue(generator = "AddressUsagesSeq", 
                    strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "AddressUsagesSeq", 
                       sequenceName = "ADDRESS_USAGES_SEQ", 
                       allocationSize = 1)
    private Long addressUsagesId;
    @Column(name="CREATED_BY", nullable = false, length = 60)
    private String createdBy;
    @Column(name="CREATION_DATE", nullable = false)
    private Timestamp creationDate;
    @Column(name="EXPIRED_FLAG", nullable = false, length = 1)
    private String expiredFlag;
    @Column(name="LAST_UPDATED_BY", nullable = false, length = 60)
    private String lastUpdatedBy;
    @Column(name="LAST_UPDATE_DATE", nullable = false)
    private Timestamp lastUpdateDate;
    @Version
    @Column(name="OBJECT_VERSION_ID", nullable = false)
    private Long objectVersionId;
    @Column(name="OWNER_TYPE_CODE", nullable = false, length = 30)
    private String ownerTypeCode;
    @Column(name="USAGE_TYPE_CODE", nullable = false, length = 30)
    private String usageTypeCode;
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    @JoinColumn(name = "ADDRESS_ID")
    private Addresses addresses;
    @ManyToOne
    @JoinColumn(name = "ASSOCIATED_OWNER_ID")
    private Person person;

    public AddressUsage() {
    }

    public AddressUsage(Addresses addresses, Long addressUsagesId,
                        Person person, String createdBy,
                        Timestamp creationDate, String expiredFlag,
                        Timestamp lastUpdateDate, String lastUpdatedBy,
                        Long objectVersionId, String ownerTypeCode,
                        String usageTypeCode) {
        this.addresses = addresses;
        this.addressUsagesId = addressUsagesId;
        this.person = person;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.expiredFlag = expiredFlag;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.objectVersionId = objectVersionId;
        this.ownerTypeCode = ownerTypeCode;
        this.usageTypeCode = usageTypeCode;
    }


    public Long getAddressUsagesId() {
        return addressUsagesId;
    }

    public void setAddressUsagesId(Long addressUsagesId) {
        this.addressUsagesId = addressUsagesId;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getExpiredFlag() {
        return expiredFlag;
    }

    public void setExpiredFlag(String expiredFlag) {
        this.expiredFlag = expiredFlag;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getObjectVersionId() {
        return objectVersionId;
    }

    public void setObjectVersionId(Long objectVersionId) {
        this.objectVersionId = objectVersionId;
    }

    public String getOwnerTypeCode() {
        return ownerTypeCode;
    }

    public void setOwnerTypeCode(String ownerTypeCode) {
        this.ownerTypeCode = ownerTypeCode;
    }

    public String getUsageTypeCode() {
        return usageTypeCode;
    }

    public void setUsageTypeCode(String usageTypeCode) {
        this.usageTypeCode = usageTypeCode;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
