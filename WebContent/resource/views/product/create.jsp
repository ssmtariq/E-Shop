<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:if test="${products!=null}">
	<c:set var="pageTitle" value="Update Product"></c:set>
</c:if>
<c:if test="${products==null}">
	<c:set var="pageTitle" value="Create Product"></c:set>
</c:if>
<c:import url="/resource/layout/layoutHeader.jsp">
	<c:param name="pageTitle" value="${pageTitle}"></c:param>
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
					<h3 class="text-center section-title">
						<c:if test="${products!=null}">
							<bean:message key="productUpdate.header"/>
						</c:if>
						<c:if test="${products==null}">
							<bean:message key="productCreate.header"/>
						</c:if>
					</h3>
					<p>Welcome, here you can add products to our product list. If you have previously registered with us, 
					<a href="#">click here</a>
					</p>
					<c:if test="${categories!=null}">
						<c:set var="formAction" value="/productAction?method=update"></c:set>
					</c:if>
					<c:if test="${categories==null}">
						<c:set var="formAction" value="/productAction?method=save"></c:set>
					</c:if>
					<html:form styleClass="form-horizontal" action="${formAction}" styleId="form-product-entry" enctype="multipart/form-data">
						<div class="form-group">
							<label for="productName"
								class="col-sm-4 control-label form-title-text"><bean:message key="productName.header"/><span style="color: red;">*</span></label>
							<div class="col-sm-6 offset-sm-2">
								<c:if test="${products!=null}">
									<html:hidden property="productId" styleClass="form-control" styleId="productId" value="${products.productId}"></html:hidden>
									<html:hidden property="createdOn" styleClass="form-control" styleId="createdOn" value="${products.createdOn}"></html:hidden>
									<html:hidden property="updatedOn" styleClass="form-control" styleId="updatedOn" value="${products.updatedOn}"></html:hidden>
									<html:text property="productName" styleClass="form-control" styleId="productName" value="${products.productName}"></html:text>
								</c:if>
								<c:if test="${products==null}">
									<html:text property="productName" styleClass="form-control"
									styleId="productName"></html:text>
								</c:if>
							</div>
							<div class="row">
								<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="productName"/></div>
							</div>
						</div>
						<div class="form-group">
							<label for="categoryId"
								class="col-sm-4 control-label form-title-text"><bean:message key="categoryId.header"/><span style="color: red;">*</span></label>
							<div class="col-sm-6 offset-sm-2">
								<select name="categoryId" class="form-control" id="categoryId">
									<option value="">Choose a Category</option>
									<c:forEach items="${categoriesList}" var="categories">
										<option value="${categories.categoryId}">${categories.categoryName}</option>
									</c:forEach>
								</select>
							</div>
							<div class="row">
								<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="categoryId"/></div>
							</div>
						</div>
						<div class="form-group">
							<label for="availability"
								class="col-sm-4 control-label form-title-text"><bean:message key="availability.header"/><span style="color: red;">*</span></label>
							<div class="col-sm-6 offset-sm-2">
								<select name="availability" class="form-control"
									id="availability">
									<option value="1">Available</option>
									<option value="2">Coming Soon</option>
									<option value="3">Not For Sale</option>
								</select>
							</div>
							<div class="row">
								<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="availability"/></div>
							</div>
						</div>
						<div class="form-group">
							<label for="quantity"
								class="col-sm-4 control-label form-title-text"><bean:message key="quantity.header"/><span style="color: red;">*</span></label>
							<div class="col-sm-6 offset-sm-2">
								<c:if test="${products!=null}">
									<html:text property="quantity" styleClass="form-control" value="${products.quantity}"
									styleId="quantity"></html:text>
								</c:if>
								<c:if test="${products==null}">
									<html:text property="quantity" styleClass="form-control"
									styleId="quantity"></html:text>
								</c:if>
							</div>
							<div class="row">
								<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="quantity"/></div>
							</div>
						</div>
						<div class="form-group">
							<label for="originalPrice"
								class="col-sm-4 control-label form-title-text"><bean:message key="originalPrice.header"/><span style="color: red;">*</span></label>
							<div class="col-sm-6 offset-sm-2">
								<c:if test="${products!=null}">
									<html:text property="originalPrice" styleClass="form-control" value="${products.originalPrice}"
									styleId="originalPrice"></html:text>
								</c:if>
								<c:if test="${products==null}">
									<html:text property="originalPrice" styleClass="form-control"
									styleId="originalPrice"></html:text>
								</c:if>
							</div>
							<div class="row">
								<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="originalPrice"/></div>
							</div>
						</div>
						<div class="form-group">
							<label for="discountPrice"
								class="col-sm-4 control-label form-title-text"><bean:message key="discountPrice.header"/></label>
							<div class="col-sm-6 offset-sm-2">
								<c:if test="${products!=null}">
									<html:text property="discountPrice" styleClass="form-control" styleId="discountPrice" value="${products.discountPrice}"></html:text>
								</c:if>
								<c:if test="${products==null}">
									<html:text property="discountPrice" styleClass="form-control"
									styleId="discountPrice"></html:text>
								</c:if>
							</div>
							<div class="row">
								<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="discountPrice"/></div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-8">
								<div class="checkbox">
									<label> <input type="checkbox" name="featuredItem"
										id="featuredItem">&nbsp;&nbsp; <bean:message key="isFeatured.header"/>
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="productImage"
								class="col-sm-4 control-label form-title-text"><bean:message key="productImage.header"/><span style="color: red;">*</span></label>
							<div class="col-sm-6 offset-sm-2">
								<html:file property="productImage" styleId="productImage"></html:file>
							</div>
							<div class="row">
								<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="productImage"/></div>
							</div>
						</div>
						<div class="form-group">
							<label for="imageCaption"
								class="col-sm-4 control-label form-title-text"><bean:message key="imageCaption.header"/><span style="color: red;">*</span></label>
							<div class="col-sm-6 offset-sm-2">
								<c:if test="${products!=null && productImages!= null}">
									<html:text property="imageCaption" styleClass="form-control" value="${productImages.caption}"
									styleId="imageCaption"></html:text>
								</c:if>
								<c:if test="${productImages==null}">
									<html:text property="imageCaption" styleClass="form-control"
									styleId="imageCaption"></html:text>
								</c:if>
							</div>
							<div class="row">
								<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="imageCaption"/></div>
							</div>
						</div>
						<div class="form-group">
							<label for="description" style="padding-right: 0px;"
								class="col-sm-4 control-label form-title-text"><bean:message key="productDescription.header"/></label>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-8 offset-sm-2" style="padding-left: 0px;">
								<c:if test="${products!=null}">
									<textarea rows="10	" cols="10" id="description" name="description" class="form-control">${products.description}</textarea>
								</c:if>
								<c:if test="${products==null}">
									<textarea rows="10	" cols="10" id="description" name="description" class="form-control"></textarea>
								</c:if>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-6 offset-sm-2 ">
								<html:submit styleClass="btn btn-default btn-form-submit text-uppercase">
									<c:if test="${products!=null}">
										<bean:message key="btnUpdateProduct.header" />
									</c:if>
									<c:if test="${products==null}">
										<bean:message key="btnAddProduct.header"/>
									</c:if>
								</html:submit>
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
			/* 	$("#quantity").prop('type', 'number');  */
				$("#productName").attr('placeholder','Product Name');
				$("#quantity").attr('placeholder','Product Quantity');
				$("#originalPrice").attr('placeholder','Original Price');
				$("#discountPrice").attr('placeholder','Discount Price');
				$("#imageCaption").attr('placeholder','Image Caption');
				if(categoryId!=null && categoryId!=""){
					$("#categoryId").val(categoryId);
				}
				if(availability!=null && availability!=""){
					$("#availability").val(availability);
				}
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