package devguide.advanced.inmemoryops.client;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;
import oracle.jbo.domain.Number;

public class TestClientSetSortBy {
    public static void main(String[] args) {
      String        amDef = "devguide.advanced.inmemoryops.AppModule";
      String        config = "AppModuleLocal";
      ApplicationModule am =
      Configuration.createRootApplicationModule(amDef,config);
      // Uncomment this line to generate SQL Trace Information
      // am.getTransaction().executeCommand("ALTER SESSION SET SQL_TRACE TRUE");
      ViewObject vo = am.findViewObject("ClosedOrders");
      vo.executeQuery();
      showRows(vo,"Initial database results");
      vo.setSortBy("Customer desc");
      vo.setQueryMode(ViewObject.QUERY_MODE_SCAN_VIEW_ROWS);
      vo.executeQuery();
      showRows(vo,"After in-memory sorting by Customer desc");
      vo.setSortBy("Customer desc, DaysOpen");
      vo.executeQuery();
      showRows(vo,"After in-memory sorting by Customer desc, DaysOpen");
      Configuration.releaseRootApplicationModule(am,true);
    }
    private static void showRows(ViewObject vo, String comment) {
      System.out.println("--- "+comment+" ---");
      while (vo.hasNext()) {
        Row r = vo.next();
        Number n = (Number)r.getAttribute("OrderId");
        String g = (String)r.getAttribute("GiftwrapMessage");
        String c = (String)r.getAttribute("Customer");
        Number d = (Number)r.getAttribute("DaysOpen");
        System.out.println(n+","+g+","+d+","+c);
      }
    }
    }
