package devguide.advanced.simpledomains.applicationModule;

import oracle.jbo.ApplicationModule;
import oracle.jbo.client.Configuration;

public class PersonModuleAMFixture {
    private static PersonModuleAMFixture fixture1 = new PersonModuleAMFixture();
    private ApplicationModule _am;

    private PersonModuleAMFixture() {
        _am = Configuration.createRootApplicationModule("devguide.advanced.simpledomains.PersonModule","PersonModuleLocal");
    }

    public void setUp() {
    }

    public void tearDown() {
    }

    public static PersonModuleAMFixture getInstance() {
        return fixture1;
    }

    public void release() throws Exception {
        Configuration.releaseRootApplicationModule(_am, true);
    }

    public ApplicationModule getApplicationModule() {
        return _am;
    }
}
