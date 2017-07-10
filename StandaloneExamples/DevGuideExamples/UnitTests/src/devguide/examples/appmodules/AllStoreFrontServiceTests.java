package devguide.examples.appmodules;

import devguide.examples.appmodules.applicationModule.StoreFrontServiceAMFixture;
import devguide.examples.appmodules.applicationModule.StoreFrontServiceAMTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { StoreFrontServiceAMTest.class })
public class AllStoreFrontServiceTests {
    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        StoreFrontServiceAMFixture.getInstance().release();
    }
}
