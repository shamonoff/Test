package oracle.fodemo.security;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adfinternal.view.faces.bi.util.JsfUtils;

import oracle.binding.BindingContainer;


import oracle.fodemo.supplier.view.utils.JSFUtils;

import weblogic.security.SimpleCallbackHandler;

import weblogic.security.services.Authentication;

import weblogic.servlet.security.ServletAuthentication;


public class Login {
    private String userName;
    private String password;

    public Login() {
        super();
    }

    public String doLogin() {

        String un = userName;
        byte[] pw = password.getBytes();
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest request =
            (HttpServletRequest)ctx.getExternalContext().getRequest();
        CallbackHandler handler = new SimpleCallbackHandler(un, pw);
        try {
            Subject mySubject = Authentication.login(handler);
            ServletAuthentication.runAs(mySubject, request);
            ExternalContext ectx = ctx.getExternalContext();
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


        } catch (FailedLoginException fle) {
            FacesMessage msg =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrect username or password",
                                 "An incorrect Username or Password" +
                                 " was specified");
            ctx.addMessage(null, msg);
            return "InvalidUser";
        } catch (LoginException le) {
            reportUnexpectedLoginError("LoginException", le);
        }
        return "validUser";

    }

    public String doLogout() {
        FacesContext fctx = FacesContext.getCurrentInstance();
        HttpServletRequest request =
            (HttpServletRequest)fctx.getExternalContext().getRequest();
        HttpServletResponse response =
            (HttpServletResponse)fctx.getExternalContext().getResponse();
        String logoutUrl =
            "/adfAuthentication?logout=true&end_url=/faces/login";
        sendForward(request, response, logoutUrl);
        return "doLogout";

    }

    private void sendForward(HttpServletRequest request,
                             HttpServletResponse response, String forwardUrl) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = ctx.getExternalContext();
        forwardUrl = request.getContextPath() + forwardUrl;
        try {
            ectx.redirect(forwardUrl);
        } catch (IOException ioe) {
            reportUnexpectedLoginError("IOException", ioe);
        }
    }

    private void reportUnexpectedLoginError(String errType, Exception e) {
        FacesMessage msg =
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unexpected Error During Login",
                             "Unexpected Error During Login ( " + errType +
                             " ), please consult log for " + "details");
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, msg);
        e.printStackTrace();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
