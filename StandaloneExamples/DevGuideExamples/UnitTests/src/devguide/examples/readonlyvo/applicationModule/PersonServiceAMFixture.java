package devguide.examples.readonlyvo.applicationModule;

import oracle.jbo.ApplicationModule;
import oracle.jbo.client.Configuration;

public class PersonServiceAMFixture {
    private static PersonServiceAMFixture fixture1 = new PersonServiceAMFixture();
    private ApplicationModule _am;

    private PersonServiceAMFixture() {
        _am = Configuration.createRootApplicationModule("devguide.examples.readonlyvo.PersonService","PersonServiceLocal");
    }

    public void setUp() {
    }

    public void tearDown() {
    }

    public static PersonServiceAMFixture getInstance() {
        return fixture1;
    }

    public void release() throws Exception {
        Configuration.releaseRootApplicationModule(_am, true);
    }

    public ApplicationModule getApplicationModule() {
        return _am;
    }
}
