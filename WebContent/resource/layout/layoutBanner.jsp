<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="banner-top" style="padding-bottom:10px; padding-top: 10px;">
	<div class="container">
		<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header" style="width: 265px">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<div class="logo">
					<h1>
						<a href="${pageContext.request.contextPath}/home.do"><span><bean:message key="logo.e.header"/></span> -<bean:message key="logo.shop.header"/></a>
					</h1>
				</div>
			</div>
			<!--/.navbar-header-->

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav pull-left">
					<li><html:link page="/home.do"><bean:message key="home.header"/></html:link></li>
					
<!--========================Dynamic Menu Start==================================================-->
					<c:forEach items="${navParentCategoriesList}" var="categories">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">${categories.categoryName}<b class="caret"></b></a>
							<ul class="dropdown-menu multi-column columns-3">
								<!-- <div class="row"> -->
									<!-- <div class="col-sm-4">
										<ul class="multi-column-dropdown col-sm-4"> -->
										
											<c:forEach items="${categoryWiseSubcategoryMap}" var="subCategoryMap">
												<c:if test="${subCategoryMap.key == categories.categoryId}">
													<c:forEach items="${subCategoryMap.value}" var="subCategory">
													<ul class="multi-column-dropdown col-sm-4">
											            <li><a href="${pageContext.request.contextPath}/product.do?method=categoryWiseProducts&categoryId=${subCategory.categoryId}">${subCategory.categoryName}</a></li>
										            </ul>
											        </c:forEach>
										        </c:if>  
											</c:forEach>
										<!-- </ul>
									</div> -->
									<div class="clearfix"></div>
								<!-- </div> -->
							</ul>
						</li>
					</c:forEach>
<!--========================Dynamic Menu End==================================================-->
					
<!--========================More Category Menu Start==================================================-->
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">More Category<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<c:forEach items="${moreCategoriesList}" var="moreCategories">
					            	<li><a href="${pageContext.request.contextPath}/product.do?method=categoryWiseProducts&categoryId=${moreCategories.categoryId}">${moreCategories.categoryName}</a></li>
           						</c:forEach>
							</ul>
						</li>
<!--========================More Menu End==================================================-->
					
					<li><a href="${pageContext.request.contextPath}/user.do?method=signUp">SIGN-UP</a></li>
				</ul>
			</div>
			<!--/.navbar-collapse-->
		</nav>
		<!--/.navbar-->
	</div>
</div>
