package oracle.fodemo.storefront.lookups.applicationModule;

import oracle.fodemo.storefront.lookups.common.LookupServiceAM;

import org.junit.*;
import static org.junit.Assert.*;

public class LookupServiceAMTest {
    private LookupServiceAMFixture fixture1 = LookupServiceAMFixture.getInstance();


    public LookupServiceAMTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testFindHelpTextById() {
       LookupServiceAM am = (LookupServiceAM)fixture1.getApplicationModule();
       String helpText = am.findHelpTextById(new Long(101)).toString();
        assertEquals("Help text should start with 'Provide your personal information'", helpText.substring(0, 33), "Provide your personal information");
    }

    @Test
    public void testSetHelpId() {
        LookupServiceAM am = (LookupServiceAM)fixture1.getApplicationModule();
        String helpId = am.setHelpId("CREATE_PROFILE").toString();
        assertEquals("Help Id should be 101", helpId, "101");
    }
}
