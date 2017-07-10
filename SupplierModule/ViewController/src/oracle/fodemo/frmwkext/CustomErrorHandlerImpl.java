package oracle.fodemo.frmwkext;

import javax.ejb.TransactionRolledbackLocalException;

import oracle.adf.model.BindingContext;
import oracle.adf.model.RegionBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCErrorHandlerImpl;
import oracle.adf.model.binding.DCErrorMessage;

import oracle.jbo.JboException;


public class CustomErrorHandlerImpl extends DCErrorHandlerImpl {
    public CustomErrorHandlerImpl(boolean b) {
        super(b);
    }

    public CustomErrorHandlerImpl() {
        super(true);
    }

    /**
     * @param bc
     * @param ex
     */
    @Override
    public void reportException(DCBindingContainer bc, Exception ex) {
        BindingContext ctx = bc.getBindingContext();
        ex = (Exception)getRootException(ex);
        disableAppendCodes(ex);
        super.reportException(bc, ex);
    }

    private void disableAppendCodes(Exception ex) {
        if (ex instanceof JboException) {
            JboException jboEx = (JboException)ex;
            jboEx.setAppendCodes(false);
            Object[] detailExceptions = jboEx.getDetails();
            if ((detailExceptions != null) && (detailExceptions.length > 0)) {
                for (int z = 0, numEx = detailExceptions.length; z < numEx;
                     z++) {
                    disableAppendCodes((Exception)detailExceptions[z]);
                }
            }
        }
    }

    public Throwable getRootException(Throwable ex) {
        Throwable rtEx = null;
        if ((rtEx = ex.getCause()) == null) {
            return ex;
        } else {
            return getRootException(rtEx);
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

    /**
     * Returns application specific details about the given exception. This exception
     * should be formatted as per the associated view layer requirements. Default implementation
     * returns null.
     *
     * displayed in the detail panel of an exception dialog.
     * @param ctx BindingContext for the usage that raised this exception.
     * @param ctr BindingContainer that is associated with the UI that caused this exception.
     * @param ex  Exception for which detailed display message is asked for.
     */
    @Override
    public DCErrorMessage getDetailedDisplayMessage(BindingContext ctx,
                                                    RegionBinding ctr,
                                                    Exception ex) {
        return super.getDetailedDisplayMessage(ctx, ctr, ex);
    }

    /**
     * If an exception is a RowValException or a TxnValException
     * and they have nested exceptions, then do not display
     * it.
     */
    @Override
    protected boolean skipException(Exception jboEx) {
        return super.skipException(jboEx);
    }

    /**
     * @internal *** For internal framework use only ***
     */
    @Override
    public void setThrowFlag(boolean flag) {
        super.setThrowFlag(flag);
    }
}
