package devguide.advanced.simpledomains.view.PersonsVO;

import devguide.advanced.simpledomains.applicationModule.PersonModuleAMFixture;

import oracle.jbo.JboException;
import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class PersonsVOTest {
    private PersonModuleAMFixture fixture1 = PersonModuleAMFixture.getInstance();

    public PersonsVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("Persons");
        assertNotNull(view);
    }

    @Test    
    public void testShortEmail() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("Persons");
        try {
            view.first().setAttribute("Email", "SKING@");
        }
        catch (JboException ex) {
        assertEquals("Exception should be JBO-30002", ex.getErrorCode(), "30002");
        }
    }
    
    @Test
    public void testEvenNumber() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("Persons");
        try {
            view.first().setAttribute("AnExtraValue", "1");
        }
        catch (JboException ex) {
        assertEquals("Exception should be JBO-30003", ex.getErrorCode(), "30003");
        }
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
