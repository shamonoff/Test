package devguide.examples.readonlyvo.client;

import devguide.examples.readonlyvo.queries.common.PersonsRow;

import oracle.jbo.*;
import oracle.jbo.client.Configuration;
import oracle.jbo.domain.*;
import oracle.jbo.domain.Number;

public class TestClient3 {
    public static void main(String[] args) {
        String amDef = "devguide.examples.readonlyvo.PersonService";
        String config = "PersonServiceLocal";
        ApplicationModule am = 
            Configuration.createRootApplicationModule(amDef, config);
        ViewObject vo = am.findViewObject("PersonList");
        // Work with your appmodule and view object here
        vo.executeQuery();
        while (vo.hasNext()) {
          // Cast next() to a strongly-typed UsersRow interface 
          PersonsRow curPerson = (PersonsRow)vo.next();
          Number personId = curPerson.getPersonId();
          String email  = curPerson.getEmail();
          System.out.println(personId+ " " + email);
        }
        Configuration.releaseRootApplicationModule(am, true);
    }
}
