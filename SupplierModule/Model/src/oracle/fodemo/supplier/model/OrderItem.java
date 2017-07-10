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
  @NamedQuery(name = "OrderItem.findAll", query = "select o from OrderItem o")
})
@EntityListeners({AuditableEntityListener.class})
@Table(name = "ORDER_ITEMS")
@IdClass(OrderItemPK.class)
public class OrderItem implements Serializable, Auditable {
    @Column(name="CREATED_BY", nullable = false, length = 60)
    private String createdBy;
    @Column(name="CREATION_DATE", nullable = false)
    private Timestamp creationDate;
    @Column(name="LAST_UPDATED_BY", nullable = false, length = 60)
    private String lastUpdatedBy;
    @Column(name="LAST_UPDATE_DATE", nullable = false)
    private Timestamp lastUpdateDate;
    @Id
    @Column(name="LINE_ITEM_ID", nullable = false)
    private Long lineItemId;
    @Column(name="OBJECT_VERSION_ID", nullable = false)
    private Long objectVersionId;
    @Id
    @Column(name="ORDER_ID", nullable = false)
    private Long orderId;
    @Column(nullable = false)
    private Long quantity;
    @Column(name="UNIT_PRICE", nullable = false)
    private Double unitPrice;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public OrderItem() {
    }

    public OrderItem(String createdBy, Timestamp creationDate,
                     Timestamp lastUpdateDate, String lastUpdatedBy,
                     Long lineItemId, Long objectVersionId, Long orderId,
                     Product product, Long quantity, Double unitPrice) {
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lineItemId = lineItemId;
        this.objectVersionId = objectVersionId;
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
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

    public Long getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(Long lineItemId) {
        this.lineItemId = lineItemId;
    }

    public Long getObjectVersionId() {
        return objectVersionId;
    }

    public void setObjectVersionId(Long objectVersionId) {
        this.objectVersionId = objectVersionId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
