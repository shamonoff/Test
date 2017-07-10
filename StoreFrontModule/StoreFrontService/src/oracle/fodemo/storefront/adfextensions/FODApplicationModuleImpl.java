package oracle.fodemo.storefront.adfextensions;

import java.sql.CallableStatement;
import java.sql.SQLException;

import oracle.jbo.JboException;
import oracle.jbo.Session;
import oracle.jbo.common.PropertyMetadata;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.DBTransactionImpl;

public class FODApplicationModuleImpl extends ApplicationModuleImpl {

public static String preferredLanguage;
public static boolean isWebUser=false;
private String[] supportedLanguages = {"EN","JA","EL","FR","DE"};

    /**
     * @param session
     */
    @Override
    protected void prepareSession(Session session) {
        super.prepareSession(session);
        setCurrentUserLanguage();
    }
    
    public void setCurrentUserLanguage(){
        DBTransactionImpl dbti = (DBTransactionImpl)getDBTransaction();
        CallableStatement statement =
            dbti.createCallableStatement(("BEGIN " + "user_context_pkg.set_app_user_lang(?); " +
                                          "END;"), 0);
        try {
            statement.setString(1, getApplicationLanguage());
            statement.execute();
        } catch (SQLException sqlerr) {
            throw new JboException(sqlerr);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException closeerr) {
                throw new JboException(closeerr);
            }
        }
    }

    /**
     * @return
     */
    public String getApplicationLanguage(){
        String appLanguage = "EN";
        if (isWebUser){
        for (int index=0; index<supportedLanguages.length; index++){
            if (preferredLanguage.equals(supportedLanguages[index])){
                appLanguage = preferredLanguage;
            break;
            }
        }
        } else{
            appLanguage = getAMLanguage();
        }
            return appLanguage;
    }

    /**
     * @return
     */
    public String getAMLanguage(){
        PropertyMetadata langProperty = PropertyMetadata.findProperty("jbo.default.language");
        String amLanguage = langProperty.getProperty();
        return amLanguage.toUpperCase();
    }
}
