package oracle.fodemo.supplier.model;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import oracle.jbo.JboException;
import oracle.jbo.ValidationException;


@Entity
@NamedQueries( { @NamedQuery(name = "Product.findAll",
                             query = "select o from Product o where o.supplier.supplierId = :loggedInSupplierId "),
                 @NamedQuery(name = "Product.findById", query = "select o from Product o where o.productId = :id")})
@EntityListeners( { AuditableEntityListener.class })
@Table(name = "PRODUCTS_BASE")
public class Product implements Serializable, Auditable {
    @Column(length = 150)
    private String attribute1;
    @Column(length = 150)
    private String attribute10;
    @Column(length = 150)
    private String attribute11;
    @Column(length = 150)
    private String attribute12;
    @Column(length = 150)
    private String attribute13;
    @Column(length = 150)
    private String attribute14;
    @Column(length = 150)
    private String attribute15;
    @Column(length = 150)
    private String attribute2;
    @Column(length = 150)
    private String attribute3;
    @Column(length = 150)
    private String attribute4;
    @Column(length = 150)
    private String attribute5;
    @Column(length = 150)
    private String attribute6;
    @Column(length = 150)
    private String attribute7;
    @Column(length = 150)
    private String attribute8;
    @Column(length = 150)
    private String attribute9;
    @Column(name = "ATTRIBUTE_CATEGORY", length = 30)
    private String attributeCategory;
    @Column(name = "COST_PRICE")
    private Double costPrice;
    @Column(name = "CREATED_BY", nullable = false, length = 60)
    private String createdBy;
    @Column(name = "CREATION_DATE", nullable = false)
    private Timestamp creationDate;
    @Column(name = "EXTERNAL_URL", length = 200)
    private String externalUrl;
    @Column(name = "LAST_UPDATED_BY", nullable = false, length = 60)
    private String lastUpdatedBy;
    @Column(name = "LAST_UPDATE_DATE", nullable = false)
    private Timestamp lastUpdateDate;
    @Column(name = "LIST_PRICE", nullable = false)
    private Double listPrice;
    @Column(name = "MIN_PRICE", nullable = false)
    private Double minPrice;
    @Column(name = "OBJECT_VERSION_ID", nullable = false)
    private Long objectVersionId;
    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    @GeneratedValue(generator = "Seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Seq", sequenceName = "PRODUCT_SEQ",
                       allocationSize = 1)
    private Long productId;
    @Column(name = "PRODUCT_NAME", nullable = false, length = 50)
    private String productName;
    @Column(name = "PRODUCT_STATUS", nullable = false, length = 30)
    private String productStatus;
    @Column(name = "SHIPPING_CLASS_CODE", nullable = false, length = 30)
    private String shippingClassCode;
    @Column(name = "WARRANTY_PERIOD_MONTHS")
    private Long warrantyPeriodMonths;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private ProductCategory productCategory;
    @OneToMany(mappedBy = "product")
    private List<ProductTranslation> productTranslationList;
    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID")
    private Supplier supplier;
    @OneToMany(mappedBy = "product", cascade = { CascadeType.REMOVE })
    private List<WarehouseStockLevel> warehouseStockLevelList;
    @OneToMany(mappedBy = "product", cascade = { CascadeType.REMOVE })
    private List<OrderItem> orderItemList;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,
               cascade = { CascadeType.PERSIST, CascadeType.MERGE,
                           CascadeType.REMOVE })
    private List<ProductImage> productImageList;
    @OneToMany(mappedBy = "product", cascade = { CascadeType.ALL })
    private List<ProductCategory> productCategoryList;

    public Product() {
    }

    public Product(String attribute1, String attribute10, String attribute11,
                   String attribute12, String attribute13, String attribute14,
                   String attribute15, String attribute2, String attribute3,
                   String attribute4, String attribute5, String attribute6,
                   String attribute7, String attribute8, String attribute9,
                   String attributeCategory, ProductCategory productCategory,
                   Double costPrice, String createdBy, Timestamp creationDate,
                   String externalUrl, Timestamp lastUpdateDate,
                   String lastUpdatedBy, Double listPrice, Double minPrice,
                   Long objectVersionId, Long productId, String productName,
                   String productStatus, String shippingClassCode,
                   Supplier supplier, Long warrantyPeriodMonths) {
        this.attribute1 = attribute1;
        this.attribute10 = attribute10;
        this.attribute11 = attribute11;
        this.attribute12 = attribute12;
        this.attribute13 = attribute13;
        this.attribute14 = attribute14;
        this.attribute15 = attribute15;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
        this.attribute6 = attribute6;
        this.attribute7 = attribute7;
        this.attribute8 = attribute8;
        this.attribute9 = attribute9;
        this.attributeCategory = attributeCategory;
        this.productCategory = productCategory;
        this.costPrice = costPrice;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.externalUrl = externalUrl;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.listPrice = listPrice;
        this.minPrice = minPrice;
        this.objectVersionId = objectVersionId;
        this.productId = productId;
        this.productName = productName;
        this.productStatus = productStatus;
        this.shippingClassCode = shippingClassCode;
        this.supplier = supplier;
        this.warrantyPeriodMonths = warrantyPeriodMonths;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute10() {
        return attribute10;
    }

    public void setAttribute10(String attribute10) {
        this.attribute10 = attribute10;
    }

    public String getAttribute11() {
        return attribute11;
    }

    public void setAttribute11(String attribute11) {
        this.attribute11 = attribute11;
    }

    public String getAttribute12() {
        return attribute12;
    }

    public void setAttribute12(String attribute12) {
        this.attribute12 = attribute12;
    }

    public String getAttribute13() {
        return attribute13;
    }

    public void setAttribute13(String attribute13) {
        this.attribute13 = attribute13;
    }

    public String getAttribute14() {
        return attribute14;
    }

    public void setAttribute14(String attribute14) {
        this.attribute14 = attribute14;
    }

    public String getAttribute15() {
        return attribute15;
    }

    public void setAttribute15(String attribute15) {
        this.attribute15 = attribute15;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }

    public String getAttribute7() {
        return attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }

    public String getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }

    public String getAttribute9() {
        return attribute9;
    }

    public void setAttribute9(String attribute9) {
        this.attribute9 = attribute9;
    }

    public String getAttributeCategory() {
        return attributeCategory;
    }

    public void setAttributeCategory(String attributeCategory) {
        this.attributeCategory = attributeCategory;
    }


    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
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

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
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

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getShippingClassCode() {
        return shippingClassCode;
    }

    public void setShippingClassCode(String shippingClassCode) {
        this.shippingClassCode = shippingClassCode;
    }


    public Long getWarrantyPeriodMonths() {
        return warrantyPeriodMonths;
    }

    public void setWarrantyPeriodMonths(Long warrantyPeriodMonths) {
        this.warrantyPeriodMonths = warrantyPeriodMonths;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public List<ProductTranslation> getProductTranslationList() {
        return productTranslationList;
    }

    public void setProductTranslationList(List<ProductTranslation> productTranslationList) {
        this.productTranslationList = productTranslationList;
    }

    public ProductTranslation addProductTranslation(ProductTranslation productTranslation) {
        getProductTranslationList().add(productTranslation);
        productTranslation.setProduct(this);
        return productTranslation;
    }

    public ProductTranslation removeProductTranslation(ProductTranslation productTranslation) {
        getProductTranslationList().remove(productTranslation);
        productTranslation.setProduct(null);
        return productTranslation;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<WarehouseStockLevel> getWarehouseStockLevelList() {
        return warehouseStockLevelList;
    }

    public void setWarehouseStockLevelList(List<WarehouseStockLevel> warehouseStockLevelList) {
        this.warehouseStockLevelList = warehouseStockLevelList;
    }

    public WarehouseStockLevel addWarehouseStockLevel(WarehouseStockLevel warehouseStockLevel) {
        getWarehouseStockLevelList().add(warehouseStockLevel);
        warehouseStockLevel.setProduct(this);
        return warehouseStockLevel;
    }

    public WarehouseStockLevel removeWarehouseStockLevel(WarehouseStockLevel warehouseStockLevel) {
        getWarehouseStockLevelList().remove(warehouseStockLevel);
        warehouseStockLevel.setProduct(null);
        return warehouseStockLevel;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public OrderItem addOrderItem(OrderItem orderItem) {
        getOrderItemList().add(orderItem);
        orderItem.setProduct(this);
        return orderItem;
    }

    public OrderItem removeOrderItem(OrderItem orderItem) {
        getOrderItemList().remove(orderItem);
        orderItem.setProduct(null);
        return orderItem;
    }

    public List<ProductImage> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    public ProductImage addProductImage(ProductImage productImage) {
        getProductImageList().add(productImage);
        productImage.setProduct(this);
        return productImage;
    }

    public ProductImage removeProductImage(ProductImage productImage) {
        getProductImageList().remove(productImage);
        productImage.setProduct(null);
        return productImage;
    }

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }

    public ProductCategory addProductCategory(ProductCategory productCategory) {
        getProductCategoryList().add(productCategory);
        productCategory.setProduct(this);
        return productCategory;
    }

    public ProductCategory removeProductCategory(ProductCategory productCategory) {
        getProductCategoryList().remove(productCategory);
        productCategory.setProduct(null);
        return productCategory;
    }

    @PrePersist
    @PreUpdate
    public void validateProduct() {
        if (minPrice != null && listPrice != null) {
            if (minPrice.doubleValue() > listPrice.doubleValue()) {
                throw new ValidationException("List Price cannot be less than Minimum Price.");
            }
        }

    }
}
