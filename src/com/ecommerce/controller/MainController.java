package com.ecommerce.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ecommerce.model.ProductImages;
import com.ecommerce.model.Products;
import com.ecommerce.service.CategoriesService;
import com.ecommerce.service.MenuService;
import com.ecommerce.service.ProductsService;

public class MainController extends Action{
	
	private CategoriesService categoriesService;
	private ProductsService productsService;
	private MenuService menuService;

	public void setCategoriesService(CategoriesService categoriesService) {
		this.categoriesService = categoriesService;
	}

	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}
	
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{

		List<Products> featuredProductList = new ArrayList<Products>();
		List<ProductImages> featuredProductImagesList = new ArrayList<ProductImages>();
		if(productsService.getFeaturedProductsList().size()>0){
			featuredProductList.addAll(productsService.getFeaturedProductsList());
			if(featuredProductList.size()>=5){
				featuredProductList = featuredProductList.subList(0, 5);
			}
			for(int i=0; i<featuredProductList.size();i++){
				ProductImages productImages = (productsService.getProductImagesListByProduct(featuredProductList.get(i)).size()>0)?(productsService.getProductImagesListByProduct(featuredProductList.get(i)).get(0)):null;
				if(productImages!=null){
					featuredProductImagesList.add(productImages);
				}
			}
		}
		
		List<Products> latestProductList = new ArrayList<Products>();
		List<ProductImages> latestProductImagesList = new ArrayList<ProductImages>();
		if(productsService.getLatestProductsList().size()>0){
			latestProductList.addAll(productsService.getLatestProductsList());
			if(latestProductList.size()>=6){
				latestProductList = latestProductList.subList(0, 6);
			}
			for(int i=0; i<latestProductList.size();i++){
				ProductImages productImages = (productsService.getProductImagesListByProduct(latestProductList.get(i)).size()>0)?(productsService.getProductImagesListByProduct(latestProductList.get(i)).get(0)):null;
				if(productImages!=null){
					latestProductImagesList.add(productImages);
				}
			}
		}
		
		List<Products> upcomingProductList = new ArrayList<Products>();
		List<ProductImages> upcomingProductImagesList = new ArrayList<ProductImages>();
		if(productsService.getUpcomingProductsList().size()>0){
			upcomingProductList.addAll(productsService.getUpcomingProductsList());
			if(upcomingProductList.size()>=6){
				upcomingProductList = upcomingProductList.subList(0, 6);
			}
			for(int i=0; i<upcomingProductList.size();i++){
				ProductImages productImages = (productsService.getProductImagesListByProduct(upcomingProductList.get(i)).size()>0)?(productsService.getProductImagesListByProduct(upcomingProductList.get(i)).get(0)):null;
				if(productImages!=null){
					upcomingProductImagesList.add(productImages);
				}
			}
		}
		
		List<Products> topSaleProductList = new ArrayList<Products>();
		List<BigDecimal> topSaleProductIdList = new ArrayList<BigDecimal>();
		List<ProductImages> topSaleProductImagesList = new ArrayList<ProductImages>();
		if(productsService.getTopSaleProductsIdList().size()>0){
			topSaleProductIdList.addAll(productsService.getTopSaleProductsIdList());
			for(int i=0; i<topSaleProductIdList.size();i++){
				topSaleProductList.add(productsService.getProducts(Integer.valueOf(topSaleProductIdList.get(i).intValue())));
			}
			if(topSaleProductList.size()>=6){
				topSaleProductList = topSaleProductList.subList(0, 6);
			}
			for(int i=0; i<topSaleProductList.size();i++){
				Products products = topSaleProductList.get(i);
				ProductImages productImages = (productsService.getProductImagesListByProduct(topSaleProductList.get(i)).size()>0)?(productsService.getProductImagesListByProduct(topSaleProductList.get(i)).get(0)):null;
				if(productImages!=null){
					topSaleProductImagesList.add(productImages);
				}
			}
		}

		/**************************************Load Shopping Cart Start************************************************/
		HashMap<String, String> cartHashMap = new HashMap<String, String>();
		cartHashMap = menuService.getCartSummary(request);
		request.setAttribute("numberOfItems", cartHashMap.get("numberOfItems"));
		request.setAttribute("totalPrice", cartHashMap.get("totalPrice"));
		/**************************************Load Shopping Cart End************************************************/
		HashMap<String, Object> menuMap = menuService.getMenu();
		request.setAttribute("navParentCategoriesList", menuMap.get("navParentCategoriesList"));
		request.setAttribute("moreCategoriesList", menuMap.get("noChildCategoriesList"));
		request.setAttribute("topCategoriesList", menuMap.get("topCategoriesList"));
		request.setAttribute("categoryWiseSubcategoryMap", menuMap.get("categoryWiseSubcategoryMap"));
		request.setAttribute("featuredProductList", featuredProductList);
		request.setAttribute("featuredProductImagesList", featuredProductImagesList);
		request.setAttribute("latestProductList", latestProductList);
		request.setAttribute("latestProductImagesList", latestProductImagesList);
		request.setAttribute("topRatedProductList", latestProductList);
		request.setAttribute("topSaleProductList", topSaleProductList);
		request.setAttribute("topSaleProductImagesList", topSaleProductImagesList);
		request.setAttribute("upcomingProductList", upcomingProductList);
		request.setAttribute("upcomingProductImagesList", upcomingProductImagesList);
		request.setAttribute("currentAction", request.getRequestURL());
		return actionMapping.findForward("success");
	}

}
