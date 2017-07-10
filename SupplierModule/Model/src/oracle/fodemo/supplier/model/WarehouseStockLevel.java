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
  @NamedQuery(name = "WarehouseStockLevel.findAll", query = "select o from WarehouseStockLevel o")
})
@EntityListeners({AuditableEntityListener.class})
@Table(name = "WAREHOUSE_STOCK_LEVELS")
@IdClass(WarehouseStockLevelPK.class)
public class WarehouseStockLevel implements Serializable, Auditable {
    @Column(name="CREATED_BY", nullable = false, length = 60)
    private String createdBy;
    @Column(name="CREATION_DATE", nullable = false)
    private Timestamp creationDate;
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
    @Column(name="QUANTITY_ON_HAND", nullable = false)
    private Long quantityOnHand;
    @Id
    @Column(name="WAREHOUSE_ID", nullable = false)
    private Long warehouseId;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public WarehouseStockLevel() {
    }

    public WarehouseStockLevel(String createdBy, Timestamp creationDate,
                               Timestamp lastUpdateDate, String lastUpdatedBy,
                               Long objectVersionId, Product product,
                               Long quantityOnHand, Long warehouseId) {
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.objectVersionId = objectVersionId;
        this.product = product;
        this.quantityOnHand = quantityOnHand;
        this.warehouseId = warehouseId;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(Long quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
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
