package devguide.advanced.refcursor.applicationModule;

import oracle.jbo.ApplicationModule;
import oracle.jbo.client.Configuration;

public class OrdersModuleAMFixture {
    private static OrdersModuleAMFixture fixture1 = new OrdersModuleAMFixture();
    private ApplicationModule _am;

    private OrdersModuleAMFixture() {
        _am = Configuration.createRootApplicationModule("devguide.advanced.refcursor.OrdersModule","OrdersModuleLocal");
    }

    public void setUp() {
    }

    public void tearDown() {
    }

    public static OrdersModuleAMFixture getInstance() {
        return fixture1;
    }

    public void release() throws Exception {
        Configuration.releaseRootApplicationModule(_am, true);
    }

    public ApplicationModule getApplicationModule() {
        return _am;
    }
}
