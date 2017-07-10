package devguide.advanced.postingorder.applicationModule;

import oracle.jbo.ApplicationModule;
import oracle.jbo.client.Configuration;

public class PostModuleAMFixture {
    private static PostModuleAMFixture fixture1 = new PostModuleAMFixture();
    private ApplicationModule _am;

    private PostModuleAMFixture() {
        _am = Configuration.createRootApplicationModule("devguide.advanced.postingorder.PostModule","PostModuleLocal");
    }

    public void setUp() {
    }

    public void tearDown() {
    }

    public static PostModuleAMFixture getInstance() {
        return fixture1;
    }

    public void release() throws Exception {
        Configuration.releaseRootApplicationModule(_am, true);
    }

    public ApplicationModule getApplicationModule() {
        return _am;
    }
}
