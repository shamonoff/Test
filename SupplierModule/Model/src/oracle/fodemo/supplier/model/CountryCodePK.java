package oracle.fodemo.supplier.model;

import java.io.Serializable;

public class CountryCodePK implements Serializable {
    private String isoCountryCode;
    private String language;

    public CountryCodePK() {
    }

    public CountryCodePK(String isoCountryCode, String language) {
        this.isoCountryCode = isoCountryCode;
        this.language = language;
    }

    public boolean equals(Object other) {
        if (other instanceof CountryCodePK) {
            final CountryCodePK otherCountryCodePK = (CountryCodePK) other;
            final boolean areEqual =
                (otherCountryCodePK.isoCountryCode.equals(isoCountryCode) && otherCountryCodePK.language.equals(language));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    String getIsoCountryCode() {
        return isoCountryCode;
    }

    void setIsoCountryCode(String isoCountryCode) {
        this.isoCountryCode = isoCountryCode;
    }

    String getLanguage() {
        return language;
    }

    void setLanguage(String language) {
        this.language = language;
    }
}
