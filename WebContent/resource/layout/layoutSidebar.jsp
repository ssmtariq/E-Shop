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
	<a href="${pageContext.request.contextPath}/product.do?method=criteriaWiseProduct&criteria=latest" class="list-group-item"> 
		<span class="glyphicon glyphicon-th-list"> <bean:message key="latest.header"/> </span>
	</a> 
	<a href="${pageContext.request.contextPath}/product.do?method=criteriaWiseProduct&criteria=featured" class="list-group-item"> 
		<span class=" glyphicon glyphicon-globe"> <bean:message key="featured.header"/> </span>
	</a> 
	<a href="${pageContext.request.contextPath}/product.do?method=criteriaWiseProduct&criteria=upcoming" class="list-group-item"> 
		<span class=" glyphicon glyphicon-equalizer"> <bean:message key="upcoming.header"/> </span> <!-- <span class="badge">14</span> -->
	</a> 
	<a href="${pageContext.request.contextPath}/product.do?method=criteriaWiseProduct&criteria=topSale" class="list-group-item"> 
		<span class=" glyphicon glyphicon-briefcase"> <bean:message key="topSale.header"/> </span> <!-- <span class="badge">14</span> -->
	</a> 
	<a href="#" class="list-group-item"> 
		<span class=" glyphicon glyphicon-text-background"> <bean:message key="topRated.header"/> </span>
	</a> 
	<a href="${pageContext.request.contextPath}/user.do?method=signUp" class="list-group-item"> 
		<i class="fa fa-user-plus fa-1x"> &nbsp; <bean:message key="register.header"/> </i>
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
