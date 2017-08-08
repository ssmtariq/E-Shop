package com.ecommerce.controller;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ecommerce.form.ProductsForm;
import com.ecommerce.model.Categories;
import com.ecommerce.model.ProductImages;
import com.ecommerce.model.Products;
import com.ecommerce.service.CategoriesService;
import com.ecommerce.service.MenuService;
import com.ecommerce.service.ProductsService;
import com.ecommerce.util.ApplicationConstants;
import com.ecommerce.util.SessionManagementUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

public class ProductController extends DispatchAction{
	private ProductsService productsService;
	private CategoriesService categoriesService;
	private MenuService menuService;

	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}

	public void setCategoriesService(CategoriesService categoriesService) {
		this.categoriesService = categoriesService;
	}
	
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public ActionForward create(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		List<Categories> categoriesList = categoriesService.getAllCategories();
		/**************************************Load Shopping Cart Start************************************************/
		HashMap<String, String> cartHashMap = new HashMap<String, String>();
		cartHashMap = menuService.getCartSummary(request);
		request.setAttribute("numberOfItems", cartHashMap.get("numberOfItems"));
		request.setAttribute("totalPrice", cartHashMap.get("totalPrice"));
		/**************************************Load Shopping Cart End************************************************/
		HashMap<String, Object> menuMap = menuService.getMenu();
		request.setAttribute("navParentCategoriesList", menuMap.get("navParentCategoriesList"));
		request.setAttribute("moreCategoriesList", menuMap.get("noChildCategoriesList"));
		request.setAttribute("categoryWiseSubcategoryMap", menuMap.get("categoryWiseSubcategoryMap"));
		request.setAttribute("categoriesList", categoriesList);
		request.setAttribute("orderId", request.getParameter("orderId"));
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=create&orderId="+request.getParameter("orderId")));
		return actionMapping.findForward("success");
	}
	
	
	public ActionForward show(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		Products products = productsService.getProducts(Integer.parseInt(request.getParameter("productId")));
		List<Products> latestProductList = new ArrayList<Products>();
		if(productsService.getLatestProductsList().size()>0){
			latestProductList.addAll(productsService.getLatestProductsList());
			if(latestProductList.size()>=6){
				latestProductList = latestProductList.subList(0, 6);
			}
		}
		ProductImages productImages = (productsService.getProductImagesListByProduct(products).size()>0)?(productsService.getProductImagesListByProduct(products).get(0)):null;
		/**************************************Load Shopping Cart Start************************************************/
		HashMap<String, String> cartHashMap = new HashMap<String, String>();
		cartHashMap = menuService.getCartSummary(request);
		request.setAttribute("numberOfItems", cartHashMap.get("numberOfItems"));
		request.setAttribute("totalPrice", cartHashMap.get("totalPrice"));
		/**************************************Load Shopping Cart End************************************************/
		HashMap<String, Object> menuMap = menuService.getMenu();
		request.setAttribute("navParentCategoriesList", menuMap.get("navParentCategoriesList"));
		request.setAttribute("moreCategoriesList", menuMap.get("noChildCategoriesList"));
		request.setAttribute("categoryWiseSubcategoryMap", menuMap.get("categoryWiseSubcategoryMap"));
		request.setAttribute("latestProductList", latestProductList);
		request.setAttribute("products", products);
		request.setAttribute("productImages", productImages);
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=show"));
		return actionMapping.findForward("showDetails");
	}
	
	public ActionForward list(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		List<Categories> categoriesList = categoriesService.getAllCategories();
		List<Products> productsList = productsService.getAllProducts();
		List<ProductImages> productImagesList = new ArrayList<ProductImages>();
		if(productsList.size()>0){
			for(int i=0; i<productsList.size();i++){
				ProductImages productImages = (productsService.getProductImagesListByProduct(productsList.get(i)).size()>0)?(productsService.getProductImagesListByProduct(productsList.get(i)).get(0)):null;
				productImagesList.add(productImages);
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
		request.setAttribute("categoryWiseSubcategoryMap", menuMap.get("categoryWiseSubcategoryMap"));
		request.setAttribute("productsList", productsList);
		request.setAttribute("productImagesList", productImagesList);
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=list"));
		return actionMapping.findForward("productList");
	}
	
	public ActionForward edit(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		List<Categories> categoriesList = categoriesService.getAllCategories();
		Products products = productsService.getProducts(Integer.parseInt(request.getParameter("productId")));
		ProductImages productImages = (productsService.getProductImagesListByProduct(products).size()>0)?(productsService.getProductImagesListByProduct(products).get(0)):null;
		/**************************************Load Shopping Cart Start************************************************/
		HashMap<String, String> cartHashMap = new HashMap<String, String>();
		cartHashMap = menuService.getCartSummary(request);
		request.setAttribute("numberOfItems", cartHashMap.get("numberOfItems"));
		request.setAttribute("totalPrice", cartHashMap.get("totalPrice"));
		/**************************************Load Shopping Cart End************************************************/
		HashMap<String, Object> menuMap = menuService.getMenu();
		request.setAttribute("navParentCategoriesList", menuMap.get("navParentCategoriesList"));
		request.setAttribute("moreCategoriesList", menuMap.get("noChildCategoriesList"));
		request.setAttribute("categoryWiseSubcategoryMap", menuMap.get("categoryWiseSubcategoryMap"));
		request.setAttribute("categoriesList", categoriesList);
		request.setAttribute("products", products);
		request.setAttribute("productImages", productImages);
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=edit&productId="+products.getProductId()));
		return actionMapping.findForward("editProducts");
	}
	
	public ActionForward update(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		ProductsForm productsForm = (ProductsForm) actionForm;
		Products  products= new Products();
		BeanUtils.copyProperties(products, productsForm);
		products.setUpdatedOn(new Timestamp(System.currentTimeMillis()));
		products.setCategory(new Categories(Integer.parseInt(request.getParameter("categoryId"))));
		products.setFeatured((productsForm.isFeaturedItem())?ApplicationConstants.PRODUCT_IS_FEATURED:ApplicationConstants.PRODUCT_IS_NOT_FEATURED);
		int i=0;
		try{
			productsService.update(products);
			products=productsService.getProducts(products.getProductId());
			i=1;
		} catch (Exception e) {
			i=0;
		}
		if(i!=0){
		    return (actionMapping.findForward("updateSuccess"));
	    } else {
	    	 return (actionMapping.findForward("updateFailed"));
	    }
	}
	
	public ActionForward delete(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		Products  products= productsService.getProducts(Integer.parseInt(request.getParameter("productId")));
		int i=0;
		try{
			productsService.delete(products);
			i=1;
		} catch (Exception e) {
			i=0;
		}
		if(i!=0){
		    return (actionMapping.findForward("deleteSuccess"));
	    } else {
	    	 return (actionMapping.findForward("deleteFailed"));
	    }
	}
	
	public ActionForward criteriaWiseProduct(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		List<Categories> categoriesList = categoriesService.getAllCategories();
		/**************************************Load Shopping Cart Start************************************************/
		HashMap<String, String> cartHashMap = new HashMap<String, String>();
		cartHashMap = menuService.getCartSummary(request);
		request.setAttribute("numberOfItems", cartHashMap.get("numberOfItems"));
		request.setAttribute("totalPrice", cartHashMap.get("totalPrice"));
		/**************************************Load Shopping Cart End************************************************/
		HashMap<String, Object> menuMap = menuService.getMenu();
		request.setAttribute("navParentCategoriesList", menuMap.get("navParentCategoriesList"));
		request.setAttribute("moreCategoriesList", menuMap.get("noChildCategoriesList"));
		request.setAttribute("categoryWiseSubcategoryMap", menuMap.get("categoryWiseSubcategoryMap"));
		request.setAttribute("criteria", request.getParameter("criteria"));
		request.setAttribute("categoriesList", categoriesList);
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=criteriaWiseProduct"));
		return actionMapping.findForward("criteriaWiseProduct");
	}
	
	public ActionForward latestProducts(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		List<Products> productsList = productsService.getLatestProductsList();
		List<ProductImages> productImagesList = new ArrayList<ProductImages>();
		if(productsList.size()>0){
			for(int i=0; i<productsList.size();i++){
				ProductImages productImages = (productsService.getProductImagesListByProduct(productsList.get(i)).size()>0)?(productsService.getProductImagesListByProduct(productsList.get(i)).get(0)):null;
				productImagesList.add(productImages);
			}
		}
		request.setAttribute("productImagesList", productImagesList);
		request.setAttribute("productsList", productsList);
		PrintWriter printWriter = response.getWriter();
		JsonArray productJSONList = (JsonArray) new Gson().toJsonTree(productsList, new TypeToken<List<Products>>(){}.getType());
		printWriter.print(productJSONList);
		return null;
	}
	
	public ActionForward latestProductImages(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		List<Products> productsList = productsService.getLatestProductsList();
		List<ProductImages> productImagesList = new ArrayList<ProductImages>();
		if(productsList.size()>0){
			for(int i=0; i<productsList.size();i++){
				ProductImages productImages = (productsService.getProductImagesListByProduct(productsList.get(i)).size()>0)?(productsService.getProductImagesListByProduct(productsList.get(i)).get(0)):null;
				if(productImages!=null){
					productImagesList.add(productImages);
				}
			}
		}
		request.setAttribute("productImagesList", productImagesList);
		request.setAttribute("productsList", productsList);
		PrintWriter printWriter = response.getWriter();
		JsonArray productImagesJSONList = (JsonArray) new Gson().toJsonTree(productImagesList, new TypeToken<List<ProductImages>>(){}.getType());
		printWriter.print(productImagesJSONList);
		return null;
	}
	
	public ActionForward featuredProducts(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		List<Products> productsList = productsService.getFeaturedProductsList();
		request.setAttribute("productsList", productsList);
		PrintWriter printWriter = response.getWriter();
		JsonArray productJSONList = (JsonArray) new Gson().toJsonTree(productsList, new TypeToken<List<Products>>(){}.getType());
		printWriter.print(productJSONList);
		return null;
	}	
	
	public ActionForward featuredProductsImages(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		List<Products> productsList = productsService.getFeaturedProductsList();
		List<ProductImages> productImagesList = new ArrayList<ProductImages>();
		if(productsList.size()>0){
			for(int i=0; i<productsList.size();i++){
				ProductImages productImages = (productsService.getProductImagesListByProduct(productsList.get(i)).size()>0)?(productsService.getProductImagesListByProduct(productsList.get(i)).get(0)):null;
				if(productImages!=null){
					productImagesList.add(productImages);
				}
			}
		}
		request.setAttribute("productImagesList", productImagesList);
		request.setAttribute("productsList", productsList);
		PrintWriter printWriter = response.getWriter();
		JsonArray productImagesJSONList = (JsonArray) new Gson().toJsonTree(productImagesList, new TypeToken<List<ProductImages>>(){}.getType());
		printWriter.print(productImagesJSONList);
		return null;
	}
	
	public ActionForward topSaleProducts(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		List<Products> topSaleProductList = new ArrayList<Products>();
		List<BigDecimal> topSaleProductIdList = new ArrayList<BigDecimal>();
		topSaleProductIdList.addAll(productsService.getTopSaleProductsIdList());
		for(int i=0; i<topSaleProductIdList.size();i++){
			topSaleProductList.add(productsService.getProducts(Integer.valueOf(topSaleProductIdList.get(i).intValue())));
		}
		request.setAttribute("productsList", topSaleProductList);
		PrintWriter printWriter = response.getWriter();
		JsonArray productJSONList = (JsonArray) new Gson().toJsonTree(topSaleProductList, new TypeToken<List<Products>>(){}.getType());
		printWriter.print(productJSONList);
		return null;
	}	
	
	public ActionForward topSaleProductsImages(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		List<Products> topSaleProductList = new ArrayList<Products>();
		List<BigDecimal> topSaleProductIdList = new ArrayList<BigDecimal>();
		topSaleProductIdList.addAll(productsService.getTopSaleProductsIdList());
		for(int i=0; i<topSaleProductIdList.size();i++){
			topSaleProductList.add(productsService.getProducts(Integer.valueOf(topSaleProductIdList.get(i).intValue())));
		}
		List<ProductImages> productImagesList = new ArrayList<ProductImages>();
		if(topSaleProductList.size()>0){
			for(int i=0; i<topSaleProductList.size();i++){
				ProductImages productImages = (productsService.getProductImagesListByProduct(topSaleProductList.get(i)).size()>0)?(productsService.getProductImagesListByProduct(topSaleProductList.get(i)).get(0)):null;
				if(productImages!=null){
					productImagesList.add(productImages);
				}
			}
		}
		request.setAttribute("productImagesList", productImagesList);
		request.setAttribute("productsList", topSaleProductList);
		PrintWriter printWriter = response.getWriter();
		JsonArray productImagesJSONList = (JsonArray) new Gson().toJsonTree(productImagesList, new TypeToken<List<ProductImages>>(){}.getType());
		printWriter.print(productImagesJSONList);
		return null;
	}
	
	public ActionForward upcomingProducts(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		List<Products> productsList = productsService.getUpcomingProductsList();
		request.setAttribute("productsList", productsList);
		PrintWriter printWriter = response.getWriter();
		JsonArray productJSONList = (JsonArray) new Gson().toJsonTree(productsList, new TypeToken<List<Products>>(){}.getType());
		printWriter.print(productJSONList);
		return null;
	}
	
	public ActionForward upcomingProductsImages(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		List<Products> productsList = productsService.getUpcomingProductsList();
		List<ProductImages> productImagesList = new ArrayList<ProductImages>();
		if(productsList.size()>0){
			for(int i=0; i<productsList.size();i++){
				ProductImages productImages = (productsService.getProductImagesListByProduct(productsList.get(i)).size()>0)?(productsService.getProductImagesListByProduct(productsList.get(i)).get(0)):null;
				if(productImages!=null){
					productImagesList.add(productImages);
				}
			}
		}
		request.setAttribute("productImagesList", productImagesList);
		request.setAttribute("productsList", productsList);
		PrintWriter printWriter = response.getWriter();
		JsonArray productImagesJSONList = (JsonArray) new Gson().toJsonTree(productImagesList, new TypeToken<List<ProductImages>>(){}.getType());
		printWriter.print(productImagesJSONList);
		return null;
	}
	
	public ActionForward categoryWiseProducts(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		List<Categories> categoriesList = categoriesService.getAllCategories();
		HashMap<String, Object> menuMap = menuService.getMenu();
		request.setAttribute("navParentCategoriesList", menuMap.get("navParentCategoriesList"));
		request.setAttribute("moreCategoriesList", menuMap.get("noChildCategoriesList"));
		request.setAttribute("categoryWiseSubcategoryMap", menuMap.get("categoryWiseSubcategoryMap"));
		Categories categories = categoriesService.getCategories(Integer.parseInt(request.getParameter("categoryId")));
		request.setAttribute("categories", categories);
		request.setAttribute("categoryId", categories.getCategoryId());
		request.setAttribute("criteria", request.getParameter("criteria"));
		request.setAttribute("categoriesList", categoriesList);
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=categoryWiseProducts"));
		return actionMapping.findForward("categoryWiseProduct");
	}
	
	public ActionForward getCategoryWiseProducts(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		Categories categories = categoriesService.getCategories(Integer.parseInt(request.getParameter("categoryId")));
		List<Products> productsList = productsService.getCategoryWiseProductList(categories);
		request.setAttribute("productsList", productsList);
		PrintWriter printWriter = response.getWriter();
		JsonArray productJSONList = (JsonArray) new Gson().toJsonTree(productsList, new TypeToken<List<Products>>(){}.getType());
		printWriter.print(productJSONList);
		return null;
	}
	
	public ActionForward getCategoryWiseProductImages(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		Categories categories = categoriesService.getCategories(Integer.parseInt(request.getParameter("categoryId")));
		List<Products> productsList = productsService.getCategoryWiseProductList(categories);
		List<ProductImages> productImagesList = new ArrayList<ProductImages>();
		if(productsList.size()>0){
			for(int i=0; i<productsList.size();i++){
				ProductImages productImages = (productsService.getProductImagesListByProduct(productsList.get(i)).size()>0)?(productsService.getProductImagesListByProduct(productsList.get(i)).get(0)):null;
				if(productImages!=null){
					productImagesList.add(productImages);
				}
			}
		}System.out.println(productImagesList.size());
		request.setAttribute("productImagesList", productImagesList);
		request.setAttribute("productsList", productsList);
		PrintWriter printWriter = response.getWriter();
		JsonArray productImagesJSONList = (JsonArray) new Gson().toJsonTree(productImagesList, new TypeToken<List<ProductImages>>(){}.getType());
		printWriter.print(productImagesJSONList);
		return null;
	}
	
	public ActionForward search(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		/**************************************Load Shopping Cart Start************************************************/
		HashMap<String, String> cartHashMap = new HashMap<String, String>();
		cartHashMap = menuService.getCartSummary(request);
		request.setAttribute("numberOfItems", cartHashMap.get("numberOfItems"));
		request.setAttribute("totalPrice", cartHashMap.get("totalPrice"));
		/**************************************Load Shopping Cart End************************************************/
		HashMap<String, Object> menuMap = menuService.getMenu();
		request.setAttribute("navParentCategoriesList", menuMap.get("navParentCategoriesList"));
		request.setAttribute("moreCategoriesList", menuMap.get("noChildCategoriesList"));
		request.setAttribute("categoryWiseSubcategoryMap", menuMap.get("categoryWiseSubcategoryMap"));
		String searchCriteria = request.getParameter("searchCriteria");
		System.out.println(searchCriteria);
		request.setAttribute("searchCriteria", request.getParameter("searchCriteria"));
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=search"));
		return actionMapping.findForward("searchSuccess");
	}
	
	public ActionForward getSearchResults(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		List<Products> productsList = productsService.getSearchResults(request.getParameter("searchCriteria"));
		request.setAttribute("productsList", productsList);
		PrintWriter printWriter = response.getWriter();
		JsonArray productJSONList = (JsonArray) new Gson().toJsonTree(productsList, new TypeToken<List<Products>>(){}.getType());
		printWriter.print(productJSONList);
		return null;
	}
	
	public ActionForward getSearchResultsImages(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		List<Products> productsList = productsService.getSearchResults(request.getParameter("searchCriteria"));
		request.setAttribute("productsList", productsList);
		List<ProductImages> productImagesList = new ArrayList<ProductImages>();
		if(productsList.size()>0){
			for(int i=0; i<productsList.size();i++){
				ProductImages productImages = (productsService.getProductImagesListByProduct(productsList.get(i)).size()>0)?(productsService.getProductImagesListByProduct(productsList.get(i)).get(0)):null;
				if(productImages!=null){
					productImagesList.add(productImages);
				}
			}
		}System.out.println(productImagesList.size());
		request.setAttribute("productImagesList", productImagesList);
		PrintWriter printWriter = response.getWriter();
		JsonArray productImagesJSONList = (JsonArray) new Gson().toJsonTree(productImagesList, new TypeToken<List<ProductImages>>(){}.getType());
		printWriter.print(productImagesJSONList);
		return null;
	}

	
}
