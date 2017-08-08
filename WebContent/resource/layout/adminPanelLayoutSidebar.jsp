<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<div class="mini-submenu">
	<span class="icon-bar"></span> <span class="icon-bar"></span> <span
		class="icon-bar"></span>
</div>
<div class="list-group">
	<a href="${pageContext.request.contextPath}/home.do" class="list-group-item" style="background-color: #000; color: #fff;">
		<h4 style="padding: 0px;">
			<strong><bean:message key="eShop.header"/></strong> <span class="pull-right" id="slide-submenu">
				<i class="fa fa-gift"></i>
			</span>
		</h4>
	</a> 
	<a href="${pageContext.request.contextPath}/home.do" class="list-group-item"> <!-- <i class="fa fa-comment-o"></i> -->
		<span class=" glyphicon glyphicon-home"> <bean:message key="home.header"/> </span>
	</a> 
	<a href="${pageContext.request.contextPath}/user.do?method=createAdmin" class="list-group-item"> 
		<span class="glyphicon glyphicon-th-list"> <bean:message key="createAdmin.header"/> </span>
	</a> 
	<a href="${pageContext.request.contextPath}/user.do?method=signUp" class="list-group-item"> 
		<span class="glyphicon glyphicon-th-list"> <bean:message key="userCreate.header"/> </span>
	</a> 
	<a href="${pageContext.request.contextPath}/user.do?method=adminList" class="list-group-item"> 
		<span class="glyphicon glyphicon-th-list"> <bean:message key="listAdmin.header"/> </span>
	</a> 
	<a href="${pageContext.request.contextPath}/order.do?method=list" class="list-group-item"> 
		<span class=" glyphicon glyphicon-globe"> <bean:message key="orderList.header"/> </span>
	</a> 
	<a href="${pageContext.request.contextPath}/payment.do?method=list" class="list-group-item"> 
		<span class=" glyphicon glyphicon-equalizer"> <bean:message key="paymentList.header"/> </span> <!-- <span class="badge">14</span> -->
	</a> 
	<a href="${pageContext.request.contextPath}/category.do?method=create" class="list-group-item"> 
		<span class=" glyphicon glyphicon-briefcase"> <bean:message key="categoryCreate.header"/> </span> <!-- <span class="badge">14</span> -->
	</a> 
	<a href="${pageContext.request.contextPath}/category.do?method=list" class="list-group-item"> 
		<span class=" glyphicon glyphicon-briefcase"> <bean:message key="categoryList.header"/> </span> <!-- <span class="badge">14</span> -->
	</a> 
	<a href="${pageContext.request.contextPath}/product.do?method=create" class="list-group-item"> 
		<span class=" glyphicon glyphicon-briefcase"> <bean:message key="productCreate.header"/> </span> <!-- <span class="badge">14</span> -->
	</a> 
	<a href="${pageContext.request.contextPath}/product.do?method=list" class="list-group-item"> 
		<span class=" glyphicon glyphicon-briefcase"> <bean:message key="productList.header"/> </span> <!-- <span class="badge">14</span> -->
	</a> 
</div>

<div class="panel panel-default isDashboard">
	<div class="panel-heading">
		<div class="panel-title">
			<h4>Contact Address</h4>
		</div>
	</div>
	<div class="panel-body">
		<address>
			<strong>E-Shop</strong><br> House-7, Road-2/C,<br> Block-J,
			Baridhara,<br> Dhaka-1212, Bangladesh<br>
		</address>
	</div>
</div>
