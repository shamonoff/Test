package devguide.examples.readonlyvo.view.PersonListVO;

import devguide.examples.readonlyvo.applicationModule.PersonServiceAMFixture;

import devguide.examples.readonlyvo.queries.PersonsImpl;

import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class PersonListVOTest {
    private PersonServiceAMFixture fixture1 = PersonServiceAMFixture.getInstance();

    public PersonListVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("PersonList");
        assertNotNull(view);
    }
    
    @Test
    public void testShortName(){
        PersonsImpl view = (PersonsImpl)fixture1.getApplicationModule().findViewObject("PersonList");
        view.setTheName("Nancy");
        String name = (String)view.first().getAttribute("ShortName");
        assertEquals("ShortName should be N. Greenberg", "N. Greenberg", name);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
