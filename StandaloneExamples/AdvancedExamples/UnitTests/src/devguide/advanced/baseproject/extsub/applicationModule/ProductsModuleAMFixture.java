package devguide.advanced.baseproject.extsub.applicationModule;

import oracle.jbo.ApplicationModule;
import oracle.jbo.client.Configuration;

public class ProductsModuleAMFixture {
    private static ProductsModuleAMFixture fixture1 = new ProductsModuleAMFixture();
    private ApplicationModule _am;

    private ProductsModuleAMFixture() {
        _am = Configuration.createRootApplicationModule("devguide.advanced.baseproject.extsub.ProductsModule","ProductsModuleLocal");
    }

    public void setUp() {
    }

    public void tearDown() {
    }

    public static ProductsModuleAMFixture getInstance() {
        return fixture1;
    }

    public void release() throws Exception {
        Configuration.releaseRootApplicationModule(_am, true);
    }

    public ApplicationModule getApplicationModule() {
        return _am;
    }
}
