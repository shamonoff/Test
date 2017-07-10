package devguide.advanced.simpledomains;

import devguide.advanced.simpledomains.applicationModule.PersonModuleAMFixture;
import devguide.advanced.simpledomains.view.PersonsVO.PersonsVOTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { PersonsVOTest.class })
public class AllPersonModuleTests {
    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        PersonModuleAMFixture.getInstance().release();
    }
}
