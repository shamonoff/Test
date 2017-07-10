package devguide.advanced.customprops.applicationModule;

import oracle.jbo.ApplicationModule;
import oracle.jbo.client.Configuration;

public class ProductModuleAMFixture {
    private static ProductModuleAMFixture fixture1 = new ProductModuleAMFixture();
    private ApplicationModule _am;

    private ProductModuleAMFixture() {
        _am = Configuration.createRootApplicationModule("devguide.advanced.customprops.ProductModule","ProductModuleLocal");
    }

    public void setUp() {
    }

    public void tearDown() {
    }

    public static ProductModuleAMFixture getInstance() {
        return fixture1;
    }

    public void release() throws Exception {
        Configuration.releaseRootApplicationModule(_am, true);
    }

    public ApplicationModule getApplicationModule() {
        return _am;
    }
}
