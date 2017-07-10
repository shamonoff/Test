package oracle.fodemo.storefront.lookups.applicationModule;

import oracle.jbo.ApplicationModule;
import oracle.jbo.client.Configuration;

public class LookupServiceAMFixture {
    private ApplicationModule _am;
    
    private String un = "ngreenbe";
    private String pw = "welcome1";


    public LookupServiceAMFixture(String username, String password) {
        JUnitFixtureLoginInfoProvider infoProvider = new JUnitFixtureLoginInfoProvider(un, pw);
        _am = Configuration.createRootApplicationModule("oracle.fodemo.storefront.lookups.LookupServiceAM","LookupServiceAMLocal", infoProvider);
        _am.getTransaction().setBundledExceptionMode(true);

    }

    public void setUp() {
    }

    public void tearDown() {
        Configuration.releaseRootApplicationModule(_am, true);
    }

    public static LookupServiceAMFixture getInstance() {
      return new LookupServiceAMFixture("ngreenbe","welcome1");
    }
    

    public void release() throws Exception {
        Configuration.releaseRootApplicationModule(_am, true);
    }

    public ApplicationModule getApplicationModule() {
        return _am;
    }
}
