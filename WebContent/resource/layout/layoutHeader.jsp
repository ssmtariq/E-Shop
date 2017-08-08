<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<title><bean:message key="${param.pageTitle}"/></title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/resource/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath}/resource/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/resource/css/my-style.css" rel="stylesheet" type="text/css"/>

<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Eshop, Ecommerce, BJIT" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); 
	 function hideURLbar(){
		 window.scrollTo(0,1); 
	 } 
</script>
<!--webfont-->
<!-- for bootstrap working -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/bootstrap-3.1.1.min.js"></script>
<!-- //for bootstrap working -->
<!-- cart -->
<script src="${pageContext.request.contextPath}/resource/js/simpleCart.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/underscore-min.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/validate.min.js"></script>
<!-- cart -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/flexslider.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/rating_stylesheet.css">
<link href="${pageContext.request.contextPath}/resource/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<style type="text/css">
	.closeButton {
		background: url('resource/images/close_1.png') no-repeat 0px 0px;
		cursor: pointer;
		width: 28px;
		height: 28px;
		position: absolute;
		right: 0px;
		top: 25px;
		-webkit-transition: color 0.2s ease-in-out;
		-moz-transition: color 0.2s ease-in-out;
		-o-transition: color 0.2s ease-in-out;
		transition: color 0.2s ease-in-out;
	}
	.shoppingCartHeader{
		position: relative;
      	background-color: #FDFDFD;
     	}
</style>
