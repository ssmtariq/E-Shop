<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<c:import url="/resource/layout/layoutHeader.jsp">
		<c:param name="pageTitle" value="signIn.header"></c:param>
	</c:import>
</head>
<body>
	<!-- header-section-starts -->
		<c:import url="/resource/layout/layoutNavigator.jsp"></c:import>
	<!-- header-section-ends -->
		
	<!-- Banner top starts -->
		<c:import url="/resource/layout/layoutBanner.jsp"></c:import>
	<!-- Banner top end -->
		
	
	<!-- content-section-starts -->
		<div class="content">
			<div class="container">
				<div class="login-page" style="padding-top: 0;">
					<div class="dreamcrub" style="padding-bottom: 0px; margin: 0 0;">
						<ul class="breadcrumbs">
							<li class="home"><a href="${pageContext.request.contextPath}/home.do" title="Go to Home Page">Home</a>&nbsp;
								<span>&gt;</span></li>
							<li class="women">Sign In</li>
						</ul>
						<ul class="previous">
							<li><html:link page="/home.do">Back to Previous Page</html:link></li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="account_grid">
						<div class="col-md-6 login-left wow fadeInLeft"
							data-wow-delay="0.4s">
							<h2>NEW USERS</h2>
							<p>By creating an account with our store, you will be able to
								move through the checkout process faster, store multiple shipping
								addresses, view and track your orders in your account and more.</p>
							<html:link page="/user.do?method=signUp">
								<span class="acount-btn">Create an Account</span>
							</html:link>
						</div>
						<div class="col-md-6 login-right wow fadeInRight"
							data-wow-delay="0.4s">
							<h3>REGISTERED USERS</h3>
							<p style="margin: 0;">If you have an account with us, please log in.</p>
							<c:if test='${message=="userInactive"}'>
								<div style="color: red;">You have not activated your account. Please check your email inbox to activate and then try again!</div>
							</c:if>
							<c:if test='${message=="again"}'>
								<div style="color: red;">Invalid Email Or Password, Please try again!</div>
							</c:if>
							<c:if test='${message=="signOut"}'>
								<div style="color: red;">You have been Signed Out, Please Sign In to Get Our Service!</div>
							</c:if>
							<c:if test='${message=="pleaseSignIn"}'>
								<div style="color: red;">Please Sign In to Checkout and Get Our Service!</div>
							</c:if>
							<c:set var="formAction" value="/userAccess?method=verifySignIn"></c:set>
							<c:if test='${createOrder=="createOrder"}'>
								<c:set var="formAction" value="/userAccess?method=verifySignIn&createOrder=createOrder"></c:set>
							</c:if>
							<html:form action="${formAction}">
								<div>
									<span>Email Address<label style="color: red;">*</label></span> <html:text property="email" styleId="email"></html:text>
									<div class="messages" style="padding: 0 0;"><html:errors property="email"/></div>
								</div>
								<div>
									<span>Password<label style="color: red;">*</label></span> <html:password property="password" styleId="password"></html:password>
									<div class="messages" style="padding: 0 0;"><html:errors property="email"/></div>
								</div>
								<a class="forgot" href="${pageContext.request.contextPath}/user.do?method=accessRecovery">Forgot Your Password?</a> 
								<input type="submit" value="Sign In">
							</html:form>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
		</div>
	<!-- content-section-end -->
	
	
	<!-- Footer Section starts here -->
		<c:import url="/resource/layout/layoutFooter.jsp"></c:import>
	<!-- Footer Section end here -->
	
	<!--==========================Page Script Start==========================================-->
	<script type="text/javascript">
		$(document).ready(function(){
			$("#email").attr('placeholder', 'Email Address');
			$("#password").attr('placeholder', 'Password');
		});
	</script>
	<!--==========================Page Script Start==========================================-->
</body>
</html>