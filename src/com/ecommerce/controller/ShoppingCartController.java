package com.ecommerce.controller;

import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ecommerce.model.ProductImages;
import com.ecommerce.model.Products;
import com.ecommerce.model.ShoppingCart;
import com.ecommerce.service.MenuService;
import com.ecommerce.service.ProductsService;
import com.ecommerce.util.ApplicationConstants;
import com.ecommerce.util.SessionManagementUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

public class ShoppingCartController extends DispatchAction{
	
	private ProductsService productsService;
	private MenuService menuService;

	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public ActionForward add(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		System.out.println("Called!");
		System.out.println(request.getParameter("productQuantity"));
		System.out.println(request.getParameter("productId"));
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		Integer productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
		System.out.println("Called!");
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		SessionManagementUtil sessionManagementUtil = new SessionManagementUtil(request);
		ArrayList<ShoppingCart> shoppingList;
		if(sessionManagementUtil.getItemList(ApplicationConstants.SHOPPING_CART_ITEMS)!=null){
			shoppingList = sessionManagementUtil.getItemList(ApplicationConstants.SHOPPING_CART_ITEMS);
		}else{
			shoppingList = new ArrayList<ShoppingCart>();
			/*Products products = productsService.getProducts(productId);
			ShoppingCart shoppingCart = new ShoppingCart(productId, productQuantity, (productQuantity*(products.getOriginalPrice())));*/
			/*shoppingList.add(shoppingCart);*/
		}
		Products products = productsService.getProducts(productId);
		ProductImages productImages = productsService.getProductImagesListByProduct(products).get(0);
		ShoppingCart shoppingCart = new ShoppingCart(
				productId, productQuantity,
				products.getProductName(),
				productImages.getImageName(),
				(productQuantity*((products.getDiscountPrice()>0)?products.getDiscountPrice():products.getOriginalPrice())),
				(products.getDiscountPrice()>0)?products.getDiscountPrice():products.getOriginalPrice(),
				products.getOriginalPrice(),
				products.getDiscountPrice()
			);
		if(shoppingList.size()==0){
			shoppingList.add(shoppingCart);
		}else{
			boolean isNewItem = true;
			for(int i=0; i<shoppingList.size(); i++){
				if(shoppingCart.getProductId().equals(shoppingList.get(i).getProductId())){
					Integer prevQuantity = shoppingList.get(i).getQuantity();
					shoppingList.get(i).setQuantity(prevQuantity+shoppingCart.getQuantity());
					double newPrice = (shoppingList.get(i).getProductPrice() + shoppingCart.getProductPrice());
					shoppingList.get(i).setProductPrice(newPrice);
					isNewItem = false;
					break;
				}
			}
			if(isNewItem){
				shoppingList.add(shoppingCart);
			}
		}
		sessionManagementUtil.setItemList(ApplicationConstants.SHOPPING_CART_ITEMS, shoppingList);
		double totalPrice = 0;
		Integer numberOfItems = 0;
		for(int i=0; i<shoppingList.size(); i++){
			totalPrice += shoppingList.get(i).getProductPrice();
			numberOfItems += shoppingList.get(i).getQuantity();
		}
		PrintWriter printWriter = response.getWriter();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("numberOfItems", String.valueOf(numberOfItems));
		map.put("totalPrice", String.valueOf(totalPrice));
		String jsonString = new Gson().toJson(map);
		printWriter.print(jsonString);
		return null;
	}
	
	public ActionForward getItemList(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		List<ShoppingCart> shoppingList = null;
		SessionManagementUtil sessionManagementUtil = new SessionManagementUtil(request);
		if(sessionManagementUtil.getItemList(ApplicationConstants.SHOPPING_CART_ITEMS)!=null){
			shoppingList = sessionManagementUtil.getItemList(ApplicationConstants.SHOPPING_CART_ITEMS);
		}else{
			shoppingList = new ArrayList<ShoppingCart>();
		}
		request.setAttribute("productsList", shoppingList);
		PrintWriter printWriter = response.getWriter();
		JsonArray shoppingJSONList = (JsonArray) new Gson().toJsonTree(shoppingList, new TypeToken<List<ShoppingCart>>(){}.getType());
		printWriter.print(shoppingJSONList);
		return null;
	}
	
	public ActionForward update(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		/*Get Current Product list from Session*/
		List<ShoppingCart> shoppingList = null;
		SessionManagementUtil sessionManagementUtil = new SessionManagementUtil(request);
		if(sessionManagementUtil.getItemList(ApplicationConstants.SHOPPING_CART_ITEMS)!=null){
			shoppingList = sessionManagementUtil.getItemList(ApplicationConstants.SHOPPING_CART_ITEMS);
		}else{
			shoppingList = new ArrayList<ShoppingCart>();
		}
		/*Get Removable Product list from Checkout page*/
		Type listType = new TypeToken<List<Integer>>() {}.getType();
		List<Integer> removeProductList = new Gson().fromJson(request.getParameter("removeProductList"), listType);
		/*Get Updated Product list from Checkout page*/
		Type type = new TypeToken<List<ShoppingCart>>() {}.getType();
		List<ShoppingCart> updatedProductList = new Gson().fromJson(request.getParameter("updatedProductList"), type);
		
		for(int i=0; i<updatedProductList.size(); i++){
			if(removeProductList.contains(updatedProductList.get(i).getProductId())){
				ShoppingCart shoppingCart = updatedProductList.get(i);
				for(int j=0; j<shoppingList.size(); j++){
					if(shoppingList.get(j).getProductId()==updatedProductList.get(i).getProductId()){
						shoppingList.remove(shoppingList.indexOf(shoppingList.get(j)));
						break;
					}
				}
			}else{
				shoppingList.get(i).setQuantity(updatedProductList.get(i).getQuantity());
				shoppingList.get(i).setProductPrice(updatedProductList.get(i).getQuantity()*shoppingList.get(i).getUnitPrice());
			}
		}
		sessionManagementUtil.setItemList(ApplicationConstants.SHOPPING_CART_ITEMS, (ArrayList<ShoppingCart>) shoppingList);
		PrintWriter printWriter = response.getWriter();
		String jsonString = new Gson().toJson("Emptied Successfully!");
		printWriter.print(jsonString);
		return null;
	}

	public ActionForward empty(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		if(request.isRequestedSessionIdValid() && SessionManagementUtil.getHttpSession()!=null){
			SessionManagementUtil.getHttpSession().invalidate();
		}
		PrintWriter printWriter = response.getWriter();
		String jsonString = new Gson().toJson("Emptied Successfully!");
		printWriter.print(jsonString);
		return null;
	}
	
	
	public ActionForward show(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		System.out.println("checkout called!");
		List<ShoppingCart> shoppingList = null;
		SessionManagementUtil sessionManagementUtil = new SessionManagementUtil(request);
		if(sessionManagementUtil.getItemList(ApplicationConstants.SHOPPING_CART_ITEMS)!=null){
			shoppingList = sessionManagementUtil.getItemList(ApplicationConstants.SHOPPING_CART_ITEMS);
		}else{
			shoppingList = new ArrayList<ShoppingCart>();
		}
		double totalPrice = 0;
		Integer numberOfItems = 0;
		if(shoppingList.size()>0){
			for(int i=0; i<shoppingList.size(); i++){
				totalPrice += shoppingList.get(i).getProductPrice();
				numberOfItems += shoppingList.get(i).getQuantity();
			}
		}
		HashMap<String, Object> menuMap = menuService.getMenu();
		request.setAttribute("navParentCategoriesList", menuMap.get("navParentCategoriesList"));
		request.setAttribute("moreCategoriesList", menuMap.get("noChildCategoriesList"));
		request.setAttribute("categoryWiseSubcategoryMap", menuMap.get("categoryWiseSubcategoryMap"));
		request.setAttribute("numberOfItems", String.valueOf(numberOfItems));
		request.setAttribute("totalPrice", String.valueOf(totalPrice));
		request.setAttribute("shoppingList", shoppingList);
		return actionMapping.findForward("success");
	}
	
	public ActionForward myCartProductsList(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		List<ShoppingCart> shoppingList = null;
		SessionManagementUtil sessionManagementUtil = new SessionManagementUtil(request);
		if(sessionManagementUtil.getItemList(ApplicationConstants.SHOPPING_CART_ITEMS)!=null){
			shoppingList = sessionManagementUtil.getItemList(ApplicationConstants.SHOPPING_CART_ITEMS);
		}else{
			shoppingList = new ArrayList<ShoppingCart>();
		}
		request.setAttribute("shoppingList", shoppingList);
		PrintWriter printWriter = response.getWriter();
		JsonArray shoppingCartJSONList = (JsonArray) new Gson().toJsonTree(shoppingList, new TypeToken<List<ShoppingCart>>(){}.getType());
		printWriter.print(shoppingCartJSONList);
		return null;
	}
	
	public ActionForward myCartProductsListImages(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		List<ShoppingCart> shoppingList = null;
		SessionManagementUtil sessionManagementUtil = new SessionManagementUtil(request);
		if(sessionManagementUtil.getItemList(ApplicationConstants.SHOPPING_CART_ITEMS)!=null){
			shoppingList = sessionManagementUtil.getItemList(ApplicationConstants.SHOPPING_CART_ITEMS);
		}else{
			shoppingList = new ArrayList<ShoppingCart>();
		}
		List<ProductImages> productImagesList = new ArrayList<ProductImages>();
		if(shoppingList.size()>0){
			for(int i=0; i<shoppingList.size();i++){
				Products products = productsService.getProducts(shoppingList.get(i).getProductId());
				ProductImages productImages = (productsService.getProductImagesListByProduct(products).size()>0?productsService.getProductImagesListByProduct(products).get(0):null);
				productImagesList.add(productImages);
			}
		}
		request.setAttribute("productImagesList", productImagesList);
		request.setAttribute("shoppingList", shoppingList);
		PrintWriter printWriter = response.getWriter();
		JsonArray productImagesJSONList = (JsonArray) new Gson().toJsonTree(productImagesList, new TypeToken<List<ProductImages>>(){}.getType());
		printWriter.print(productImagesJSONList);
		return null;
	}
	
}
