package oracle.fodemo.storefront.cart.view.managed;

import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.datatransfer.DataFlavor;
import oracle.adf.view.rich.dnd.DnDAction;
import oracle.adf.view.rich.event.DropEvent;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierNodeBinding;

import oracle.binding.OperationBinding;

import oracle.fodemo.storefront.adf.util.ADFUtils;

import oracle.fodemo.storefront.jsf.util.JSFUtils;

import oracle.jbo.Row;
import oracle.jbo.domain.Number;

import org.apache.myfaces.trinidad.model.RowKeySetImpl;

public class ShoppingCartBean {

    private static final ADFLogger _logger = ADFLogger.createADFLogger(ShoppingCartBean.class);
    private static final int DEFAULT_QUANTITY = 1;
    private static final String PRODUCT_ID_COL = "ProductId";
    private static final String PRODUCT_ID_PARAM = "productId";
    private static final String QUANTITY_PARAM = "quantity";
    private static final String IS_SET_PARAM = "isSet";   
    private static final String UPDATE_ITEM_IN_CART_OP = "updateItemInCart";
    private static final String REMOVE_ITEM_FROM_CART_OP = "removeItemFromCart";
    private static final String REMOVE_ALL_ITEMS_FROM_CART_OP ="removeAllItemsFromCart";
    private static final String MY_SHOPPING_CART_ITR = "MyShoppingCartIterator";
    private RichTable _table;
    
    public ShoppingCartBean() { }

    /**
     * Allows an item to be added to the cart with a drag and drop gesture.
     * Note the current implementation uses a java.lang.String object to pass
     * the primary key of a row which is represented by an oracle.job.domain.Number.
     * The oracle.job.domain.Number cannot be passed directly.
     * 
     * @param dropEvent
     * @return
     */
    public DnDAction handlePkDrop(DropEvent dropEvent) {
        try {
            DataFlavor<String> df = DataFlavor.getDataFlavor(String.class);
            String droppedValue = dropEvent.getTransferable().getData(df);
            if (droppedValue == null) {
                _logger.info("Dropped value is null.");
                return DnDAction.NONE;
            }
            invokeUpdateOp(new Integer(droppedValue));
            return DnDAction.COPY;
        } catch (Exception ex) {
            _logger.severe("Drop failed", ex);
            return DnDAction.NONE;
        }
    }

    /**
     * @param evt
     */
    public void quanityValueChangeListener(ValueChangeEvent evt) {
        Integer newQuantity = (Integer)evt.getNewValue();
        DCIteratorBinding itrBinding = ADFUtils.findIterator(MY_SHOPPING_CART_ITR);
        Row currentRow = itrBinding.getCurrentRow();
        if(currentRow !=  null){
            OperationBinding ob = ADFUtils.findOperation(UPDATE_ITEM_IN_CART_OP);
            Map params = ob.getParamsMap();
            oracle.jbo.domain.Number productId = (oracle.jbo.domain.Number)currentRow.getAttribute(PRODUCT_ID_COL);
            params.put( PRODUCT_ID_PARAM, productId);
            params.put( QUANTITY_PARAM, newQuantity);
            params.put( IS_SET_PARAM, true);
            ob.execute();
            if(!ob.getErrors().isEmpty()){
                JSFUtils.addFacesErrorMessage( "An error occured while attempting to change quantiy for product #" + productId + "." );
                ADFUtils.printOperationBindingExceptions(ob.getErrors());
            }
        }
    }

    /**
     * @param evt
     */
    public void addItemToCart(ActionEvent evt) {
        Map attributes = evt.getComponent().getAttributes();
        invokeUpdateOp(new Integer(attributes.get( PRODUCT_ID_COL )+ ""));
    }

    /**
     * @param evt
     */
    public void removeItemFromShoppingCart(ActionEvent evt) {
        if (_table == null) {
            return;
        }
        FacesCtrlHierNodeBinding rowData =  (FacesCtrlHierNodeBinding) _table.getSelectedRowData();
            if(rowData != null){
            OperationBinding ob = ADFUtils.findOperation( REMOVE_ITEM_FROM_CART_OP );
            Map params = ob.getParamsMap();
            Number productId = (oracle.jbo.domain.Number)rowData.getAttribute( PRODUCT_ID_COL );
            params.put( PRODUCT_ID_PARAM, productId);
            ob.execute();
            if(!ob.getErrors().isEmpty()){
                JSFUtils.addFacesErrorMessage( "An error occured while attempting to remove product #" + productId + " from the cart." );
                ADFUtils.printOperationBindingExceptions(ob.getErrors());
            }
            if (_table != null) {
                if (_table.getSelectedRowKeys() != null) {
                    _table.getSelectedRowKeys().clear();
                }
                _table.setSelectedRowKeys(new RowKeySetImpl());
            }
        }
    }

    /**
     * @param evt
     */
    public void removeAllItems(ActionEvent evt) {
        removeAllItems();
    }

    public void removeAllItems(){
         OperationBinding op = ADFUtils.findOperation(REMOVE_ALL_ITEMS_FROM_CART_OP);
         op.execute();
         if(!op.getErrors().isEmpty()){
             JSFUtils.addFacesErrorMessage( "An error occured while attempting to remove all items from the cart." );
             ADFUtils.printOperationBindingExceptions(op.getErrors());
         }
         if (_table != null) {
             if (_table.getSelectedRowKeys() != null) {
                 _table.getSelectedRowKeys().clear();
             }
             _table.setSelectedRowKeys(new RowKeySetImpl());
         }
     }
    
    private void invokeUpdateOp(Integer productId) {
        OperationBinding ob = ADFUtils.findOperation(UPDATE_ITEM_IN_CART_OP);
        Map params = ob.getParamsMap();
        params.put( PRODUCT_ID_PARAM, productId);
        params.put( QUANTITY_PARAM , DEFAULT_QUANTITY );
        params.put( IS_SET_PARAM, false);
        ob.execute();
        if(!ob.getErrors().isEmpty()){
            JSFUtils.addFacesErrorMessage( "An error occured while attempting to add product #" + productId.toString() + " to the cart." );
            ADFUtils.printOperationBindingExceptions(ob.getErrors());
        }

    }
    
     public void setTable(RichTable table) {
         _table = table;
     }
     
     public RichTable getTable() {
         return _table;
     }
     
     public boolean getNoRowIsSelected() {
       return ((_table == null) ? true : (_table.getSelectedRowKeys() == null || _table.getSelectedRowKeys().isEmpty()));
     }
     
     public Object getSelectedRow() {
         Object row = null;
         if (_table != null) {
             if (_table.getSelectedRowKeys() != null) {
                 row = _table.getSelectedRowData();
             }
         }
         return row;
     }
}