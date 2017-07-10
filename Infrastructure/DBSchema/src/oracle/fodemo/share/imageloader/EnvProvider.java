package oracle.fodemo.share.imageloader;

import java.util.Hashtable;

import oracle.jbo.client.Configuration;
import oracle.jbo.common.ampool.EnvInfoProvider;
  
   /**
    * $id:$
    * Custom EnvInfoProvider implementation used to allow dynamic passing 
    * of Application Module configuration information. 
    * This allows us to pass a username, password and connection information 
    * from Ant into the AM that loads the images into the database
    */

public class EnvProvider implements EnvInfoProvider{
      private final String mJDBCUrl; 
      private final String mUser; 
      private final String mPassword; 
 


      public EnvProvider(String JDBCUrl, String User, String Password) {
        mJDBCUrl = JDBCUrl;
        mUser = User;
        mPassword = Password;
      }

    /**
     * Overridden framework method to set custom values in the
     * environment hashtable.
     *
     * @param string - ignore
     * @param environment Hashtable of config parameters
     * @return null - not used
     */
    public Object getInfo(String string, Object environment) {
    Hashtable envHashtable = (Hashtable)environment;
    
    envHashtable.put(Configuration.DB_CONNECT_STRING_PROPERTY,mJDBCUrl);
    envHashtable.put(Configuration.DB_USERNAME_PROPERTY,mUser);
    envHashtable.put(Configuration.DB_PASSWORD_PROPERTY,mPassword);
//
//    envHashtable.put(Configuration.DB_CONNECT_STRING_PROPERTY,"jdbc:oracle:thin:@localhost:1521:XE");
//    envHashtable.put(Configuration.DB_USERNAME_PROPERTY,"fod");
//    envHashtable.put(Configuration.DB_PASSWORD_PROPERTY,"fusion");

    return null;
    }
    /* Required to implement EnvInfoProvider */
    public void modifyInitialContext(Object object) {}
    /* Required to implement EnvInfoProvider */
    public int getNumOfRetries() {return 0;}
}
