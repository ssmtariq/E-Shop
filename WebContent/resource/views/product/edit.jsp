<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:import url="/resource/layout/layoutHeader.jsp">
	<c:param name="pageTitle" value="Edit Product"></c:param>
</c:import>
<script src="${pageContext.request.contextPath}/resource/js/tinymce/tinymce.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/tinymce/init-tinymce.js"></script>

</head>
<body>
	<!-- header-section-starts -->
	<c:import url="/resource/layout/layoutNavigator.jsp"></c:import>
	<!-- header-section-ends -->

	<!-- Banner top starts -->
	<c:import url="/resource/layout/layoutBanner.jsp"></c:import>
	<!-- Banner top end -->

	<!-- Sidebar and Featured Products Section Start -->
	<div class="container">
		<div class="row">
			<!-- Sidebar start -->
			<div class="col-md-3 col-sm-4 col-xs-12">
				<c:import url="/resource/layout/layoutSidebar.jsp"></c:import>
			</div>
			<!-- Sidebar close -->
			<!-- Featured Products Slide -->
			<div class="col-md-9 col-sm-8 col-xs-12" style="background-color: #F5F5F5">
				<div class="reg">
					<h3 class="text-center section-title"> Edit Product </h3>
					<p>Welcome, here you can add products to our product list. If you have previously registered with us, 
					<a href="#">click here</a>
					</p>
					<html:form styleClass="form-horizontal" action="/product?method=update" styleId="form-product-update">
						<div class="form-group">
							<label for="productName"
								class="col-sm-4 control-label form-title-text">	Name</label>
							<div class="col-sm-6 offset-sm-2">
								<html:hidden property="productId" styleClass="form-control" styleId="productId" value="${products.productId}"></html:hidden>
								<html:hidden property="createdOn" styleClass="form-control" styleId="createdOn" value="${products.createdOn}"></html:hidden>
								<html:hidden property="updatedOn" styleClass="form-control" styleId="updatedOn" value="${products.updatedOn}"></html:hidden>
								<html:text property="productName" styleClass="form-control" styleId="productName" value="${products.productName}"></html:text>
							</div>
						</div>
						<div class="form-group">
							<label for="categoryId"
								class="col-sm-4 control-label form-title-text">Category</label>
							<div class="col-sm-6 offset-sm-2">
								<select name="categoryId" class="form-control" id="categoryId">
									<option value="0">Choose a Category</option>
									<c:forEach items="${categoriesList}" var="categories">
										<option value="${categories.categoryId}">${categories.categoryName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="availability"
								class="col-sm-4 control-label form-title-text">Availability</label>
							<div class="col-sm-6 offset-sm-2">
								<select name="availability" class="form-control" id="availability">
									<option value="0">Choose Availability</option>
									<option value="1">Available</option>
									<option value="2">Coming Soon</option>
									<option value="3">Not For Sale</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="quantity"
								class="col-sm-4 control-label form-title-text">Quantity</label>
							<div class="col-sm-6 offset-sm-2">
								<html:text property="quantity" styleClass="form-control" value="${products.quantity}"
									styleId="quantity"></html:text>
							</div>
						</div>
						<div class="form-group">
							<label for="originalPrice"
								class="col-sm-4 control-label form-title-text">Original Price</label>
							<div class="col-sm-6 offset-sm-2">
								<html:text property="originalPrice" styleClass="form-control" value="${products.originalPrice}"
									styleId="originalPrice"></html:text>
							</div>
						</div>
						<div class="form-group">
							<label for="discountPrice"
								class="col-sm-4 control-label form-title-text">Discount Price</label>
							<div class="col-sm-6 offset-sm-2">
								<html:text property="discountPrice" styleClass="form-control" styleId="discountPrice" value="${products.discountPrice}"></html:text>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-8">
								<div class="checkbox">
									<label> <input type="checkbox" name="featuredItem"
										id="featuredItem"> Is Featured
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="parentId"
								class="col-sm-4 control-label form-title-text">Product Description</label>
							<!-- <div class="col-sm-6 offset-sm-2">
								<textarea rows="8" cols="10" id="description" name="description" class="form-control"></textarea>
							</div> -->
						</div>
						<div class="form-group">
							<!-- <label for="parentId"
								class="col-sm-4 control-label form-title-text">Product Description</label> -->
							<div class="col-sm-offset-2 col-sm-8 offset-sm-2" style="padding-left: 0px;">
								<textarea rows="10	" cols="10" id="description" name="description" class="form-control">${products.description}</textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-6 offset-sm-2 ">
								<html:submit styleClass="btn btn-default btn-form-submit">UPDATE PRODUCT</html:submit>
								<p class="click">
									By clicking this button, you are agree to my <a href="#">Policy
										Terms and Conditions.</a>
								</p>
							</div>
						</div>
					</html:form>
				</div>
			</div>
			<!-- Featured Products end -->

		</div>
	</div>
	<!-- Sidebar and Featured Products Section End -->

	<!-- Footer section starts -->
	<c:import url="/resource/layout/layoutFooter.jsp"></c:import>
	<!-- Footer section end -->
	
	<!-- Page Script -->
		<script type="text/javascript">
			var categoryId = "${products.category.categoryId}";
			var availability = "${products.availability}";
			var isFeatured = "${products.featured}";
			$(document).ready(function(){
				$("#categoryId").val(categoryId);
				$("#availability").val(availability);
				if(isFeatured==1){
					$("#featuredItem").attr('checked', true);
				}else{
					$("#featuredItem").attr('checked', false);
				}
			});
		</script>
	<!-- Page Script End -->
</body>
</html>