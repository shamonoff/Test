package devguide.advanced.postingorder;

import oracle.jbo.domain.Number;
import java.io.Serializable;

public class Result implements Serializable {
    Number supplierId;
    Number productId;

    public Result() {
    }

    public void setSupplierId(Number svrId) {
        this.supplierId = svrId;
    }

    public Number getSupplierId() {
        return supplierId;
    }

    public void setProductId(Number prodId) {
        this.productId = prodId;
    }

    public Number getProductId() {
        return productId;
    }
}
