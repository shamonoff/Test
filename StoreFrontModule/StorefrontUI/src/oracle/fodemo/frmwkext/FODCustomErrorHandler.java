package oracle.fodemo.frmwkext;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCErrorHandlerImpl;

import oracle.fodemo.storefront.jsf.util.JSFUtils;

import oracle.jbo.DMLException;

import oracle.jbo.TxnValException;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;


/**
 * FODCustomErrorHandler.class.
 */


public class FODCustomErrorHandler extends DCErrorHandlerImpl {

    /**
     * @param setToThrow
     */
    public FODCustomErrorHandler(boolean setToThrow) {
        super(setToThrow);
    }
  
   public FODCustomErrorHandler() {        
        this(true);
    }


    /**
     * @param bc
     * @param ex
     */
    public void reportException(DCBindingContainer bc, Exception ex) {
        BindingContext ctx = bc.getBindingContext();
        String err_code = null;
        if ( ex instanceof TxnValException){
                // Handle JBO-27023
                err_code = ((TxnValException)ex).getErrorCode();
                if (new Integer(err_code).intValue() == 27023 ){
                this.getDisplayMessage(ctx, ex);
                } 
        }
        if (ex instanceof oracle.jbo.DMLException){
                // Handle JBO-26061
                err_code = ((DMLException)ex).getErrorCode();
                if (new Integer(err_code).intValue() == 26061){
                    ExtendedRenderKitService erks = Service.getRenderKitService(
                    FacesContext.getCurrentInstance(),ExtendedRenderKitService.class);
                    
                    // get the message from UIString_en.properties
                    String alertMessage = JSFUtils.getStringFromBundle("database.connect.failure");                    
                    erks.addScript(FacesContext.getCurrentInstance(),"alert('"+alertMessage+"');");    
                }
        }
        else{
            super.reportException(bc,ex);  
        }
    }

    /**
     * @param ctx
     * @param th
     * @return
     */
    @Override
    public String getDisplayMessage(BindingContext ctx, Exception th) {
        return super.getDisplayMessage(ctx, th);
    }
}

