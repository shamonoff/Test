package devguide.examples.appmodules.applicationModule;

import oracle.jbo.ApplicationModule;
import oracle.jbo.client.Configuration;

public class StoreFrontServiceAMFixture {
    private static StoreFrontServiceAMFixture fixture1 = new StoreFrontServiceAMFixture();
    private ApplicationModule _am;

    private StoreFrontServiceAMFixture() {
        _am = Configuration.createRootApplicationModule("devguide.examples.appmodules.StoreFrontService","StoreFrontServiceLocal");
    }

    public void setUp() {
    }

    public void tearDown() {
    }

    public static StoreFrontServiceAMFixture getInstance() {
        return fixture1;
    }

    public void release() throws Exception {
        Configuration.releaseRootApplicationModule(_am, true);
    }

    public ApplicationModule getApplicationModule() {
        return _am;
    }
}
