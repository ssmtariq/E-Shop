<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:import url="/resource/layout/layoutHeader.jsp">
	<c:param name="pageTitle" value="Confirmation Failure"></c:param>
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
				<div class="reg">
					<h3 class="text-center section-title">Confirmation Failure</h3>
					<blockquote>
						<h3>
							<i class="fa fa-ban fa-2x" style="color: red;"></i>
							&nbsp;&nbsp;&nbsp;Sorry, Your Account Have Already Been Confirmed!
						</h3>
					</blockquote>
					<p>Sorry, you have already been confirmed your account. Please sign in
						<a href="${pageContext.request.contextPath}/user.do?method=signIn">click here</a>
					</p>
					
				</div>
			</div>
			<!-- Featured Products end -->

		</div>
	</div>
	<!-- Sidebar and Featured Products Section End -->

	<!-- Footer section starts -->
	<c:import url="/resource/layout/layoutFooter.jsp"></c:import>
	<!-- Footer section end -->
</body>
</html>