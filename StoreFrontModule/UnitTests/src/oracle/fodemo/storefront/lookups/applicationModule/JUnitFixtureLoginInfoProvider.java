package oracle.fodemo.storefront.lookups.applicationModule;

import oracle.jbo.common.ampool.EnvInfoProvider;
import java.util.Hashtable;

import oracle.jbo.JboContext;

public class JUnitFixtureLoginInfoProvider implements EnvInfoProvider {
      String mUsername;
      String mPassword;

    /**
       * Constructor.
       *
       * @param mUsername JAAS username to use for the test
       * @param mPassword JAAS password to use for the test
       */
    
    public JUnitFixtureLoginInfoProvider(String mUsername, String mPassword) {
        super();
        this.mUsername = mUsername;
        this.mPassword = mPassword;
    }



    /**
     * Implementation of the EnvInfoProvider getInfo() method to force
     * the jbo.security.enforce property to be in the environment, along
     * with the test-supplied JAAS username/password.
     *
     * @param info string key
     * @param environment environment hashtable
     * @return value of string key
     */
      public Object getInfo(String info, Object environment) {
        Hashtable env = (Hashtable)environment;
        /*
            * The environment property below indicates authentication is needed.
            * For ADFBC it is set in ApplicationModule Configuration Properties
            * which goes into bc4j.xcfg file in the "./common" subdirectory
            * of the package where your application module's XML component
            * definition file lives.
            */
        env.put("jbo.security.enforce", "Must");
        env.put(JboContext.SECURITY_PRINCIPAL, mUsername);
        env.put(JboContext.SECURITY_CREDENTIALS, mPassword);
        return null;
      }

      /**
       * Implementing EnvInfoProvider interface.
       * @param environment JNDI environment
       */
      public void modifyInitialContext(Object environment) {
      }

      /**
       * Implementing EnvInfoProvider interface.
       * @return number of retries allowed
       */
      public int getNumOfRetries() {
        return 1;
      }
    }