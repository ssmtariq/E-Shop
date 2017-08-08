<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:import url="/resource/layout/layoutHeader.jsp">
	<c:param name="pageTitle" value="Product List"></c:param>
</c:import>
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
			<div class="col-md-9 col-sm-8 col-xs-12">
				<h3 class="text-center section-title"> Product List </h3>
				<table class="table table-striped table-bordered ">
					<thead>
						<tr>
							<th style="text-align: center;">Product Name</th>
							<th style="text-align: center;">Category</th>
							<th style="text-align: center;">Quantity</th>
							<th style="text-align: center;">Original Price</th>
							<th style="text-align: center;">Discount Price</th>
							<th style="text-align: center;">Featured</th>
							<th style="text-align: center;">Availability</th>
							<th style="text-align: center;">Modify</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productsList}" var="products" varStatus="i">
							<tr>
								<td>${products.productName}</td>
								<td>${products.category.categoryName}</td>
								<td style="text-align: center;">${products.quantity}</td>
								<td style="text-align: right;">${products.originalPrice}</td>
								<td style="text-align: right;">${products.discountPrice}</td>
								<td style="text-align: center;">
									<c:if test="${products.featured==0}"><i class="fa fa-close fa-lg"></i></c:if>
									<c:if test="${products.featured==1}"><i class="fa fa-check fa-lg"></i></c:if>
								</td>
								<td style="text-align: center;">
									<c:if test="${products.availability==1}">Available</c:if>
									<c:if test="${products.availability==2}">Coming Soon</c:if>
									<c:if test="${products.availability==3}">Not for Sale</c:if>
								</td>
								<td style="text-align: center;">
									<html:link page="/product.do?method=edit&productId=${products.productId}">
										<i class="fa fa-pencil-square-o fa-lg"></i> |
									</html:link>
									<html:link page="/product.do?method=delete&productId=${products.productId}" onclick="return confirm('Are you sure you want to delete this Product?');">
										<i class="fa fa-trash-o fa-lg"></i>
									</html:link>
								</td>
							</tr>
						</c:forEach>	
							<tr align="center">
								<td colspan="8">
									<html:link page="/product.do?method=create" styleClass="btn btn-default btn-form-submit">ADD MORE PRODUCT</html:link>
								</td>
							</tr>					
					</tbody>
				</table>
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
			
		</script>
	<!-- Page Script End -->
</body>
</html>