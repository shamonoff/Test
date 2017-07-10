package oracle.fodemo.storefront.lookups.client;

import oracle.fodemo.storefront.lookups.common.LookupServiceAM;

import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Nov 12 17:07:05 MST 2008
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LookupServiceAMClient extends ApplicationModuleImpl implements LookupServiceAM {
    /**
     * This is the default constructor (do not remove).
     */
    public LookupServiceAMClient() {
    }


    /**
     * @param theHelpId
     * @return
     */
    public String findHelpTextById(Long theHelpId) {
        Object _ret =
            this.riInvokeExportedMethod(this,"findHelpTextById",new String [] {"java.lang.Long"},new Object[] {theHelpId});
        return (String)_ret;
    }

    /**
     * @param usage
     * @return
     */
    public Long setHelpId(String usage) {
        Object _ret =
            this.riInvokeExportedMethod(this,"setHelpId",new String [] {"java.lang.String"},new Object[] {usage});
        return (Long)_ret;
    }
}
