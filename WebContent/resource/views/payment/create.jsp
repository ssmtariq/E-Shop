<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:import url="/resource/layout/layoutHeader.jsp">
	<c:param name="pageTitle" value="payment.header"></c:param>
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
					<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
				        <!-- Identify your business so that you can collect the payments. -->
				        <input type="hidden" name="business" value="tushar.ghosh-facilitator@bjitgroup.com">
				        
				        <!-- Specify a Buy Now button. -->
				        <input type="hidden" name="cmd" value="_xclick">
				        
				        <!-- Specify details about the item that buyers will purchase. -->
				        <c:forEach items="${shoppingCartList}" var="carItem">
       				        <input type="hidden" name="item_name" value="${carItem.productName}">
					        <input type="hidden" name="item_number" value="${carItem.productId}">
					        <input type="hidden" name="quantity" value="${carItem.quantity}">
					        <input type="hidden" name="amount" value="${carItem.productPrice}">
					        <input type="hidden" name="orderId" value="${orderId}">
					        <input type="hidden" name="currency_code" value="USD">
				        </c:forEach>
				        
				        <!-- Specify URLs -->
				        <input type='hidden' name='cancel_return' value='http://localhost:8080/eCommerceBjitFinalProject/paymentAction.do?method=create'>
				        <input type='hidden' name='return' value='http://localhost:8080/eCommerceBjitFinalProject/paymentAction.do?method=save'>
				        				
				        
				        <!-- Display the payment button. -->
				        <input type="image" name="submit" border="0"
				        src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif" alt="PayPal - The safer, easier way to pay online">
				        <img alt="" border="0" width="1" height="1" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" >
				    </form>
				</div>
			</div>
			<!-- Featured Products end -->
		</div>
	</div>
	<!-- Sidebar and Featured Products Section End -->

	<!-- Footer section starts -->
	<c:import url="/resource/layout/layoutFooter.jsp"></c:import>
	<!-- Footer section end -->
	
<!--==========================Page Script Start==========================================-->
	<!--==========Validation Scripts End==============-->
<!--==========================Page Script End==========================================-->
</body>
</html>
