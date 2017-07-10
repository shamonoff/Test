package oracle.fodemo.supplier.model;

import java.io.Serializable;

public class OrderItemPK implements Serializable {
    private Long lineItemId;
    private Long orderId;

    public OrderItemPK() {
    }

    public OrderItemPK(Long lineItemId, Long orderId) {
        this.lineItemId = lineItemId;
        this.orderId = orderId;
    }

    public boolean equals(Object other) {
        if (other instanceof OrderItemPK) {
            final OrderItemPK otherOrderItemPK = (OrderItemPK) other;
            final boolean areEqual =
                (otherOrderItemPK.lineItemId.equals(lineItemId) && otherOrderItemPK.orderId.equals(orderId));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    Long getLineItemId() {
        return lineItemId;
    }

    void setLineItemId(Long lineItemId) {
        this.lineItemId = lineItemId;
    }

    Long getOrderId() {
        return orderId;
    }

    void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
