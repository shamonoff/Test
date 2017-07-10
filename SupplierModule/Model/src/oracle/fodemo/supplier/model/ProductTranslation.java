package oracle.fodemo.supplier.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
  @NamedQuery(name = "ProductTranslation.findAll", query = "select o from ProductTranslation o"),
  @NamedQuery(name = "ProductTranslation.deleteByProduct", query = "delete from ProductTranslation o where o.productId = :productId")
})
@EntityListeners({AuditableEntityListener.class})
@Table(name = "PRODUCT_TRANSLATIONS")
@IdClass(ProductTranslationPK.class)
public class ProductTranslation implements Serializable, Auditable {
    @Column(name="ADDITIONAL_INFO", length = 4000)
    private String additionalInfo;
    @Column(name="CREATED_BY", nullable = false, length = 60)
    private String createdBy;
    @Column(name="CREATION_DATE", nullable = false)
    private Timestamp creationDate;
    @Column(nullable = false, length = 4000)
    private String description;
    @Id
    @Column(nullable = false, length = 30)
    private String language;
    @Column(name="LAST_UPDATED_BY", nullable = false, length = 60)
    private String lastUpdatedBy;
    @Column(name="LAST_UPDATE_DATE", nullable = false)
    private Timestamp lastUpdateDate;
    @Column(name="OBJECT_VERSION_ID", nullable = false)
    private Long objectVersionId;
    @Id
    @Column(name="PRODUCT_ID", nullable = false, insertable = false,
            updatable = false)
    private Long productId;
    @Column(name="SOURCE_LANG", length = 30)
    private String sourceLang;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public ProductTranslation() {
    }

    public ProductTranslation(String additionalInfo, String createdBy,
                              Timestamp creationDate, String description,
                              String language, Timestamp lastUpdateDate,
                              String lastUpdatedBy, Long objectVersionId,
                              Product product, String sourceLang) {
        this.additionalInfo = additionalInfo;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.description = description;
        this.language = language;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.objectVersionId = objectVersionId;
        this.product = product;
        this.sourceLang = sourceLang;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
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

    public Long getObjectVersionId() {
        return objectVersionId;
    }

    public void setObjectVersionId(Long objectVersionId) {
        this.objectVersionId = objectVersionId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSourceLang() {
        return sourceLang;
    }

    public void setSourceLang(String sourceLang) {
        this.sourceLang = sourceLang;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        if (product != null) {
            this.productId = product.getProductId();
        }
    }
}
