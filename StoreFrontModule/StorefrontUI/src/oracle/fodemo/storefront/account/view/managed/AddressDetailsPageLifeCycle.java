package oracle.fodemo.storefront.account.view.managed;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.faces.context.FacesContext;
import oracle.adf.controller.v2.context.LifecycleContext;
import oracle.adf.controller.v2.context.PageLifecycleContext;
import oracle.adf.controller.v2.lifecycle.PageController;
import oracle.adf.controller.v2.lifecycle.PagePhaseEvent;
import oracle.adf.controller.v2.lifecycle.PagePhaseListener;
import oracle.adf.model.RegionBinding;
import oracle.adf.model.RegionContext;
import oracle.adf.model.RegionController;
import oracle.adf.model.binding.DCBindingContainer;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.application.FacesMessage;
import oracle.binding.BindingContainer;
import oracle.binding.ControlBinding;

import oracle.fodemo.storefront.adf.util.ADFUtils;
import oracle.fodemo.storefront.jsf.util.JSFUtils;
import oracle.jbo.AttrValException;
import oracle.jbo.JboException;
import oracle.jbo.ValidationException;
import oracle.jbo.uicli.binding.JUCtrlAttrsBinding;

public class AddressDetailsPageLifeCycle extends PageController implements RegionController, 
                                                                           PagePhaseListener {

    private int counter = 0;

    public AddressDetailsPageLifeCycle() {
    }

    /**
     * @param pagePhaseEvent
     */
    public void afterPhase(PagePhaseEvent pagePhaseEvent) {
        System.out.println("### => AFTER PHASE " + 
                           pagePhaseEvent.getPhaseId());
    }

    /**
     * @param pagePhaseEvent
     */
    public void beforePhase(PagePhaseEvent pagePhaseEvent) {
        System.out.println("### => BEFORE PHASE" + 
                           pagePhaseEvent.getPhaseId());
    }


    /**
     * @param pageLifecycleContext
     * @param string
     * @return
     */
    @Override
    public boolean invokeActionBinding(PageLifecycleContext pageLifecycleContext, 
                                       String string) {
        dumpCall("invokeActionBinding(" + string + ")");
        return super.invokeActionBinding(pageLifecycleContext, string);
    }

    /**
     * @param lifecycleContext
     */
    @Override
    public void prepareModel(LifecycleContext lifecycleContext) {
        if (!(lifecycleContext.getBindingContext().getErrorHandler() instanceof 
              UserRegErrorHandler)) {
            lifecycleContext.getBindingContext().setErrorHandler(new UserRegErrorHandler(true));
        }
        super.prepareModel(lifecycleContext);
    }

    /**
     * @param lifecycleContext
     */
    @Override
    public void prepareRender(LifecycleContext lifecycleContext) {
        dumpCall("prepareRender");
        super.prepareRender(lifecycleContext);
    }

    /**
     * @param lifecycleContext
     */
    @Override
    public void validateModelUpdates(LifecycleContext lifecycleContext) {
        dumpCall("validateModelUpdates");
        super.validateModelUpdates(lifecycleContext);
    }

    /**
     * @param lifecycleContext
     */
    @Override
    public void validateInputValues(LifecycleContext lifecycleContext) {
        dumpCall("validateInputValues");
        super.validateInputValues(lifecycleContext);
    }

    /**
     * @param lifecycleContext
     */
    @Override
    public void processUpdateModel(LifecycleContext lifecycleContext) {
        dumpCall("processUpdateModel");
        super.processUpdateModel(lifecycleContext);
    }

    /**
     * @param lifecycleContext
     */
    @Override
    public void applyInputValues(LifecycleContext lifecycleContext) {
        dumpCall("applyInputValues");
        super.applyInputValues(lifecycleContext);
    }

    private void dumpCall(String msg) {
        System.out.println("[" + counter + "] ### => " + msg);
        counter++;
    }

    /**
     * @param region
     * @return
     */
    public boolean refreshRegion(RegionContext region) {
        int refreshFlag = region.getRefreshFlag();
        if (refreshFlag == RegionBinding.PREPARE_MODEL) {
            dumpCall("refreshRegion.PREPARE_MODEL...");
        } else if (refreshFlag == RegionBinding.RENDER_MODEL) {
            dumpCall("refreshRegion.RENDER_MODEL...");
        } else if (refreshFlag == RegionBinding.EXECUTE_MODEL) {
            dumpCall("refreshRegion.EXECUTE_MODEL...");
        } else if (refreshFlag == RegionBinding.TYPE_EXECUTABLE_REGION) {
            dumpCall("refreshRegion.TYPE_EXECUTABLE_REGION...");
        }

        RegionBinding rb = region.getRegionBinding();
        rb.refresh(refreshFlag);

        return false;
    }

    /**
     * @param regionCtx
     * @return
     */
    public boolean validateRegion(RegionContext regionCtx) {
        dumpCall("validateRegion");
        return false;
    }

    /**
     * @param regionCtx
     * @return
     */
    public boolean isRegionViewable(RegionContext regionCtx) {
        dumpCall("isRegionViewable");
        return false;
    }

    /**
     * @return
     */
    public String getName() {
        dumpCall("getName");
        return "pageEditRegion";
    }

    /**
     * @param ctx
     */
    public void reportErrors(PageLifecycleContext ctx) {
        DCBindingContainer bc = (DCBindingContainer)ctx.getBindingContainer();
        if (bc != null) {
            List<Exception> exceptions = bc.getExceptionsList();
            if (exceptions != null) {
                Locale userLocale = 
                    ctx.getBindingContext().getLocaleContext().getLocale();
                /**
    * Iterate over the top-level exceptions in the exceptions list and
    * call addError() to add each one to the Faces errors list
    * in an appropriate way.
    */
                for (Exception exception : exceptions) {
                    try {
                        translateExceptionToFacesErrors(exception, userLocale, 
                                                        bc);
                    } catch (KnowErrorStopException stop) {
                        FacesContext fctx = FacesContext.getCurrentInstance();
                        fctx.addMessage(null, 
                                        JSFUtils.getMessageFromBundle(stop.getMessage(), 
                                                                      FacesMessage.SEVERITY_FATAL));
                        break;
                    }
                }
            }
        }
    }

    /**
     * @param ex
     * @param locale
     * @param bc
     * @throws KnowErrorStopException
     */
    protected void translateExceptionToFacesErrors(Exception ex, Locale locale, 
                                                   BindingContainer bc) throws KnowErrorStopException {
        List globalErrors = new ArrayList();
        Map attributeErrors = new HashMap();
        processException(ex, globalErrors, attributeErrors, null, locale);
        int numGlob = globalErrors.size();
        int numAttr = attributeErrors.size();
        if (numGlob > 0) {
            for (int z = 0; z < numGlob; z++) {
                String msg = (String)globalErrors.get(z);
                if (msg != null) {
                    JSFUtils.addFacesErrorMessage(msg);
                }
            }
        }
        if (numAttr > 0) {
            Iterator i = attributeErrors.keySet().iterator();
            while (i.hasNext()) {
                String attrNameKey = (String)i.next();

                /*
    * Only add the error to show to the user if it was related
    * to a field they can see on the screen. We accomplish this
    * by checking whether there is a control binding in the current
    * binding container by the same name as the attribute with
    * the related exception that was reported.
    */
                ControlBinding cb = 
                    ADFUtils.findControlBinding(bc, attrNameKey);
                if (cb != null) {
                    String msg = (String)attributeErrors.get(attrNameKey);
                    if (cb instanceof JUCtrlAttrsBinding) {
                        attrNameKey = ((JUCtrlAttrsBinding)cb).getLabel();
                    }
                    JSFUtils.addFacesErrorMessage(attrNameKey, msg);
                }
            }
        }
    }

    /**
     * Populate the list of global errors and attribute errors by
     * processing the exception passed in, and recursively processing
     * the detail exceptions wrapped inside of any oracle.jbo.JboException
     * instances.
     *
     * If the error is an attribute-level validation error, we can tell
     * because it should be an instanceof oracle.jbo.AttrValException
     * For each attribute-level error, we retrieve the name of the attribute
     * in error by calling an appropriate getter method on the exception
     * object which exposes this information to us. Since attribute-level
     * errors could be wrapping other more specific attribute-level errors
     * that were the real cause (especially due to Bundled Exception Mode).
     * We continue to recurse the detail exceptions and we only consider
     * relevant to report the exception that is the most deeply nested, since
     * it will have the most specific error message for the user. If multiple
     * exceptions are reported for the same attribute, we simplify the error
     * reporting by only reporting the first one and ignoring the others.
     * An example of this might be that the user has provided a key value
     * that is a duplicate of an existing value, but also since the attribute
     * set failed due to that reason, a subsequent check for mandatory attribute
     * ALSO raised an error about the attribute's still being null.
     *
     * If it's not an attribute-level error, we consider it a global error
     * and report each one.
     *
     * @param ex the exception to be analyzed
     * @param globalErrs list of global errors to populate
     * @param attrErrs map of attrib-level errors to populate, keyed by attr name
     * @param attrName attribute name of wrapping exception (if any)
     * @param locale the user's preferred locale as determined by the browser
     */
    private void processException(Exception ex, List globalErrs, Map attrErrs, 
                                  String attrName, 
                                  Locale locale) throws KnowErrorStopException {
        /*
    * Process the exceptions
    * Start with some special cases that are known bad situations where we
    * need to format some useful advice rather than just parroting the
    * exception text

    */
        if (!(ex instanceof JboException)) {
            String msg = ex.getLocalizedMessage();
            if (msg == null) {
                msg = firstLineOfStackTrace(ex, true);
            }
            globalErrs.add(msg);
            /*
    * If this was an unexpected error, print out stack trace
    */
            reportUnexpectedException(ex);
            return;
        }
        if (ex instanceof AttrValException) {
            AttrValException ave = (AttrValException)ex;
            attrName = ave.getAttrName();
            Object obj = attrErrs.get(attrName);

            /*
    * If we haven't already recorded an error for this attribute
    * and if it's a leaf detail, then log it as the first error for
    * this attribute. If there are details, then we'll recurse
    * into the details below. But, in the meantime we've recorded
    * What attribute had the validation error in the attrName
    */
            Object[] details = ave.getDetails();
            if (obj != null) {
                /*
    * We've already logged an attribute-validation error for this
    * attribute, so ignore subsequent attribute-level errors
    * for the same attribute. Note that this is not ignoring
    * NESTED errors of an attribute-level exception, just the
    * second and subsequent PEER errors of the first attribute-level
    * error. This means the user might receive errors on several
    * different attributes, but for each attribute we're choosing
    * to tell them about just the first problem to fix.
    */
                return;
            } else {
                /*
    * If there aren't any further, nested details, then log first error
    */
                if ((details == null) || (details.length == 0)) {
                    attrErrs.put(attrName, ave.getLocalizedMessage(locale));
                }
            }
        }
        JboException jboex = (JboException)ex;
        /*
    * It is a JboException so recurse into the exception tree
    */
        Object[] details = jboex.getDetails();
        /*
    * We only want to report Errors for the "leaf" exceptions
    * So if there are details, then don't add an errors to the lists
    */
        if ((details != null) && (details.length > 0)) {
            for (int j = 0, count = details.length; j < count; j++) {
                processException((Exception)details[j], globalErrs, attrErrs, 
                                 attrName, locale);
            }
        } else {
            /*
    * Add a new Error to the collection
    */
            if (attrName == null) {
                String errorCode = jboex.getErrorCode();
                globalErrs.add(jboex.getLocalizedMessage(locale));
            } else {
                attrErrs.put(attrName, jboex.getLocalizedMessage(locale));
            }
            if (!(jboex instanceof ValidationException)) {
                reportUnexpectedException(jboex);
            }
        }
    }

    /**
     * Prints the stack trace for an unexpected exception to standard out.
     *
     * @param ex The unexpected exception to report.
     */
    protected void reportUnexpectedException(Exception ex) {
        System.out.println("Unexpected exception");
    }

    /**
     * Picks off the exception name and the first line of information
     * from the stack trace about where the exception occurred and
     * returns that as a single string.
     */
    private String firstLineOfStackTrace(Exception ex, boolean logToError) {
        if (logToError) {
            System.out.println("Exception in error log");
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        System.out.println("Building exception information");
        LineNumberReader lnr = 
            new LineNumberReader(new StringReader(sw.toString()));
        try {
            String lineOne = lnr.readLine();
            String lineTwo = lnr.readLine();
            return lineOne + " " + lineTwo;
        } catch (IOException e) {
            return null;
        }
    }
}
