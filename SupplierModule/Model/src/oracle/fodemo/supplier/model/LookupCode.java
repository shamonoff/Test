package oracle.fodemo.supplier.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
  @NamedQuery(name = "LookupCode.findAll", query = "select o from LookupCode o "),
  @NamedQuery(name = "LookupCode.findCodesByType", query = "select o from LookupCode o where o.language=:language and o.lookupType=:lookupType")
})
@EntityListeners({AuditableEntityListener.class})
@Table(name = "LOOKUP_CODES")
@IdClass(LookupCodePK.class)
public class LookupCode implements Serializable, Auditable {
    @Column(name="CREATED_BY", nullable = false, length = 60)
    private String createdBy;
    @Column(name="CREATION_DATE", nullable = false)
    private Timestamp creationDate;
    @Column(length = 240)
    private String description;
    @Id
    @Column(nullable = false, length = 30)
    private String language;
    @Column(name="LAST_UPDATED_BY", nullable = false, length = 60)
    private String lastUpdatedBy;
    @Column(name="LAST_UPDATE_DATE", nullable = false)
    private Timestamp lastUpdateDate;
    @Id
    @Column(name="LOOKUP_CODE", nullable = false, length = 30)
    private String lookupCode;
    @Id
    @Column(name="LOOKUP_TYPE", nullable = false, length = 30)
    private String lookupType;
    @Column(nullable = false, length = 80)
    private String meaning;
    @Column(name="OBJECT_VERSION_ID", nullable = false)
    private Long objectVersionId;
    @Column(name="SOURCE_LANG", nullable = false, length = 30)
    private String sourceLang;

    public LookupCode() {
    }

    public LookupCode(String createdBy, Timestamp creationDate,
                      String description, String language,
                      Timestamp lastUpdateDate, String lastUpdatedBy,
                      String lookupCode, String lookupType, String meaning,
                      Long objectVersionId, String sourceLang) {
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.description = description;
        this.language = language;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lookupCode = lookupCode;
        this.lookupType = lookupType;
        this.meaning = meaning;
        this.objectVersionId = objectVersionId;
        this.sourceLang = sourceLang;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public String getLookupCode() {
        return lookupCode;
    }

    public void setLookupCode(String lookupCode) {
        this.lookupCode = lookupCode;
    }

    public String getLookupType() {
        return lookupType;
    }

    public void setLookupType(String lookupType) {
        this.lookupType = lookupType;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public Long getObjectVersionId() {
        return objectVersionId;
    }

    public void setObjectVersionId(Long objectVersionId) {
        this.objectVersionId = objectVersionId;
    }

    public String getSourceLang() {
        return sourceLang;
    }

    public void setSourceLang(String sourceLang) {
        this.sourceLang = sourceLang;
    }
}
