package oracle.fodemo.storefront.mycompany;

import oracle.adf.share.ADFContext;

import oracle.adf.share.security.SecurityContext;

import oracle.fodemo.storefront.store.queries.common.PersonsVO;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.client.Configuration;

import oracle.mds.core.MetadataObject;
import oracle.mds.core.RestrictedSession;
import oracle.mds.cust.CacheHint;
import oracle.mds.cust.CustomizationClass;


public class PersonTypeCC extends CustomizationClass {
    String mCachedUserTypeCode = null;
    String mCachedUserName = null;
    String userName = null;


    //--------------------------------------------------------------------------
    // CustomizationClass overrides
    //--------------------------------------------------------------------------
    /*
    *  Returns the CacheHint as MULTI_USER so that updated customizations get
    *  reflected in the page if the user changes.  ie.  If a user enters the
    *  page originally as anonymous and then logs in as a customer and returns
    *  to the page.
    */

    public CacheHint getCacheHint() {
        return CacheHint.MULTI_USER;
    }
    /*
    *  Returns the name of the Customization Layer.
    */

    public String getName() {
        return "persontype";
    }

    /*
    *  Returns the value for the customization layer.  ie. The customization
    *  layer values are CUST, STAFF, SUPP in this example.
    */

    public String[] getValue(RestrictedSession sess, MetadataObject mo) {
        String personType = null;
        SecurityContext sc = ADFContext.getCurrent().getSecurityContext();
        
        if (sc.isAuthenticated()) {   
            if (mCachedUserName == null || mCachedUserName.equals(sc.getUserPrincipal().getName()) == false) {
            mCachedUserName = sc.getUserPrincipal().getName();
            mCachedUserTypeCode = getPersonTypeCode(mCachedUserName);
            }
            
            else {
                personType = mCachedUserTypeCode;
            }
            return new String[] { personType };
        } else
            return null;
    }


    //--------------------------------------------------------------------------
    // Private Methods
    //--------------------------------------------------------------------------

    private String getPersonTypeCode(String username) {
        String amDef = "oracle.fodemo.storefront.store.service.StoreServiceAM";
        String config = "StoreServiceAMLocalWeb";
        ApplicationModule am =
            Configuration.createRootApplicationModule(amDef, config);
        PersonsVO vo = (PersonsVO)am.findViewObject("Persons");
        String personType = vo.findPerson(username);
        Configuration.releaseRootApplicationModule(am, true);
        return personType;
    }


}