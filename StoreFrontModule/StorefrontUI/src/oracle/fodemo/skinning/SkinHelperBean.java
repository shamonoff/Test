package oracle.fodemo.skinning;

import java.io.IOException;

import javax.faces.context.FacesContext;

import oracle.fodemo.storefront.jsf.util.JSFUtils;

public class SkinHelperBean {
    
    String currentSkin = null;
    
    public SkinHelperBean() {
    }
    
    
    public String switchSkin(){
        
        System.out.println("NEW SKIN IS "+currentSkin);

        FacesContext context = JSFUtils.getFacesContext();
        String view = JSFUtils.getRootViewId();
        String url = JSFUtils.getPageURL(view);
        System.out.println("URL "+url);
        try {
            context.getExternalContext().redirect(url);
            context.responseComplete();
        } catch (IOException e) {
            //TODO: Decide what to do here. No action needed, so shall we log it ?
        }
        return null;
    }

    public void setCurrentSkin(String currentSkin) {
        this.currentSkin = currentSkin;
    }

    public String getCurrentSkin() {
        return currentSkin;
    }
}
