package oracle.fodemo.storefront.store.view.managed;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;


import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTree;
import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.PopupFetchEvent;
import oracle.adf.view.rich.event.QueryEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.fodemo.storefront.adf.util.ADFUtils;
import oracle.fodemo.storefront.jsf.util.JSFUtils;

import oracle.jbo.domain.Number;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import org.apache.myfaces.trinidad.event.DisclosureEvent;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.model.RowKeySetTreeImpl;
import org.apache.myfaces.trinidad.model.TreeModel;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;


public class HomeBean {
    private String _selectedCategory = "Electronics";
    private RichPanelTabbed _productsPanelTabbed;
    private RichShowDetailItem _showSearchFields;
    private RichShowDetailItem _showCategoriesTree;
    private RichShowDetailItem _showFeaturedItem;
    private RichShowDetailItem _showSearchProducts;
    private RichShowDetailItem _showMostPopularProducts;
    private RichShowDetailItem _showStartShoppingProducts;
    private RichShowDetailItem _shoppingCartItem;    
    private ActionListener _updateShoppingCart = new ActionListener(){
            public void processAction(ActionEvent evt){
                AdfFacesContext ctx = AdfFacesContext.getCurrentInstance();
                ctx.addPartialTarget(_shoppingCartItem);
            }
        };
    private String theCategoryId = "3";
    private String theReviewId = "test";
    private RichPopup popup;
    private BindingContainer bindings;

    public HomeBean() {}

    /**
     * Returns a RowKeySet containing all of the keys
     * currently available in the af:tree that displays
     * all of the available product categories.
     * 
     * @return RowKeySet containing all disclosed keys
     */
    public RowKeySet getTreeExposedRowKeys() {
        TreeModel model = 
            (TreeModel)JSFUtils.resolveExpression("#{bindings.ParentProductCategories.treeModel}");
        RowKeySet disclosedRowKeySet = new RowKeySetTreeImpl();
        if (model != null) {
            Object oldKey = model.getRowKey();
            model.setRowKey(null);
            disclosedRowKeySet.setCollectionModel(model);
            disclosedRowKeySet.addAll();
            model.setRowKey(oldKey);
        }
        return disclosedRowKeySet;
    }

    /**
     * @param evt
     */
    public void productCategoriesTreeSelectionListener(SelectionEvent evt) {
        RichTree tree = (RichTree)evt.getSource();
        TreeModel model = (TreeModel)tree.getValue();
        RowKeySet rowKeySet = evt.getAddedSet();
        Object key = rowKeySet.iterator().next();
        model.setRowKey(key);
        
        JUCtrlValueBinding nodeBinding = 
            (JUCtrlValueBinding)model.getRowData();
        Number catId = (Number)nodeBinding.getAttribute("CategoryId");
        _selectedCategory = (String)nodeBinding.getAttribute("CategoryName");
        
        OperationBinding ob = ADFUtils.findOperation("ProductsByCategoriesExecuteWithParams");
        ob.getParamsMap().put("category", catId);
        ob.execute();
    }

    /**
     * @return
     */
    public ActionListener getUpdateShoppingCart(){
        return _updateShoppingCart;
    }

    /**
     * @param evt
     */
    public void searchProductsDisclosureListener(DisclosureEvent evt) {
        if (evt.isExpanded()) {
            _showSearchFields.setDisclosed(true);
            _showCategoriesTree.setDisclosed(false);
            _showFeaturedItem.setDisclosed(false);
            } 
    }

    /**
     * @param evt
     */
    public void hotProductsDisclosureListener(DisclosureEvent evt) {
        if (evt.isExpanded()) {
            _showSearchFields.setDisclosed(false);
            _showCategoriesTree.setDisclosed(false);
            _showFeaturedItem.setDisclosed(true);
            } 
    }

    /**
     * @param evt
     */
    public void startShoppingProductsDisclosureListener(DisclosureEvent evt) {
        if (evt.isExpanded()) {
            _showSearchFields.setDisclosed(false);
            _showCategoriesTree.setDisclosed(true);
            _showFeaturedItem.setDisclosed(false);
            } 
    }

    /**
     * @param evt
     */
    public void searchFieldsDisclosureListener(DisclosureEvent evt) {
        if (evt.isExpanded()) {
            _showSearchProducts.setDisclosed(true);
            _showStartShoppingProducts.setDisclosed(false);
            _showMostPopularProducts.setDisclosed(false);
        }
    }

    /**
     * @param evt
     */
    public void featuredProductsDisclosureListener(DisclosureEvent evt) {
        if (evt.isExpanded()) {
            _showSearchProducts.setDisclosed(false);
            _showStartShoppingProducts.setDisclosed(false);
            _showMostPopularProducts.setDisclosed(true);
            } 
    }

    /**
     * @param evt
     */
    public void browseProductsDisclosureListener(DisclosureEvent evt) {
        if (evt.isExpanded()) {
            _showSearchProducts.setDisclosed(false);
            _showStartShoppingProducts.setDisclosed(true);
            _showMostPopularProducts.setDisclosed(false);
        } 
    }

    /**
     * @param param
     */
    public void setShowSearchFields(RichShowDetailItem param) {
        this._showSearchFields = param;
    }

    /**
     * @return
     */
    public RichShowDetailItem getShowSearchFields() {
        return _showSearchFields;
    }

    /**
     * @param param
     */
    public void setShowCategoriesTree(RichShowDetailItem param) {
        this._showCategoriesTree = param;
    }

    /**
     * @return
     */
    public RichShowDetailItem getShowCategoriesTree() {
        return _showCategoriesTree;
    }


    /**
     * @param param
     */
    public void setShowSearchProducts(RichShowDetailItem param) {
        this._showSearchProducts = param;
    }

    /**
     * @return
     */
    public RichShowDetailItem getShowSearchProducts() {
        return _showSearchProducts;
    }

    /**
     * @param param
     */
    public void setProductsPanelTabbed(RichPanelTabbed param) {
        this._productsPanelTabbed = param;
    }

    /**
     * @return
     */
    public RichPanelTabbed getProductsPanelTabbed() {
        return _productsPanelTabbed;
    }

    /**
     * @param param
     */
    public void setShowMostPopularProducts(RichShowDetailItem param) {
        this._showMostPopularProducts = param;
    }

    /**
     * @return
     */
    public RichShowDetailItem getShowMostPopularProducts() {
        return _showMostPopularProducts;
    }

    /**
     * @param param
     */
    public void setShowStartShoppingProducts(RichShowDetailItem param) {
        this._showStartShoppingProducts = param;
    }

    /**
     * @return
     */
    public RichShowDetailItem getShowStartShoppingProducts() {
        return _showStartShoppingProducts;
    }

    /**
     * @param param
     */
    public void setSelectedCategory(String param) {
        this._selectedCategory = param;
    }

    /**
     * @return
     */
    public String getSelectedCategory() {
        return _selectedCategory;
    }

    /**
     * @param param
     */
    public void setShowFeaturedItem(RichShowDetailItem param) {
        this._showFeaturedItem = param;
    }

    /**
     * @return
     */
    public RichShowDetailItem getShowFeaturedItem() {
        return _showFeaturedItem;
    }

    /**
     * @param newshoppingCartItem
     */
    public void setShoppingCartItem(RichShowDetailItem newshoppingCartItem) {
        this._shoppingCartItem = newshoppingCartItem;
    }

    /**
     * @return
     */
    public RichShowDetailItem getShoppingCartItem() {
        return _shoppingCartItem;
    }

    /**
     * @return
     */
    public String getTheCategoryId() {
        return theCategoryId;
    }

    /**
     * @return
     */
    public String getTheReviewId() {
        return theReviewId;
    }

    /**
     * @param queryEvent
     */
    public void processQuery(QueryEvent queryEvent) {
        JSFUtils.resolveMethodExpression("#{bindings.FindByProductNameCriteriaQuery.processQuery}",
                                         Object.class,new Class[]{QueryEvent.class},new Object[]{queryEvent});
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String popupId = popup.getClientId(facesContext);
        ExtendedRenderKitService service =
        Service.getRenderKitService(facesContext, ExtendedRenderKitService.class);
        service.addScript(facesContext, "hidePopup('" + popupId + "')");
    }

    /**
     * @param popup
     */
    public void setPopup(RichPopup popup) {
        this.popup = popup;
    }

    /**
     * @return
     */
    public RichPopup getPopup() {
        return popup;
    }

    /**
     * @return
     */
    public BindingContainer getBindings() {
        if (this.bindings == null) {
            FacesContext fc = FacesContext.getCurrentInstance();
            this.bindings =
                    (BindingContainer)fc.getApplication().evaluateExpressionGet(fc, "#{bindings}",
                        BindingContainer.class);
        }
        return this.bindings;
    }


    /**
     * @param event
     */
    public void searchPopupListener(PopupFetchEvent event) {
        resetCriteria();
    }
    
    
    private void resetCriteria(){
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("resetProductQueryCriteria");
        operationBinding.execute();
    }
}
