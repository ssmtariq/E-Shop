package com.ecommerce.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ecommerce.form.CategoriesForm;
import com.ecommerce.model.Categories;
import com.ecommerce.service.CategoriesService;
import com.ecommerce.util.ApplicationConstants;
import com.ecommerce.util.FileUploaderUtil;

public class CategoryAction extends DispatchAction{
	private CategoriesService categoriesService;
	
	public void setCategoriesService(CategoriesService categoriesService) {
		this.categoriesService = categoriesService;
	}
	
	public ActionForward save(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		CategoriesForm categoriesForm = (CategoriesForm) actionForm;
		Categories  category = new Categories();
		categoriesForm.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		categoriesForm.setUpdatedOn(categoriesForm.getCreatedOn());
		BeanUtils.copyProperties(category, categoriesForm);
		if(request.getParameter("parentId")!="" && !request.getParameter("parentId").equals("null")){
			category.setParent(new Categories(Integer.parseInt(request.getParameter("parentId"))));
		}
		Integer categoryId =null;
		try{
			categoryId = categoriesService.insert(category);
			String imageName = FileUploaderUtil.uploadImage(ApplicationConstants.CATEGORY_IMAGE_PATH, categoriesForm.getCategoryImage(), categoryId);
			category = categoriesService.getCategories(categoryId);
			category.setImageName(categoryId+imageName);
			categoriesService.update(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(categoryId!=null){
			System.out.println("success");
			request.setAttribute("message", "Category Created Successfully!");
			return (actionMapping.findForward("success"));
		} else {
			return (actionMapping.findForward("failure"));
		}
	}
	
	public ActionForward update(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		System.out.println("update called");
		CategoriesForm categoriesForm = (CategoriesForm) actionForm;
		Categories  categories= new Categories();
		BeanUtils.copyProperties(categories, categoriesForm);
		categories.setUpdatedOn(new Timestamp(System.currentTimeMillis()));
		if(request.getParameter("parentId")!="" && !request.getParameter("parentId").equals("null")){
			categories.setParent(new Categories(Integer.parseInt(request.getParameter("parentId"))));
		}
		Integer categoryId =null;
		try{
			String imageName = FileUploaderUtil.uploadImage(ApplicationConstants.CATEGORY_IMAGE_PATH, categoriesForm.getCategoryImage(), categories.getCategoryId());
			categories.setImageName(categories.getCategoryId()+imageName);
			categoryId=categoriesService.update(categories);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(categoryId!=null){
			request.setAttribute("message", "Category Updated Successfully!");
		    return (actionMapping.findForward("updateSuccess"));
	    } else {
	    	 return (actionMapping.findForward("updateFailed"));
	    }
	}
}
