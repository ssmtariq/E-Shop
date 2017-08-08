<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:import url="/resource/layout/layoutHeader.jsp">
	<c:param name="pageTitle" value="Access Recovery"></c:param>
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
					<h3 class="text-center section-title">Access Recovery</h3>
					<p>Welcome, please enter the following details to continue.</p>
					<p>
						If you have previously registered with us, <a href="#">click
							here</a>
					</p>
					<html:form styleClass="form-horizontal"
						action="/recoveryAction?method=recoverAccount"
						styleId="form-access-recovery">
						<div class="form-group">
							<label for="email"
								class="col-sm-4 control-label form-title-text">Email</label>
							<div class="col-sm-6 offset-sm-2">
								<html:text property="email" styleClass="form-control"
									styleId="email"></html:text>
							</div>
						</div>
						<div class="form-group">
							<label for="mobileNo"
								class="col-sm-4 control-label form-title-text">Mobile No</label>
							<div class="col-sm-6 offset-sm-2">
								<html:text property="mobileNo" styleClass="form-control"
									styleId="mobileNo"></html:text>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-6 offset-sm-2 ">
								<html:submit styleClass="btn btn-default btn-form-submit">RECOVER PASSWORD</html:submit>
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
</body>
</html>