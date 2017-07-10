package oracle.fodemo.storefront.servlet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;


public class ImageServlet extends HttpServlet {
    private static final String CONTENT_TYPE = 
        "image/jpg; charset=utf-8";

    /**
     * @param config
     * @throws ServletException
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, 
                                                           IOException {
        response.setContentType(CONTENT_TYPE);
        response.setContentType(CONTENT_TYPE);
        String detailProductId = request.getParameter("detail");
        String thumbnailProductId = request.getParameter("thumbnail");
        boolean thumbnail = true;
        String productId = null;
        OutputStream os = response.getOutputStream();
        Connection conn = null; 
        
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/FODDS");
            conn = ds.getConnection();
            PreparedStatement statement = conn.prepareStatement(
              "SELECT ProductImageEO.PRODUCT_IMAGE_ID, " + 
              "       ProductImageEO.PRODUCT_ID, " + 
              "       ProductImageEO.DEFAULT_VIEW_FLAG, " + 
              "       ProductImageEO.DETAIL_IMAGE_ID, " + 
              "       ProductImageEO.IMAGE " + 
              "FROM  PRODUCT_IMAGES ProductImageEO " +
              "WHERE ProductImageEO.DEFAULT_VIEW_FLAG = ?" + 
              "      AND ProductImageEO.PRODUCT_ID = ?");

            if (detailProductId != null) {
                productId = detailProductId;
                thumbnail = false;
            } else {
                productId = thumbnailProductId;
    
            }
    
            statement.setString(1,(thumbnail ? "Y" : "N"));            
            statement.setInt(2, new Integer(productId));
            ResultSet rs = statement.executeQuery(); 
            
            if (rs.next()) { 
                Blob blob = rs.getBlob("IMAGE"); 
                BufferedInputStream in = new BufferedInputStream(blob.getBinaryStream()); 
                int b; byte[] buffer = new byte[10240]; 
                while ((b = in.read(buffer, 0, 10240)) != -1) { os.write(buffer, 0, b); } 
                os.close();
            }
        } catch (Exception e){
            System.out.println(e);
        } finally {
            try{
                if (conn != null){
                     conn.close();
                }
             } catch (SQLException sqle){
                 System.out.println("SQLException error");
             }  
        }
    }
}
