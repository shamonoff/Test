package oracle.foddemo.masterpricelist.backing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.URL;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.foddemo.masterpricelist.controller.PriceEditingController;

public class PriceListSummaryBB {
    private RichInputText searchInput;

    public PriceListSummaryBB() {
    }

    public void setSearchInput(RichInputText searchInput) {
        this.searchInput = searchInput;
    }

    public RichInputText getSearchInput() {
        return searchInput;
    }

    public String search_coaction() {
        String searchTerm = (String)searchInput.getValue();
        AdfFacesContext afctx = AdfFacesContext.getCurrentInstance();
        Map flowScopeMap = afctx.getPageFlowScope();
        PriceEditingController pec = (PriceEditingController)flowScopeMap.get("PriceEditingController");
        if(pec != null){
            pec.setLastSearchTerm(searchTerm);
            pec.finalize();
        }
        return null;
    }

    public void downloadEditable(FacesContext facesContext,
                                 OutputStream outputStream) throws IOException {
        downloadWorker(facesContext,outputStream,"/excel/published/EditPriceList.xlsx");
    }
    
    public void downloadAdvanced(FacesContext facesContext,
                                 OutputStream outputStream) throws IOException {
        downloadWorker(facesContext,outputStream,"/excel/published/AdvEditPriceList.xlsx");
    }

    public void downloadReadOnly(FacesContext facesContext,
                                 OutputStream outputStream) throws IOException {
        downloadWorker(facesContext,outputStream,"/excel/published/ReadOnlyPriceList.xlsx");
    }

    private void downloadWorker(FacesContext context,
                                OutputStream out, String fileName)throws IOException {       
        String hostname = java.net.InetAddress.getLocalHost().getHostName(); 
        URL fileURL = new URL("http://"+hostname+":7101/FODMasterPriceList/" + fileName);
            try {
            InputStream is = fileURL.openStream();
            byte[] contents = new byte[1024];
            int bytesRead;
            int size = 0;
            while(-1 !=(bytesRead = is.read(contents))){
                out.write(contents,0,bytesRead);
                size = size + bytesRead;
            }
            out.close();
        }
            catch(FileNotFoundException ioe) {
                FacesContext ctx = FacesContext.getCurrentInstance();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"[Cannot locate file for download]",null);
                ctx.addMessage(null,msg);                  
            }
    }
}
