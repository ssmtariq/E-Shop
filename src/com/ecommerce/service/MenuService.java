package com.ecommerce.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ecommerce.model.Categories;
import com.ecommerce.model.ShoppingCart;
import com.ecommerce.util.ApplicationConstants;
import com.ecommerce.util.SessionManagementUtil;

public class MenuService {
	private CategoriesService categoriesService;

	public void setCategoriesService(CategoriesService categoriesService) {
		this.categoriesService = categoriesService;
	}
	
	public HashMap<String, Object> getMenu(){
		HashMap<Integer, List<Categories>> categoryWiseSubcategoryMap = new HashMap<Integer, List<Categories>>();
		List<Categories> allCategoriesList = null;
		allCategoriesList = categoriesService.getAllCategories();
		if(allCategoriesList.size()>0){
			for(int i=0; i<allCategoriesList.size(); i++){
				if(allCategoriesList.get(i).getParent() == null){
					if(categoriesService.getCategoryWiseSubcategoryList(allCategoriesList.get(i)).size()>0){
						categoryWiseSubcategoryMap.put(
								allCategoriesList.get(i).getCategoryId(), 
								categoriesService.getCategoryWiseSubcategoryList(allCategoriesList.get(i))
								);
					}
				}
				System.out.println(categoryWiseSubcategoryMap.get(""+allCategoriesList.get(i).getCategoryId()));
			}
		}
		System.out.println(categoryWiseSubcategoryMap.size());
		List<Categories> parentCategoriesList = null;
		parentCategoriesList = (categoriesService.getNavCategoriesList().size()>0)? (categoriesService.getNavCategoriesList()) : null;
		List<Categories> parentWithChildCategoriesList = new ArrayList<Categories>();
		List<Categories> noChildCategoriesList = new ArrayList<Categories>();
		List<Integer> keyList = new ArrayList<Integer>(categoryWiseSubcategoryMap.keySet());
		for(int i=0; i<keyList.size(); i++){
			for(int j=0; j<parentCategoriesList.size(); j++){
				if(keyList.get(i).equals(parentCategoriesList.get(j).getCategoryId())){
					parentWithChildCategoriesList.add(parentCategoriesList.get(j));
				}
				if(i==0 && !keyList.contains(parentCategoriesList.get(j).getCategoryId())){
					noChildCategoriesList.add(parentCategoriesList.get(j));
				}
			}
		}
		List<Categories> navParentCategoriesList = null;
		if(parentWithChildCategoriesList.size()>=3){
			navParentCategoriesList = new ArrayList<>(parentWithChildCategoriesList.subList(0,3));
			List<Categories> restParentCatList = parentWithChildCategoriesList.subList(3, parentWithChildCategoriesList.size());
			noChildCategoriesList.addAll(restParentCatList);
			for(int i=0; i<restParentCatList.size(); i++){
				noChildCategoriesList.addAll(categoriesService.getCategoryWiseSubcategoryList(restParentCatList.get(i)));
			}
		}else{
			navParentCategoriesList = parentWithChildCategoriesList;
		}
		List<Categories> topCategoriesList = null;
		if(parentWithChildCategoriesList.size()>=6){
			topCategoriesList = new ArrayList<>(parentWithChildCategoriesList.subList(0,6));
		}else{
			topCategoriesList = parentWithChildCategoriesList;
		}
		HashMap<String, Object> menuMap = new HashMap<String, Object>();
		menuMap.put("navParentCategoriesList", navParentCategoriesList);
		menuMap.put("noChildCategoriesList", noChildCategoriesList);
		menuMap.put("categoryWiseSubcategoryMap", categoryWiseSubcategoryMap);
		menuMap.put("topCategoriesList", topCategoriesList);
		
		return menuMap;
	}
	
	public HashMap<String, String> getCartSummary(HttpServletRequest request){
		HashMap<String, String> cartSummaryMap = new HashMap<String, String>();
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
		cartSummaryMap.put("numberOfItems", String.valueOf(numberOfItems));
		cartSummaryMap.put("totalPrice", String.valueOf(totalPrice));
		return cartSummaryMap;
	}
}
