package com.ecommerce.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ecommerce.form.ProductsForm;
import com.ecommerce.model.Categories;
import com.ecommerce.model.ProductImages;
import com.ecommerce.model.Products;
import com.ecommerce.service.ProductImagesService;
import com.ecommerce.service.ProductsService;
import com.ecommerce.util.ApplicationConstants;
import com.ecommerce.util.FileUploaderUtil;

public class ProductAction extends DispatchAction{
	private ProductsService productsService;
	private ProductImagesService productImagesService;

	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}
	
	public void setProductImagesService(ProductImagesService productImagesService) {
		this.productImagesService = productImagesService;
	}
	
	public ActionForward save(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		System.out.println("Save Product is Called");
		ProductsForm productsForm = (ProductsForm) actionForm;
		Products  product = new Products();
		ProductImages  productImages = new ProductImages();
		productsForm.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		productsForm.setUpdatedOn(productsForm.getCreatedOn());
		BeanUtils.copyProperties(product, productsForm);
		product.setCategory(new Categories(Integer.parseInt(request.getParameter("categoryId"))));
		product.setFeatured((productsForm.isFeaturedItem())?ApplicationConstants.PRODUCT_IS_FEATURED:ApplicationConstants.PRODUCT_IS_NOT_FEATURED);
		Integer productId = null;
		try{
			productId =productsService.insert(product);
			product=productsService.getProducts(productId);
			String imageName = FileUploaderUtil.uploadImage(ApplicationConstants.PRODUCT_IMAGE_PATH, productsForm.getProductImage(), productId);
			productImages.setProduct(product);
			productImages.setCaption(productsForm.getImageCaption());
			productImages.setImageName(productId+imageName);
			productImages.setOriginalName(productsForm.getProductImage().getFileName());
			productImages.setCreatedOn(new Timestamp(System.currentTimeMillis()));
			productImages.setUpdatedOn(new Timestamp(System.currentTimeMillis()));
			productImagesService.insert(productImages);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(productId!=null){
			System.out.println("success");
			request.setAttribute("message", "Product Added Successfully!");
			return (actionMapping.findForward("success"));
		} else {
			return (actionMapping.findForward("failed"));
		}
	}

	public ActionForward update(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		System.out.println("Save Product is Called");
		ProductsForm productsForm = (ProductsForm) actionForm;
		Products  products= new Products();
		ProductImages  productImages = new ProductImages();
		BeanUtils.copyProperties(products, productsForm);
		products.setUpdatedOn(new Timestamp(System.currentTimeMillis()));
		products.setCategory(new Categories(Integer.parseInt(request.getParameter("categoryId"))));
		products.setFeatured((productsForm.isFeaturedItem())?ApplicationConstants.PRODUCT_IS_FEATURED:ApplicationConstants.PRODUCT_IS_NOT_FEATURED);
		Integer productId = null;
		List<ProductImages> productImagesList = null;
		try{
			String imageName = FileUploaderUtil.uploadImage(ApplicationConstants.PRODUCT_IMAGE_PATH, productsForm.getProductImage(), products.getProductId());
			productId=productsService.update(products);
			productImagesList = productsService.getProductImagesListByProduct(products);
			productImages = productImagesList.get(0);
			productImages.setProduct(products);
			productImages.setCaption(productsForm.getImageCaption());
			productImages.setCaption(productsForm.getImageCaption());
			productImages.setImageName(productId+imageName);
			productImages.setOriginalName(productsForm.getProductImage().getFileName());
			productImagesService.update(productImages);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(productId!=null){
			request.setAttribute("message", "Product Updated Successfully!");
		    return (actionMapping.findForward("updateSuccess"));
	    } else {
	    	 return (actionMapping.findForward("updateFailed"));
	    }
	}
}
