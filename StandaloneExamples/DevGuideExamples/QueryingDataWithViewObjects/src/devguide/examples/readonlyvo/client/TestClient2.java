package devguide.examples.readonlyvo.client;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

public class TestClient2 {
  public static void main(String[] args) {
      String amDef = "devguide.examples.readonlyvo.PersonService";
      String config = "PersonServiceLocal";
      ApplicationModule am = 
          Configuration.createRootApplicationModule(amDef, config);
      ViewObject vo = am.findViewObject("PersonList");
    // Add an extra where clause with a new named bind variable
      vo.setWhereClause("person_type_code = :ThePersonType");
      vo.defineNamedWhereClauseParam("ThePersonType", null, null);
      vo.setNamedWhereClauseParam("ThePersonType", "CUST");
    // Show results when :ThePersonType = 'CUST'
    executeAndShowResults(vo);
    Configuration.releaseRootApplicationModule(am, true);
  }
  private static void executeAndShowResults(ViewObject vo) {
    System.out.println("---");
    vo.executeQuery();
    while (vo.hasNext()) {
      Row curPerson = vo.next();
      // Access the row set of details using the view link accessor attribute
      RowSet orders = (RowSet)curPerson.getAttribute("OrdersShippedToPurchaser");
      long numOrders = orders.getEstimatedRowCount();
      System.out.println(curPerson.getAttribute("PersonId") + " " + 
                         curPerson.getAttribute("Email")+" ["+
                         numOrders+" orders]");
      while (orders.hasNext()) {
        Row curOrder = orders.next();
        System.out.println("--> (" + curOrder.getAttribute("OrderId") + ") " + 
                           curOrder.getAttribute("OrderTotal"));
      }
    }
  }
}
