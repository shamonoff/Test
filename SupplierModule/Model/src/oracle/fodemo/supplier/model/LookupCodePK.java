package oracle.fodemo.supplier.model;

import java.io.Serializable;

public class LookupCodePK implements Serializable {
    private String language;
    private String lookupCode;
    private String lookupType;

    public LookupCodePK() {
    }

    public LookupCodePK(String language, String lookupCode,
                        String lookupType) {
        this.language = language;
        this.lookupCode = lookupCode;
        this.lookupType = lookupType;
    }

    public boolean equals(Object other) {
        if (other instanceof LookupCodePK) {
            final LookupCodePK otherLookupCodePK = (LookupCodePK) other;
            final boolean areEqual =
                (otherLookupCodePK.language.equals(language) && otherLookupCodePK.lookupCode.equals(lookupCode) && otherLookupCodePK.lookupType.equals(lookupType));
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

    String getLookupCode() {
        return lookupCode;
    }

    void setLookupCode(String lookupCode) {
        this.lookupCode = lookupCode;
    }

    String getLookupType() {
        return lookupType;
    }

    void setLookupType(String lookupType) {
        this.lookupType = lookupType;
    }
}
