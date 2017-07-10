package oracle.fodemo.product.backing;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.fodemo.supplier.model.Product;
import oracle.fodemo.supplier.model.ProductImage;
import oracle.fodemo.supplier.view.utils.ADFUtils;
import oracle.fodemo.supplier.view.utils.JSFUtils;

import org.apache.myfaces.trinidad.model.UploadedFile;


public class ProductDeatilsBean {

    private UploadedFile productImage;
    private ProductImage _productImage;

    public ProductDeatilsBean() {
    }


    public void setProductImage(UploadedFile productImage) {
        this.productImage = productImage;
    }

    public UploadedFile getProductImage() {

        return productImage;
    }


    private boolean executeOperationBinding(String methodAction, Map param) {
        OperationBinding ob = ADFUtils.findOperation(methodAction);

        if (param != null) {
            Map paramOps = ob.getParamsMap();
            paramOps.putAll(param);
        }
        Object result = ob.execute();
        if (!ob.getErrors().isEmpty()) {
            JSFUtils.addFacesErrorMessage("An error occured while serving your request.");
            ADFUtils.printOperationBindingExceptions(ob.getErrors());
            return false;
        }
        return true;
    }

    private void createNewProductImage(Timestamp now, Product product) {
        ProductImage pi = new ProductImage();
        pi.setImage(getImageBytes());
        pi.setProduct(product);
        pi.setDefaultViewFlag("N");

        if (product.getProductImageList() == null) {
            product.setProductImageList(new ArrayList<ProductImage>());
        }
        product.addProductImage(pi);
    }

    private byte[] getImageBytes() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        InputStream in = null;
        try {
            in = productImage.getInputStream();

            int b;
            byte[] buffer = new byte[10240];
            while ((b = in.read(buffer, 0, 10240)) != -1) {
                bos.write(buffer, 0, b);
            }

            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException ioe) {
                System.err.println("Could not close stream.");
                ioe.printStackTrace();
            }
        }
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void fileUploadListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        Timestamp now = new Timestamp(System.currentTimeMillis());
        productImage = (UploadedFile)valueChangeEvent.getNewValue();
        Product product =
            (Product)JSFUtils.resolveExpression("#{bindings.findProductById.result}");

        _productImage =
                (ProductImage)JSFUtils.resolveExpression("#{bindings.findProductById.result.productImageList[0]}");
        if (productImage != null) {
            if (_productImage != null) {
                // System.out.println("_productImage.getProductImageId()::" +
                //                    _productImage.getProductImageId());
                _productImage.setImage(getImageBytes());

            } else {
                // create a new one

                createNewProductImage(now, product);
            }
        } else {
            System.out.println("productImage is null " + productImage);
        }
    }
}
