package oracle.fodemo.storefront.lookups.view.AllAddressesVO;

import java.util.Collection;

import oracle.fodemo.storefront.lookups.applicationModule.JUnitFixtureLoginInfoProvider;
import oracle.fodemo.storefront.lookups.applicationModule.LookupServiceAMFixture;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.client.Configuration;

import org.junit.*;
import static org.junit.Assert.*;

public class AllAddressesVOTest {
    JUnitFixtureLoginInfoProvider infoProvider = new JUnitFixtureLoginInfoProvider("ngreenbe", "welcome1");
    private ApplicationModule _am =  Configuration.createRootApplicationModule("oracle.fodemo.storefront.lookups.LookupServiceAM","LookupServiceAMLocal", infoProvider);

    public AllAddressesVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = _am.findViewObject("AllAddresses");
        assertNotNull(view);
    }
    
    @Test
    public void testQuery() {
        ViewObject view = _am.findViewObject("AllAddresses");
        view.setNamedWhereClauseParam("paramCustomerId", 108);
        view.executeQuery();
        String addressId = view.first().getAttribute("AddressId").toString();
        assertEquals("Address Id should be 3", addressId, "3");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        Configuration.releaseRootApplicationModule(_am, true);
    }
}
