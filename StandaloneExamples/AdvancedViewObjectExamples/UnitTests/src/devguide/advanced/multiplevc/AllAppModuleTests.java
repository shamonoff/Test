package devguide.advanced.multiplevc;

import devguide.advanced.multiplevc.applicationModule.AppModuleAMFixture;
import devguide.advanced.multiplevc.view.PersonsViewVO.PersonsViewVOTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { PersonsViewVOTest.class })
public class AllAppModuleTests {
    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        AppModuleAMFixture.getInstance().release();
    }
}
