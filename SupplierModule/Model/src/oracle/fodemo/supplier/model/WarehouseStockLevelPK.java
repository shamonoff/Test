package oracle.fodemo.supplier.model;

import java.io.Serializable;

public class WarehouseStockLevelPK implements Serializable {
    private Long productId;
    private Long warehouseId;

    public WarehouseStockLevelPK() {
    }

    public WarehouseStockLevelPK(Long productId, Long warehouseId) {
        this.productId = productId;
        this.warehouseId = warehouseId;
    }

    public boolean equals(Object other) {
        if (other instanceof WarehouseStockLevelPK) {
            final WarehouseStockLevelPK otherWarehouseStockLevelPK = (WarehouseStockLevelPK) other;
            final boolean areEqual =
                (otherWarehouseStockLevelPK.productId.equals(productId) && otherWarehouseStockLevelPK.warehouseId.equals(warehouseId));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    Long getProductId() {
        return productId;
    }

    void setProductId(Long productId) {
        this.productId = productId;
    }

    Long getWarehouseId() {
        return warehouseId;
    }

    void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }
}
