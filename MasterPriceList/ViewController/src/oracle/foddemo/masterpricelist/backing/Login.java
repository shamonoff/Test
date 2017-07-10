package oracle.foddemo.masterpricelist.backing;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.foddemo.masterpricelist.view.utils.JSFUtils;

import weblogic.security.URLCallbackHandler;
import weblogic.security.services.Authentication;

import weblogic.servlet.security.ServletAuthentication;

public class Login {

        private String _username;
        private String _password;

    public Login() {
        }


        public String doLogin(){

           String un =_username;
           byte [] pw = _password.getBytes();
           FacesContext ctx = FacesContext.getCurrentInstance();
           HttpServletRequest request = (HttpServletRequest)ctx.getExternalContext().getRequest();
           CallbackHandler handler = new URLCallbackHandler(un,pw);
           try {
            Subject mySubject = Authentication.login(handler);
            ServletAuthentication.runAs(mySubject,request);
            ExternalContext ectx =ctx.getExternalContext();
            HttpServletResponse response = 
                (HttpServletResponse)ectx.getResponse();
            //------------Cookie Stuff
            Cookie cookie = new Cookie("fod_mpl_user", "");
            cookie.setPath("/");

            if (JSFUtils.resolveExpressionAsBoolean("#{sessionUIFlags['RememberMe']}")) {
                cookie.setValue(un);
                cookie.setMaxAge(3600000);
            } else {
                //Expire the cookie
                cookie.setMaxAge(0);
            }
            response.addCookie(cookie);
            //-------------------------
               
            String loginUrl = "/faces/adf.task-flow?adf.tfId=price-editing-flow&adf.tfDoc=/WEB-INF/price-editing-flow.xml";
            sendForward(request,response,loginUrl);
            
            //return "loggedIn";
        } catch (FailedLoginException fle) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                "Incorrect username or password",
                                                "An incorrect Username or Password"+
                                                " was specified");
            ctx.addMessage(null,msg);
        } catch (LoginException le) {
               reportUnexpectedLoginError("LoginException",le);
        }
        return "null";

    }
        
        public String doLogout(){
            FacesContext fctx = FacesContext.getCurrentInstance();
            HttpServletRequest  request = (HttpServletRequest)fctx.getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse)fctx.getExternalContext().getResponse();
            String logoutUrl = "/adfAuthentication?logout=true&end_url=/faces/login";
            sendForward(request, response, logoutUrl);
            return "null";
            
        }


    private void reportUnexpectedLoginError(String errType, Exception e) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                            "Unexpected Error During Login",
                                            "Unexpected Error During Login ( "+
                                            errType+" ), please consult log for "+
                                            "details");
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null,msg);
        e.printStackTrace();
    }

    public void setUsername(String _username) {
        this._username = _username;
    }

    public String getUsername() {
        return _username;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public String getPassword() {
        return _password;
    }

    private void sendForward(HttpServletRequest request,
                             HttpServletResponse response, String forwardUrl) {
        FacesContext ctx = FacesContext.getCurrentInstance(); 
                 ExternalContext ectx = ctx.getExternalContext(); 
                 forwardUrl = request.getContextPath() + forwardUrl; 
                 try { 
                     ectx.redirect(forwardUrl); 
                 } 
                 catch(IOException ioe){ 
                     reportUnexpectedLoginError("IOException",ioe); 
                 } 
    }
}
