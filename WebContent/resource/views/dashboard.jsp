<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:import url="/resource/layout/layoutHeader.jsp">
	<c:param name="pageTitle" value="dashboard.header"></c:param>
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
				<c:import url="/resource/layout/adminPanelLayoutSidebar.jsp"></c:import>
			</div>
			<!-- Sidebar close -->
			<!-- Featured Products Slide -->
			<div class="col-md-9 col-sm-8 col-xs-12">
				<h3 class="text-center section-title"> Dashboard </h3>
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-4" style="padding-left: 0px; padding-right: 30px;">
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="panel-title">
										<i class="fa fa-users fa-2x"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>User</strong>
									</div>
								</div>
								<div class="panel-body">
									<h5><i class="fa fa-user-plus"></i> <a href="${pageContext.request.contextPath}/user.do?method=create" style="color: black;">Create User</a></h5>
									<c:if test="${userType==1}">
										<h5><a href="${pageContext.request.contextPath}/user.do?method=createAdmin" style="color: black;">Create Admin</a></h5>
										<h5><a href="${pageContext.request.contextPath}/user.do?method=adminList" style="color: black;">Admin List</a></h5>
									</c:if>
								</div>
							</div>
						</div>
						<div class="col-md-4" style="">
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="panel-title">
										<i class="fa fa-anchor fa-2x"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>Category</strong>
									</div>
								</div>
								<div class="panel-body">
									<h5><a href="${pageContext.request.contextPath}/category.do?method=create" style="color: black;">Create</a></h5>
									<h5><a href="${pageContext.request.contextPath}/category.do?method=list" style="color: black;">List</a></h5>
								</div>
							</div>
						</div>
						<div class="col-md-4" style="padding-left: 30px; padding-right: 0px;">
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="panel-title">
										<i class="fa fa-product-hunt fa-2x"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>Product</strong>
									</div>
								</div>
								<div class="panel-body">
									<h5><a href="${pageContext.request.contextPath}/product.do?method=create" style="color: black;">Create</a></h5>
									<h5><a href="${pageContext.request.contextPath}/product.do?method=list" style="color: black;">List</a></h5>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-4" style="padding-left: 0px; padding-right: 30px;">
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="panel-title">
										<i class="fa fa-users fa-2x"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>Order</strong>
									</div>
								</div>
								<div class="panel-body">
									<h5><a href="${pageContext.request.contextPath}/order.do?method=list" style="color: black;">List</a></h5>
								</div>
							</div>
						</div>
						<div class="col-md-4" style="">
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="panel-title">
										<i class="fa fa-anchor fa-2x"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>Payment</strong>
									</div>
								</div>
								<div class="panel-body">
									<h5><a href="${pageContext.request.contextPath}/payment.do?method=list" style="color: black;">List</a></h5>
								</div>
							</div>
						</div>
					</div>
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
			$(document).ready(function(){
				$(".isDashboard").hide();
			})
		</script>
	<!-- Page Script End -->
</body>
</html>