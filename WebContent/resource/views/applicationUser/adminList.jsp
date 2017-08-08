<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:import url="/resource/layout/layoutHeader.jsp">
	<c:param name="pageTitle" value="Admin List"></c:param>
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
				<h3 class="text-center section-title"> Admin List </h3>
				<c:if test='${message!="Admin Deleted Successfully!"}'>
					<div style="color: green;">${message}</div>
				</c:if>
				<c:if test='${message=="Admin Deleted Successfully!"}'>
					<div style="color: red;">${message}</div>
				</c:if>
				<table class="table table-striped table-bordered ">
					<thead>
						<tr>
							<th style="text-align: center;">Name</th>
							<th style="text-align: center;">Email</th>
							<th style="text-align: center;">Type</th>
							<th style="text-align: center;">Status</th>
							<th style="text-align: center;">Modify</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${adminList}" var="admin" varStatus="i">
							<tr valign="middle">
								<td valign="middle">${admin.name}</td>
								<td>
									${admin.email}
								</td>
								<td style="text-align: center;">
									<c:if test="${admin.type == 0}">Admin</c:if>
									<c:if test="${admin.type == 1}">Super Admin</c:if>
								</td>
								<td style="text-align: center;">
									<c:if test="${admin.status == 0}">Inactive</c:if>
									<c:if test="${admin.status == 1}">Active</c:if>
									<c:if test="${admin.status == 2}">Blocked</c:if>
								</td>
								<td style="text-align: center;">
									<%-- <html:link page="/category.do?method=edit&categoryId=${admin.adminId}">
										<i class="fa fa-pencil-square-o fa-lg"></i> |
									</html:link> --%>
									<html:link page="/user.do?method=deleteAdmin&adminId=${admin.adminId}" onclick="return confirm('Are you sure you want to delete this Admin?');">
										<i class="fa fa-trash-o fa-lg"></i>
									</html:link>
								</td>
							</tr>
						</c:forEach>
							<tr align="center">
								<td colspan="4">
									<html:link page="/user.do?method=createAdmin" styleClass="btn btn-default btn-form-submit">ADD MORE ADMIN</html:link>
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