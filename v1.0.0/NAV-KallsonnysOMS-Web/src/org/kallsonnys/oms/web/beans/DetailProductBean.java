package org.kallsonnys.oms.web.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.kallsonnys.oms.dto.ProductDTO;
import org.kallsonnys.oms.enums.ProducerTypeEnum;
import org.kallsonnys.oms.enums.ProductCategoryEnum;
import org.kallsonnys.oms.services.products.ProductsRemote;
import org.kallsonnys.oms.utilities.Util;
import org.kallsonys.oms.commons.locator.ServiceLocator;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "detailProduct")
@ViewScoped
public class DetailProductBean implements Serializable{
	private static final long serialVersionUID = -2152389656664659476L;
	
	private ProductDTO producto; 
	private Long inputProId;
	private String inputName;
	private String inputDesc;
	private Double inputPrice;
	private ProductCategoryEnum slCategory;
	private ProducerTypeEnum slProveedor;	
	private UploadedFile fileFull; 	
	private UploadedFile fileThumb;
	byte[] image_full_bytes;
	byte[] image_thumb_bytes;
	private String image_url_full;
	private String image_url_thumb;
	private List<ProductCategoryEnum> categorys;
	private List<ProducerTypeEnum> producers;
	
	private String messageHeader;
	private String messageBody;
	private Severity severity;
	
	private final static String  PREFIJO_FULL_IMG = "full";
	private final static String  PREFIJO_THUMB_IMG = "thumb";
	
	public DetailProductBean (){
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			
		if (req != null) {
			String idPrd = req.getParameter("id");			
			if (idPrd != null){
				String state = req.getParameter("state");
				if (state !=null){
					if (state.equals("OK")){
						messageHeader = "Producto con Id ";
						messageBody = idPrd + " modificado correctamente";
						severity = FacesMessage.SEVERITY_INFO;
					}else{
						messageHeader = "Error al modificar el producto ";
						messageBody =  idPrd;
						severity = FacesMessage.SEVERITY_ERROR;
					} 
					Util.addMessage(severity, messageHeader, messageBody);	
				}   					    	
			    			
				System.out.println("idPrd "+idPrd);
				ProductsRemote productsEJB = ServiceLocator.getInstance().getRemoteObject("ProductsBean");
				producto = productsEJB.getProductDetailById(Long.parseLong(idPrd));

				inputProId = producto.getProdId();
				inputName = producto.getName();
				inputDesc = producto.getDescription();
				inputPrice = producto.getPrice();
				slCategory = producto.getCategory();
				slProveedor = producto.getProducer();
				image_url_full = producto.getImage_url_full();
				image_url_thumb = producto.getImage_url_thumb();		    	
		    	
			}
			
		}
		
	}
	
	public void uploadFile(FileUploadEvent event) {    	
    	
    	if (event.getFile().getFileName().contains(PREFIJO_FULL_IMG)){
    		fileFull = event.getFile();
    		image_full_bytes = event.getFile().getContents();
            System.out.println("full " + fileFull.getFileName());
    	}else if (event.getFile().getFileName().contains(PREFIJO_THUMB_IMG)){
    		fileThumb = event.getFile();
    		image_thumb_bytes = event.getFile().getContents();
            System.out.println("thumb " + fileThumb.getFileName());
    	} 
    	messageHeader = "Imagen ";
		messageBody = event.getFile().getFileName() + " se cargo correctamente.";
		severity = FacesMessage.SEVERITY_INFO;
       
		Util.addMessage(severity, messageHeader, messageBody);
    }
	
	public void update(ActionEvent actionEvent) throws IOException{ 	
		try {
			ProductDTO prodUpdate = new  ProductDTO();
			prodUpdate.setId(producto.getId());
	    	prodUpdate.setProdId(inputProId);
	    	prodUpdate.setName(inputName);
	    	prodUpdate.setDescription(inputDesc);
	    	prodUpdate.setPrice(inputPrice);
	    	prodUpdate.setCategory(slCategory);
	    	prodUpdate.setProducer(slProveedor);
	    	prodUpdate.setImage_full_bytes(image_full_bytes);
	    	prodUpdate.setImage_thumb_bytes(image_thumb_bytes);
	    	
	    	ProductsRemote productsEJB = ServiceLocator.getInstance().getRemoteObject("ProductsBean");
			productsEJB.updateProduct(prodUpdate);
	    	
	    	FacesContext.getCurrentInstance().getExternalContext().redirect("detailProduct.xhtml?id="+prodUpdate.getId()+"&state=OK");
			
		} catch (Exception e) {
			e.printStackTrace();
			Util.addMessage(FacesMessage.SEVERITY_ERROR, "Ocurrio un error al editar el producto "+producto.getName(), "");
		}
	}
	
	public List<ProducerTypeEnum> getProducers() {
		producers = new ArrayList<ProducerTypeEnum>();
		producers.add(ProducerTypeEnum.SONY);
		producers.add(ProducerTypeEnum.RAPID_SERVICE);
		return producers;
	}
    
    public List<ProductCategoryEnum> getCategorys() {	
    	this.categorys = new ArrayList<ProductCategoryEnum>();
		this.categorys.add(ProductCategoryEnum.CAT1);
		this.categorys.add(ProductCategoryEnum.CAT2);
		this.categorys.add(ProductCategoryEnum.CAT3);
		this.categorys.add(ProductCategoryEnum.CAT4);
		return this.categorys;
	}
	
    public ProductDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductDTO producto) {
		this.producto = producto;
	}

	public Long getInputProId() {
		return inputProId;
	}

	public void setInputProId(Long inputProId) {
		this.inputProId = inputProId;
	}

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public String getInputDesc() {
		return inputDesc;
	}

	public void setInputDesc(String inputDesc) {
		this.inputDesc = inputDesc;
	}

	public Double getInputPrice() {
		return inputPrice;
	}

	public void setInputPrice(Double inputPrice) {
		this.inputPrice = inputPrice;
	}

	public UploadedFile getFileFull() {
		return fileFull;
	}

	public void setFileFull(UploadedFile fileFull) {
		this.fileFull = fileFull;
	}

	public UploadedFile getFileThumb() {
		return fileThumb;
	}

	public void setFileThumb(UploadedFile fileThumb) {
		this.fileThumb = fileThumb;
	}

	public byte[] getImage_full_bytes() {
		return image_full_bytes;
	}

	public void setImage_full_bytes(byte[] image_full_bytes) {
		this.image_full_bytes = image_full_bytes;
	}

	public byte[] getImage_thumb_bytes() {
		return image_thumb_bytes;
	}

	public void setImage_thumb_bytes(byte[] image_thumb_bytes) {
		this.image_thumb_bytes = image_thumb_bytes;
	}

	public void setCategorys(List<ProductCategoryEnum> categorys) {
		this.categorys = categorys;		
	}

	public void setProducers(List<ProducerTypeEnum> producers) {
		this.producers = producers;
	}

	public String getImage_url_full() {
		return image_url_full;
	}

	public void setImage_url_full(String image_url_full) {
		this.image_url_full = image_url_full;
	}

	public String getImage_url_thumb() {
		return image_url_thumb;
	}

	public void setImage_url_thumb(String image_url_thumb) {
		this.image_url_thumb = image_url_thumb;
	}

	public ProductCategoryEnum getSlCategory() {
		return slCategory;
	}

	public void setSlCategory(ProductCategoryEnum slCategory) {
		this.slCategory = slCategory;
	}

	public ProducerTypeEnum getSlProveedor() {
		return slProveedor;
	}

	public void setSlProveedor(ProducerTypeEnum slProveedor) {
		this.slProveedor = slProveedor;
	}


}
