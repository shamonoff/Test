package oracle.fodemo.storefront.lookups.view.BillingAddressesVO;

import oracle.fodemo.storefront.lookups.applicationModule.JUnitFixtureLoginInfoProvider;
import oracle.fodemo.storefront.lookups.applicationModule.LookupServiceAMFixture;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.client.Configuration;

import org.junit.*;
import static org.junit.Assert.*;

public class BillingAddressesVOTest {
    JUnitFixtureLoginInfoProvider infoProvider = new JUnitFixtureLoginInfoProvider("ngreenbe", "welcome1");
    private ApplicationModule _am =  Configuration.createRootApplicationModule("oracle.fodemo.storefront.lookups.LookupServiceAM","LookupServiceAMLocal", infoProvider);

    public BillingAddressesVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = _am.findViewObject("BillingAddresses");
        assertNotNull(view);
    }
    
    @Test
    public void testQuery() {
        ViewObject view = _am.findViewObject("BillingAddresses");
        Row[] allRows = view.getAllRowsInRange();
        for (Row row : allRows) {
            String typeCode = row.getAttribute("UsageTypeCode").toString();
            assertEquals("Address type should be IN", "IN", typeCode);
        }
    }
    

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        Configuration.releaseRootApplicationModule(_am, true);
    }
}
