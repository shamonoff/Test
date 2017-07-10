package oracle.fodemo.storefront.listeners;

import oracle.adf.controller.v2.lifecycle.ADFLifecycle;

import javax.faces.context.FacesContext;

import oracle.adf.controller.v2.lifecycle.PagePhaseEvent;
import oracle.adf.controller.v2.lifecycle.PagePhaseListener;

import oracle.fodemo.storefront.adfextensions.FODApplicationModuleImpl;

public class FODPhaseListener implements PagePhaseListener {
    public FODPhaseListener() {
        super();
    }

    /**
     * @param pagePhaseEvent
     */
    public void afterPhase(PagePhaseEvent pagePhaseEvent) {
    }

    /**
     * @param pagePhaseEvent
     */
    public void beforePhase(PagePhaseEvent pagePhaseEvent) {
        Integer phase = pagePhaseEvent.getPhaseId();
        if (phase.equals(ADFLifecycle.PREPARE_MODEL_ID)) {
            FacesContext facescontext = FacesContext.getCurrentInstance();
            String language =
                facescontext.getExternalContext().getRequestLocale().getLanguage().toUpperCase();
            FODApplicationModuleImpl.preferredLanguage = language;
            FODApplicationModuleImpl.isWebUser = true;
        }
    }
}
