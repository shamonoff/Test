package devguide.advanced.storedproc;

import devguide.advanced.storedproc.applicationModule.StoredProcTestModuleAMFixture;
import devguide.advanced.storedproc.applicationModule.StoredProcTestModuleAMTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { StoredProcTestModuleAMTest.class })
public class AllStoredProcTestModuleTests {
    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        StoredProcTestModuleAMFixture.getInstance().release();
    }
}
