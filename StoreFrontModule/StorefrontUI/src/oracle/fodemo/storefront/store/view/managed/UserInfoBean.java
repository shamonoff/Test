package oracle.fodemo.storefront.store.view.managed;

import java.io.Serializable;

import javax.faces.context.ExternalContext;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;


public class UserInfoBean implements Serializable {

    private String _personId = null;
    private String _firstName = null;
    private String _lastName = null;
    private boolean _populated = false;


    public UserInfoBean() {
    }

    
    private void populate() {
        if (_populated) {
            return;
        }
        if (!getSecurity().isAuthenticated()) {
            return;
        }
        
        _firstName = "";
        _lastName = "";
        _personId = "";
        _populated = true;
    }

    /**
     * @return
     */
    public String getPersonId(){
        populate();
        return _personId;
    }

    /**
     * @return
     */
    public String getFirstName() {
        populate();
        return _firstName;
    }


    /**
     * @return
     */
    public String getLastName() {
        populate();
        return _lastName;
    }

    /**
     * @return
     */
    public String getUsername() {
        return getPrincipalName();
    }

    /**
     * @return
     */
    public String getPrincipalName() {
        populate();  
        return getSecurity().getUserName();
    }
                
    private SecurityContext getSecurity() {
        return ADFContext.getCurrent().getSecurityContext();
    }

    /**
     * @return
     */
    public boolean isLoggedIn() {
        return getSecurity().isAuthenticated();
    }
    
    
    /**
     * @return
     */
   public String logout() {
       ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
       HttpServletRequest request = (HttpServletRequest)ectx.getRequest();

       String temp = request.getContextPath() +
                     "/adfAuthentication?logout=logout&end_url=/faces/logout.jspx";

       try {
          ectx.redirect(temp);
       } catch (Exception ex) {
          System.out.println("Exception in logout()");
       }
       return null;
    }}
