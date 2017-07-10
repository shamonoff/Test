package devguide.advanced.storedproc.applicationModule;

import oracle.jbo.ApplicationModule;
import oracle.jbo.client.Configuration;

import org.junit.*;

public class StoredProcTestModuleAMTest {
    private ApplicationModule am;

    public StoredProcTestModuleAMTest() {
    }

    @Before
    public void setUp() {
        am = Configuration.createRootApplicationModule("devguide.advanced.storedproc.StoredProcTestModule","StoredProcTestModuleLocal");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCallProcWithThreeArgs() {
    }

    @Test
    public void testCallProcWithOutArgs() {
    }

    @Test
    public void testCallProcWithNoArgs() {
    }

    @Test
    public void testCallFuncWithThreeArgs() {
    }
}
