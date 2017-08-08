<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:import url="/resource/layout/layoutHeader.jsp">
	<c:param name="pageTitle" value="paymentList.header"></c:param>
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
				<h3 class="text-center section-title"> Payment List </h3>
				<c:if test='${message!="Payments Deleted Successfully!"}'>
					<div style="color: green;">${message}</div>
				</c:if>
				<c:if test='${message=="Payments Deleted Successfully!"}'>
					<div style="color: red;">${message}</div>
				</c:if>
				<table class="table table-striped table-bordered ">
					<thead>
						<tr>
							<th style="text-align: center;">Method</th>
							<th style="text-align: center;">Date</th>
							<th style="text-align: center;">Amount</th>
							<th style="text-align: center;">Transaction Id</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${paymentsList}" var="payments" varStatus="i">
							<tr valign="middle">
								<td valign="middle">${payments.method}</td>
								<td>
									${payments.createdOn}
								</td>
								<td style="text-align: center;">${payments.amount}</td>
								<td style="text-align: center;">
									${payments.tranSactionId}
								</td>
							</tr>
						</c:forEach>
							<tr align="center">
								<td colspan="4">
									<html:link page="/home.do" styleClass="btn btn-default btn-form-submit">BACK TO HOME</html:link>
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