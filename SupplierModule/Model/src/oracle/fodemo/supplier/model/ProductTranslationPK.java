package oracle.fodemo.supplier.model;

import java.io.Serializable;

public class ProductTranslationPK implements Serializable {
    private String language;
    private Long productId;

    public ProductTranslationPK() {
    }

    public ProductTranslationPK(String language, Long productId) {
        this.language = language;
        this.productId = productId;
    }

    public boolean equals(Object other) {
        if (other instanceof ProductTranslationPK) {
            final ProductTranslationPK otherProductTranslationPK = (ProductTranslationPK) other;
            final boolean areEqual =
                (otherProductTranslationPK.language.equals(language) && otherProductTranslationPK.productId.equals(productId));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    String getLanguage() {
        return language;
    }

    void setLanguage(String language) {
        this.language = language;
    }

    Long getProductId() {
        return productId;
    }

    void setProductId(Long productId) {
        this.productId = productId;
    }
}
