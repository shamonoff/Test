package devguide.examples.readonlyvo.client;
import oracle.jbo.client.Configuration;
import oracle.jbo.*;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.*;

public class TestClient {
    public static void main(String[] args) {
        String amDef = "devguide.examples.readonlyvo.PersonService";
        String config = "PersonServiceLocal";
        ApplicationModule am = 
            Configuration.createRootApplicationModule(amDef, config);
        ViewObject vo = am.findViewObject("PersonList");
         // Work with your appmodule and view object here
         System.out.println("Query will return "+
         vo.getEstimatedRowCount()+" rows...");
         vo.executeQuery();
         while (vo.hasNext()) {
         Row curPerson = vo.next();
         System.out.println(vo.getCurrentRowIndex()+". "+
         curPerson.getAttribute("PersonId")+" "+
         curPerson.getAttribute("Email"));
         }
        Configuration.releaseRootApplicationModule(am, true);
    }
}
