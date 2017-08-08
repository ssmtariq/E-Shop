<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:import url="/resource/layout/layoutHeader.jsp">
	<c:param name="pageTitle" value="Order List"></c:param>
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
				<h3 class="text-center section-title"> Order List </h3>
				<c:if test='${message!="Order Deleted Successfully!"}'>
					<div style="color: green;">${message}</div>
				</c:if>
				<c:if test='${message=="Order Deleted Successfully!"}'>
					<div style="color: red;">${message}</div>
				</c:if>
				<table class="table table-striped table-bordered ">
					<thead>
						<tr>
							<th style="text-align: center;">Date</th>
							<th style="text-align: center;">Product Name</th>
							<th style="text-align: center;">Unit Price</th>
							<th style="text-align: center;">Quantity</th>
							<th style="text-align: center;">Tax/Vat</th>
							<th style="text-align: center;">Shipping Cost</th>
							<c:if test='${currentAdmin!=null}'>
								<th style="text-align: center;">Modify</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${mapList}" var="item" varStatus="i">
							<tr valign="middle">
 								<td valign="middle">${item.createdOn}</td>
 								<td valign="middle">${item.productName}</td> 
 								<td align="right">${item.unitPrice}</td>
 								<td align="center">${item.quantity}</td>
 								<td align="right">${item.taxVat}</td>
 								<td align="right">${item.shippingCost}</td>
 								<c:if test='${currentAdmin!=null}'>
									<td style="text-align: center;">
										<html:link page="/order.do?method=edit&orderId=${item.orderId}">
											<i class="fa fa-pencil-square-o fa-lg"></i> |
										</html:link>
										<html:link page="/order.do?method=delete&orderId=${item.orderId}" onclick="return confirm('Are you sure you want to delete this Order?');">
											<i class="fa fa-trash-o fa-lg"></i>
										</html:link>
									</td>
								</c:if>
							</tr>
						</c:forEach>
							<tr align="center">
								<td colspan="4">
									<html:link page="/order.do?method=create" styleClass="btn btn-default btn-form-submit">PLACE MORE ORDER</html:link>
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