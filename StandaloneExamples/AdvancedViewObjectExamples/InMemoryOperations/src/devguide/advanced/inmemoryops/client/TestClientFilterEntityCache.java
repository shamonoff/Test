package devguide.advanced.inmemoryops.client;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

public class TestClientFilterEntityCache {
    public static void main(String[] args) {
      String amDef = "devguide.advanced.inmemoryops.AppModule";
      String config = "AppModuleLocal";
      ApplicationModule am = Configuration.createRootApplicationModule(amDef, config);
      // Uncomment this line to generate SQL Trace Information
      // am.getTransaction().executeCommand("ALTER SESSION SET SQL_TRACE TRUE");
      ViewObject vo = am.findViewObject("CreateProductTranslations");
      vo.setAssociationConsistent(false);
      Row newProd1 = vo.createRow();
      newProd1.setAttribute("ProductId","1111");
      newProd1.setAttribute("Language", "US");
      newProd1.setAttribute("Description","First of the new products");
      vo.insertRow(newProd1);
      Row newProd2 = vo.createRow();
      newProd2.setAttribute("ProductId","1112");
      newProd2.setAttribute("Language", "US");
      newProd2.setAttribute("Description","Product with interesting features");
      vo.insertRow(newProd2);    
      vo.clearCache();
      showRows(vo,"After adding two new entities and clearing the VO cache");
      vo.setQueryMode(ViewObject.QUERY_MODE_SCAN_ENTITY_ROWS);
      ViewCriteria vc = vo.createViewCriteria();
      ViewCriteriaRow vcr = vc.createViewCriteriaRow();
      vcr.setAttribute("Description","LIKE '%interesting%'");
      vc.add(vcr);
      vo.applyViewCriteria(vc);
      vc.setCriteriaMode(ViewCriteria.CRITERIA_MODE_CACHE);
    //    vo.setRowMatch(new RowMatch("Description LIKE '%interesting%'"));
      vo.executeQuery();
      showRows(vo,"After performing in-memory query over EO cache");
      Configuration.releaseRootApplicationModule(am, true);
    }
    private static void showRows(RowSet rs, String comment) {
      System.out.println("--- " + comment + " ---");
      rs.reset();
      while (rs.hasNext()) {
        Row r = rs.next();
        String n = (String)r.getAttribute("ProductId").toString();
        String d = (String)r.getAttribute("Description");
        System.out.println(n + ", " + d);
      }
    }
    }
