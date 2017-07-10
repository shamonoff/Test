package devguide.advanced.xml.queries.view.CustomersViewVO;

import devguide.advanced.xml.queries.applicationModule.AppModuleAMFixture;

import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class CustomersViewVOTest {
    private AppModuleAMFixture fixture1 = AppModuleAMFixture.getInstance();

    public CustomersViewVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("CustomersView");
        assertNotNull(view);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
