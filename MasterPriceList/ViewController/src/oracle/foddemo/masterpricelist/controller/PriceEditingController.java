package oracle.foddemo.masterpricelist.controller;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;

import oracle.foddemo.masterpricelist.view.utils.JSFUtils;

public class PriceEditingController {
    public static final String ADMIN_ROLE = "fod-admin";
    public static final String MANAGER_ROLE = "fod-manager";
    
    private String uiCookie; 
    private String lastSearchTerm;
    private boolean includeDiscontinuedProducts = false;
    private boolean admin = false;
    private boolean manager = false;


    /**
     * The initialize method decodes the UI State cookie and 
     * makes the values available throughout the scope of the 
     * task flow 
     */
    public void initialize(){
        
        //Pull out the saved UI values
        if (uiCookie != null && uiCookie.length() > 0) {
            if (uiCookie.charAt(0) == 'Y'){
                includeDiscontinuedProducts = true;
            }
            lastSearchTerm = uiCookie.substring(1);
            if (lastSearchTerm == null){
                lastSearchTerm = "";
            }
        }
        
        //Expose the user role in a helpful way for the task flow router
        //In this context Admin trumps Manager
         SecurityContext sctx = ADFContext.getCurrent().getSecurityContext();
        //ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
        if (sctx.isUserInRole(ADMIN_ROLE)){
            setAdmin(true);
        }
        else {
            if (sctx.isUserInRole(MANAGER_ROLE)){
                setManager(true);
            }
        }
        
    }
    
    /**
     * Method called at the end of the task flow to re-persist
     * the UI settings back into the cookie
     */
    public void finalize() {
        Boolean showDiscontinued = JSFUtils.resolveExpressionAsBoolean("#{sessionUIFlags.ShowDiscontinuedProducts}");
        StringBuilder newUICookieValue = new StringBuilder();
        newUICookieValue.append(showDiscontinued?'Y':'N');
        newUICookieValue.append(lastSearchTerm);
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = ctx.getExternalContext();
        HttpServletResponse response = 
            (HttpServletResponse)ectx.getResponse();
        Cookie cookie = new Cookie("fod_mpl_uistate", "");
        cookie.setPath("/");
        cookie.setValue(newUICookieValue.toString());
        cookie.setMaxAge(3600000);
        response.addCookie(cookie);
    }

    public void setUiCookie(String newuiCookie) {
        this.uiCookie = newuiCookie;
    }

    public String getUiCookie() {
        return uiCookie;
    }

    public void setLastSearchTerm(String newlastSearchTerm) {
        this.lastSearchTerm = newlastSearchTerm;
    }

    public String getLastSearchTerm() {
        return lastSearchTerm;
    }

    public void setIncludeDiscontinuedProducts(boolean newincludeDiscontinuedProducts) {
        this.includeDiscontinuedProducts = newincludeDiscontinuedProducts;
    }

    public boolean isIncludeDiscontinuedProducts() {
        return includeDiscontinuedProducts;
    }

    public void setAdmin(boolean newadmin) {
        this.admin = newadmin;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setManager(boolean newmanager) {
        this.manager = newmanager;
    }

    public boolean isManager() {
        return manager;
    }
    
}
