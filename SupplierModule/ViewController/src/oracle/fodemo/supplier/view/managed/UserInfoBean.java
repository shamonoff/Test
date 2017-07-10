package oracle.fodemo.supplier.view.managed;

import javax.faces.context.ExternalContext;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;
import oracle.adf.share.security.identitymanagement.UserProfile;


public class UserInfoBean {

    private String _personId = null;
    private String _firstName = null;
    private String _lastName = null;
    private boolean _populated = false;
    private String randomValue;
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

    public String getPersonId(){
        populate();
        return _personId;
    }

    public String getFirstName() {
        populate();
        return _firstName;
    }


    public String getLastName() {
        populate();
        return _lastName;
    }

    public String getUsername() {
        return getPrincipalName();
    }

    public String getPrincipalName() {
        populate();
        
        return getSecurity().getUserName();
    }
                
    private SecurityContext getSecurity() {
        return ADFContext.getCurrent().getSecurityContext();
    }
    
    public boolean isLoggedIn() {
        String[] roles = this.getSecurity().getUserRoles();
        return getSecurity().isAuthenticated();
    }


    public void setRandomValue(String randomValue) {
        this.randomValue = randomValue;
    }

    public String getRandomValue() {
        double dbl = Math.random();
        return Double.toString(dbl);
    }
}
