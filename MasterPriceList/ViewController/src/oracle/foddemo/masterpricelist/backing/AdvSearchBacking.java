package oracle.foddemo.masterpricelist.backing;

import java.util.Map;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.servlet.HttpBindingContext;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class AdvSearchBacking {
    private BindingContainer bindings;
    public AdvSearchBacking() {
    }

    public String searchAction() {
        String categoryId = null;
        BindingContainer searchBindings=getBindings();
        
        //Get the values select in the WebUI
        AttributeBinding searchTermBinding = (AttributeBinding)searchBindings.getControlBinding("searchTerm");
        String searchTerm = (String)searchTermBinding.getInputValue();
        AttributeBinding categoryIdBinding = (AttributeBinding)searchBindings.getControlBinding("categoryId");
        if(categoryIdBinding.getInputValue()!= null)
            categoryId= categoryIdBinding.getInputValue().toString();
        AttributeBinding includeDiscontinuedBinding = (AttributeBinding)searchBindings.getControlBinding("includeDiscontinued");
        Boolean includeDiscontinued = (Boolean)includeDiscontinuedBinding.getInputValue();
        
        //Execute the Advanced Search operation using the ExcelEditPriceListPageDef
        BindingContext bctx = HttpBindingContext.getContext(null);

            DCBindingContainer excelBindings =
                bctx.findBindingContainer("ExcelPriceListPageDef");
            OperationBinding operationBinding =
                excelBindings.getOperationBinding("executeAdvancedProductQuery");
            Map opArgs = operationBinding.getParamsMap();
            opArgs.put("searchTerm", searchTerm);
            opArgs.put("categoryId", categoryId);
            opArgs.put("includeDiscontinued", includeDiscontinued);
            operationBinding.execute();
        return null;
    }

    public BindingContainer getBindings() {
        if (bindings == null) {
            FacesContext fctx = FacesContext.getCurrentInstance();
            bindings =(BindingContainer)fctx.getApplication().evaluateExpressionGet(fctx, "#{bindings}",
                                                                BindingContainer.class);
        }
        return bindings;
    }
}
