package devguide.examples.readonlyvo.client;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;
import oracle.jbo.domain.Number;

public class TestClientBindVars {
  public static void main(String[] args) {
      String amDef = "devguide.examples.readonlyvo.PersonService";
      String config = "PersonServiceLocal";
      ApplicationModule am = 
          Configuration.createRootApplicationModule(amDef, config);
      ViewObject vo = am.findViewObject("PersonList");
    // Set the two design time named bind variables
      vo.setNamedWhereClauseParam("TheName","shelli%");
      vo.setNamedWhereClauseParam("HighUserId", new Number(215));
    executeAndShowResults(vo);
    // Add an extra where clause with a new named bind variable
    vo.setWhereClause("person_id = :ThePersonId");
    vo.defineNamedWhereClauseParam("ThePersonId", null, null);
    vo.setNamedWhereClauseParam("ThePersonId", new Number(116));
    executeAndShowResults(vo);
    vo.removeNamedWhereClauseParam("ThePersonId");
    // Add an extra where clause with a new named bind variable
    vo.setWhereClause("person_type_code = :ThePersonType");
    vo.defineNamedWhereClauseParam("ThePersonType", null, null);
    vo.setNamedWhereClauseParam("ThePersonType", "SUPP");
    // Show results when :ThePersonType = 'SUPP'
    executeAndShowResults(vo);
    vo.setNamedWhereClauseParam("ThePersonType", "CUST");
    // Show results when :ThePersonType = 'CUST'
    executeAndShowResults(vo);
    Configuration.releaseRootApplicationModule(am, true);
  }
  private static void executeAndShowResults(ViewObject vo) {
    System.out.println("---");
    vo.executeQuery();
    while (vo.hasNext()) {
      Row curUser = vo.next();
      System.out.println(curUser.getAttribute("PersonId") + " " + 
                         curUser.getAttribute("ShortName"));
    }
  }
}
