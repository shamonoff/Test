package oracle.fodemo.supplier.model;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@NamedQueries({
  @NamedQuery(name = "ProductImage.findAll", query = "select o from ProductImage o"),
  @NamedQuery(name = "ProductImage.deleteByProduct", query = "delete from ProductImage o where o.product.productId = :productId")})
@EntityListeners({AuditableEntityListener.class})
@Table(name = "PRODUCT_IMAGES")
public class ProductImage implements Serializable, Auditable {
    @Column(name="CREATED_BY", nullable = false, length = 60)
    private String createdBy;
    @Column(name="CREATION_DATE", nullable = false)
    private Timestamp creationDate;
    @Column(name="DEFAULT_VIEW_FLAG", nullable = false, length = 1)
    private String defaultViewFlag;
    @Column(nullable = false)
    private byte[] image;
    @Column(name="LAST_UPDATED_BY", nullable = false, length = 60)
    private String lastUpdatedBy;
    @Column(name="LAST_UPDATE_DATE", nullable = false)
    private Timestamp lastUpdateDate;
    @Column(name="OBJECT_VERSION_ID", nullable = false)
    private Long objectVersionId;
    @Id
    @Column(name="PRODUCT_IMAGE_ID", nullable = false)
    @GeneratedValue(generator = "ProductImageSeq", 
                    strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ProductImageSeq", 
                       sequenceName = "PRODUCT_IMAGE_SEQ", 
                       allocationSize = 1)
    private Long productImageId;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "DETAIL_IMAGE_ID",referencedColumnName = "PRODUCT_IMAGE_ID")
    private ProductImage productImage;
    @OneToMany(mappedBy = "productImage",cascade={CascadeType.ALL})
    private List<ProductImage> productImageList;

    public ProductImage() {
    }

    public ProductImage(String createdBy, Timestamp creationDate,
                        String defaultViewFlag, ProductImage productImage,
                        Timestamp lastUpdateDate, String lastUpdatedBy,
                        Long objectVersionId, Product product,
                        Long productImageId) {
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.defaultViewFlag = defaultViewFlag;
        this.productImage = productImage;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.objectVersionId = objectVersionId;
        this.product = product;
        this.productImageId = productImageId;
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

    public String getDefaultViewFlag() {
        return defaultViewFlag;
    }

    public void setDefaultViewFlag(String defaultViewFlag) {
        this.defaultViewFlag = defaultViewFlag;
    }


    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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


    public Long getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(Long productImageId) {
        this.productImageId = productImageId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductImage getProductImage() {
        return productImage;
    }

    public void setProductImage(ProductImage productImage) {
        this.productImage = productImage;
    }

    public List<ProductImage> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    public ProductImage addProductImage(ProductImage productImage) {
        getProductImageList().add(productImage);
        productImage.setProductImage(this);
        return productImage;
    }

    public ProductImage removeProductImage(ProductImage productImage) {
        getProductImageList().remove(productImage);
        productImage.setProductImage(null);
        return productImage;
    }
}
