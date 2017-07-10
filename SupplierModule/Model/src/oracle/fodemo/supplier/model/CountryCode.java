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
  @NamedQuery(name = "CountryCode.findAll", query = "select o from CountryCode o")
})
@EntityListeners({AuditableEntityListener.class})
@Table(name = "COUNTRY_CODES")
@IdClass(CountryCodePK.class)
public class CountryCode implements Serializable, Auditable {
    @Column(name="COUNTRY_NAME", length = 100)
    private String countryName;
    @Column(name="CREATED_BY", nullable = false, length = 60)
    private String createdBy;
    @Column(name="CREATION_DATE", nullable = false)
    private Timestamp creationDate;
    @Id
    @Column(name="ISO_COUNTRY_CODE", nullable = false, length = 2)
    private String isoCountryCode;
    @Id
    @Column(nullable = false, length = 30)
    private String language;
    @Column(name="LAST_UPDATED_BY", nullable = false, length = 60)
    private String lastUpdatedBy;
    @Column(name="LAST_UPDATE_DATE", nullable = false)
    private Timestamp lastUpdateDate;
    @Column(name="OBJECT_VERSION_ID", nullable = false)
    private Long objectVersionId;
    @Column(name="SOURCE_LANG", length = 30)
    private String sourceLang;

    public CountryCode() {
    }

    public CountryCode(String countryName, String createdBy,
                       Timestamp creationDate, String isoCountryCode,
                       String language, Timestamp lastUpdateDate,
                       String lastUpdatedBy, Long objectVersionId,
                       String sourceLang) {
        this.countryName = countryName;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.isoCountryCode = isoCountryCode;
        this.language = language;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.objectVersionId = objectVersionId;
        this.sourceLang = sourceLang;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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

    public String getIsoCountryCode() {
        return isoCountryCode;
    }

    public void setIsoCountryCode(String isoCountryCode) {
        this.isoCountryCode = isoCountryCode;
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
