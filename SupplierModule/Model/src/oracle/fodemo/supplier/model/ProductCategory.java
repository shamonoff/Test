package oracle.fodemo.supplier.model;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@NamedQueries({
  @NamedQuery(name = "ProductCategory.findAll", query = "select o from ProductCategory o")
})
@EntityListeners({AuditableEntityListener.class})
@Table(name = "PRODUCT_CATEGORIES_BASE")
public class ProductCategory implements Serializable, Auditable {
    @Id
    @Column(name="CATEGORY_ID", nullable = false)
    private Long categoryId;
    @Column(name="CATEGORY_LOCKED_FLAG", nullable = false, length = 1)
    private String categoryLockedFlag;
    @Column(name="CREATED_BY", nullable = false, length = 60)
    private String createdBy;
    @Column(name="CREATION_DATE", nullable = false)
    private Timestamp creationDate;
    @Column(name="LAST_UPDATED_BY", nullable = false, length = 60)
    private String lastUpdatedBy;
    @Column(name="LAST_UPDATE_DATE", nullable = false)
    private Timestamp lastUpdateDate;
    @Version
    @Column(name="OBJECT_VERSION_ID", nullable = false)
    private Long objectVersionId;
    @ManyToOne
    @JoinColumn(name = "PARENT_CATEGORY_ID")
    private ProductCategory productCategory;
    @OneToMany(mappedBy = "productCategory")
    private List<ProductCategory> productCategoryList;
    @OneToMany(mappedBy = "productCategory")
    private List<Product> productList;
    @ManyToOne
    @JoinColumn(name = "REPRESENTATIVE_PRODUCT_ID")
    private Product product;

    public ProductCategory() {
    }

    public ProductCategory(Long categoryId, String categoryLockedFlag,
                           String createdBy, Timestamp creationDate,
                           Timestamp lastUpdateDate, String lastUpdatedBy,
                           Long objectVersionId,
                           ProductCategory productCategory, Product product) {
        this.categoryId = categoryId;
        this.categoryLockedFlag = categoryLockedFlag;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.objectVersionId = objectVersionId;
        this.productCategory = productCategory;
        this.product = product;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryLockedFlag() {
        return categoryLockedFlag;
    }

    public void setCategoryLockedFlag(String categoryLockedFlag) {
        this.categoryLockedFlag = categoryLockedFlag;
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


    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }

    public ProductCategory addProductCategory(ProductCategory productCategory) {
        getProductCategoryList().add(productCategory);
        productCategory.setProductCategory(this);
        return productCategory;
    }

    public ProductCategory removeProductCategory(ProductCategory productCategory) {
        getProductCategoryList().remove(productCategory);
        productCategory.setProductCategory(null);
        return productCategory;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Product addProduct(Product product) {
        getProductList().add(product);
        product.setProductCategory(this);
        return product;
    }

    public Product removeProduct(Product product) {
        getProductList().remove(product);
        product.setProductCategory(null);
        return product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
