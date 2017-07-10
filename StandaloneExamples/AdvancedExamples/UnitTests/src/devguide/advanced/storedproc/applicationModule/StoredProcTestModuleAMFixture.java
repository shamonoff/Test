package devguide.advanced.storedproc.applicationModule;

import oracle.jbo.ApplicationModule;
import oracle.jbo.client.Configuration;

public class StoredProcTestModuleAMFixture {
    private static StoredProcTestModuleAMFixture fixture1 = new StoredProcTestModuleAMFixture();
    private ApplicationModule _am;

    private StoredProcTestModuleAMFixture() {
        _am = Configuration.createRootApplicationModule("devguide.advanced.storedproc.StoredProcTestModule","StoredProcTestModuleLocal");
    }

    public void setUp() {
    }

    public void tearDown() {
    }

    public static StoredProcTestModuleAMFixture getInstance() {
        return fixture1;
    }

    public void release() throws Exception {
        Configuration.releaseRootApplicationModule(_am, true);
    }

    public ApplicationModule getApplicationModule() {
        return _am;
    }
}
