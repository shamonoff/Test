package devguide.advanced.postingorder;

import devguide.advanced.postingorder.applicationModule.PostModuleAMFixture;
import devguide.advanced.postingorder.applicationModule.PostModuleAMTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { PostModuleAMTest.class })
public class AllPostModuleTests {
    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        PostModuleAMFixture.getInstance().release();
    }
}
