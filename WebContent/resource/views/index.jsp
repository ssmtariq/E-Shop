<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:import url="/resource/layout/layoutHeader.jsp">
	<c:param name="pageTitle" value="eshop.home.title"></c:param>
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
				<!-- <div class=""> -->
				<!-- <div class=""> -->
				<h3 class="text-center section-title">
					<bean:message key="featuredProduct.title" />
				</h3>
				<ul id="flexiselDemo3">
					<c:forEach items="${featuredProductList}" var="featuredProduct" varStatus="fp">
						<li><a href="${pageContext.request.contextPath}/product.do?method=show&productId=${featuredProduct.productId}">
								<!-- <img src="resource/images/l1.jpg" class="img-responsive" alt="" /> -->
								<img src="upload/product/${latestProductImagesList[fp.count-1].imageName}" alt="" height="310px;" width="200px;" />
							</a>
							<div class="product liked-product simpleCart_shelfItem">
								<a class="like_name"
									href="${pageContext.request.contextPath}/product.do?method=show&productId=${featuredProduct.productId}">${featuredProduct.productName}</a>
								<p>
									<input type="hidden"
										name="featuredProductQty_${featuredProduct.productId}"
										id="featuredProductQty_${featuredProduct.productId}"
										style="width: 75px; height: 28px;" class="" value="1" />
									<button class="btn btn-success btn-sm"
										onclick="shoppingCart.add(${featuredProduct.productId},$('#latestProductQty_${featuredProduct.productId}').val());">
										<i></i>
										<c:if test="${featuredProduct.discountPrice>0}">
											<span class="item_price" style="">$${featuredProduct.discountPrice}<del
													style="color: black;">
													$${featuredProduct.originalPrice}</del></span>
										</c:if>
										<c:if test="${featuredProduct.discountPrice==0}">
											<span class="item_price">$${featuredProduct.originalPrice}</span>
										</c:if>
									</button>
								</p>
							</div></li>
					</c:forEach>
				</ul>
				<script type="text/javascript">
									$(window).load(function() {
										$("#flexiselDemo3").flexisel({
											visibleItems : 4,
											animationSpeed : 1000,
											autoPlay : true,
											autoPlaySpeed : 3000,
											pauseOnHover : true,
											enableResponsiveBreakpoints : true,
											responsiveBreakpoints : {
												portrait : {
													changePoint : 480,
													visibleItems : 1
												},
												landscape : {
													changePoint : 640,
													visibleItems : 2
												},
												tablet : {
													changePoint : 768,
													visibleItems : 3
												}
											}
										});
				
									});
								</script>
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/resource/js/jquery.flexisel.js"></script>
				<!-- </div> -->
				<!-- </div> -->
			</div>
			<!-- Featured Products end -->

		</div>
	</div>
	<!-- Sidebar and Featured Products Section End -->


	<!-- content-section-starts-here -->
	<div class="container">
		<div class="main-content">
			<div class="products-grid">
				<header>
					<h3 class="text-center section-title">
						<bean:message key="latestProduct.title" />
					</h3>
				</header>

				<c:forEach items="${latestProductList}" var="latestProduct"
					varStatus="lp">
					<div
						class="col-md-2 col-sm-4 col-xs-6 product simpleCart_shelfItem text-center">
						<a
							href="${pageContext.request.contextPath}/product.do?method=show&productId=${latestProduct.productId}">
							<!-- <img src="resource/images/p1.jpg" alt="" /> --> <img
							src="upload/product/${latestProductImagesList[lp.count-1].imageName}"
							alt="" style="min-height: 200px; min-width: 170px;" />
						</a>
						<div class="mask">
							<a
								href="${pageContext.request.contextPath}/product.do?method=show&productId=${latestProduct.productId}">Quick
								View</a>
						</div>
						<div>
							<p>
								Rating: <span class="starRating"> <input id="rating5"
									type="radio" name="rating_${latestProduct.productId}" value="5">
									<label for="rating5">5</label> <input id="rating4" type="radio"
									name="rating_${latestProduct.productId}" value="4"> <label
									for="rating4">4</label> <input id="rating3" type="radio"
									name="rating_${latestProduct.productId}" value="3" checked>
									<label for="rating3">3</label> <input id="rating2" type="radio"
									name="rating_${latestProduct.productId}" value="2"> <label
									for="rating2">2</label> <input id="rating1" type="radio"
									name="rating_${latestProduct.productId}" value="1"> <label
									for="rating1">1</label>
								</span>
							</p>
						</div>
						<div style="overflow: hidden; height: 70px;">
							<html:link
								page="/product.do?method=show&productId=${latestProduct.productId}"
								styleClass="product_name">${latestProduct.productName}</html:link>
							<%-- <input type="hidden"  name="latestProductId_${latestProduct.productId}"  id="latestProductId_${latestProduct.productId}" value="${latestProduct.productId}"/> --%>
						</div>
						<div style="overflow: hidden;">
							Quantity: <input type="number"
								name="latestProductQty_${latestProduct.productId}"
								id="latestProductQty_${latestProduct.productId}"
								style="width: 75px; height: 28px;" value="1" />
						</div>
						<div style="height: 30px; margin-top: 5px; overflow: hidden;">
							<p>
								<a class="" href="#"> <input type="hidden"
									name="latestProductPrice_${latestProduct.productId}"
									id="latestProductPrice_${latestProduct.productId}"
									value="${latestProduct.originalPrice}" /> <%-- <button class="btn btn-success btn-sm" onclick="shoppingCart.add(${latestProduct.productId},$('#latestProductQty_${latestProduct.productId}').val());">
										<i></i> <span class="item_price">${latestProduct.originalPrice}</span>
									</button> --%>
									<button class="btn btn-success btn-sm "
										onclick="shoppingCart.add(${latestProduct.productId},$('#latestProductQty_${latestProduct.productId}').val());">
										<i></i>
										<c:if test="${latestProduct.discountPrice>0}">
											<span class="item_price" style="">$${latestProduct.discountPrice}<del
													style="color: black;">
													$${latestProduct.originalPrice}</del></span>
										</c:if>
										<c:if test="${latestProduct.discountPrice==0}">
											<span class="item_price">$${latestProduct.originalPrice}</span>
										</c:if>
									</button>
								</a>
							</p>
						</div>
					</div>
				</c:forEach>

				<div class="clearfix"></div>
			</div>
			<div class="products-grid">
				<header>
					<h3 class="section-title text-center">
						<bean:message key="upcomingProduct.title" />
					</h3>
				</header>
				<c:forEach items="${upcomingProductList}" var="upcomingProduct"
					varStatus="up">
					<div
						class="col-md-2 col-sm-4 col-xs-6 product simpleCart_shelfItem text-center">
						<a
							href="${pageContext.request.contextPath}/product.do?method=show&productId=${upcomingProduct.productId}">
							<img
							src="upload/product/${upcomingProductImagesList[up.count-1].imageName}"
							alt="" style="min-height: 200px; min-width: 170px;" />
						</a>
						<div class="mask">
							<a
								href="${pageContext.request.contextPath}/product.do?method=show&productId=${upcomingProduct.productId}">Quick
								View</a>
						</div>
						<div>
							<p>
								Rating: <span class="starRating"> <input id="rating5"
									type="radio" name="rating_${upcomingProduct.productId}"
									value="5"> <label for="rating5">5</label> <input
									id="rating4" type="radio"
									name="rating_${upcomingProduct.productId}" value="4"> <label
									for="rating4">4</label> <input id="rating3" type="radio"
									name="rating_${upcomingProduct.productId}" value="3" checked>
									<label for="rating3">3</label> <input id="rating2" type="radio"
									name="rating_${upcomingProduct.productId}" value="2"> <label
									for="rating2">2</label> <input id="rating1" type="radio"
									name="rating_${upcomingProduct.productId}" value="1"> <label
									for="rating1">1</label>
								</span>
							</p>
						</div>
						<div style="overflow: hidden; height: 70px;">
							<html:link
								page="/product.do?method=show&productId=${upcomingProduct.productId}"
								styleClass="product_name">${upcomingProduct.productName}</html:link>
							<%-- <input type="hidden"  name="upcomingProductId_${upcomingProduct.productId}"  id="upcomingProductId_${upcomingProduct.productId}" value="${upcomingProduct.productId}"/> --%>
						</div>
						<div style="overflow: hidden;">
							Quantity: <input type="number"
								name="upcomingProductQty_${upcomingProduct.productId}"
								id="upcomingProductQty_${upcomingProduct.productId}"
								style="width: 75px; height: 28px;" value="1" />
						</div>
						<div style="height: 30px; margin-top: 5px; overflow: hidden;">
							<p>
								<a class="" href="#"> <input type="hidden"
									name="upcomingProductPrice_${upcomingProduct.productId}"
									id="upcomingProductPrice_${upcomingProduct.productId}"
									value="${upcomingProduct.originalPrice}" />
									<button class="btn btn-success btn-sm"
										onclick="shoppingCart.add(${upcomingProduct.productId},$('#latestProductQty_${upcomingProduct.productId}').val());">
										<i></i>
										<c:if test="${upcomingProduct.discountPrice>0}">
											<span class="item_price" style="">$${upcomingProduct.discountPrice}<del
													style="color: black;">
													$${upcomingProduct.originalPrice}</del></span>
										</c:if>
										<c:if test="${upcomingProduct.discountPrice==0}">
											<span class="item_price">$${upcomingProduct.originalPrice}</span>
										</c:if>
									</button>
								</a>
							</p>
						</div>
					</div>
				</c:forEach>
				<div class="clearfix"></div>
			</div>

			<div class="products-grid">
				<header>
					<h3 class="section-title text-center">
						<bean:message key="topSaleProduct.title" />
					</h3>
				</header>
				<c:forEach items="${topSaleProductList}" var="topSaleProduct"
					varStatus="ts">
					<div
						class="col-md-2 col-sm-4 col-xs-6 product simpleCart_shelfItem text-center">
						<a
							href="${pageContext.request.contextPath}/product.do?method=show&productId=${topSaleProduct.productId}">
							<img
							src="upload/product/${topSaleProductImagesList[ts.count-1].imageName}"
							alt="" style="min-height: 200px; min-width: 170px;" />
						</a>
						<div class="mask">
							<a
								href="${pageContext.request.contextPath}/product.do?method=show&productId=${topSaleProduct.productId}">Quick
								View</a>
						</div>
						<div>
							<p>
								Rating: <span class="starRating"> <input id="rating5"
									type="radio" name="rating_${topSaleProduct.productId}"
									value="5"> <label for="rating5">5</label> <input
									id="rating4" type="radio"
									name="rating_${topSaleProduct.productId}" value="4"> <label
									for="rating4">4</label> <input id="rating3" type="radio"
									name="rating_${topSaleProduct.productId}" value="3" checked>
									<label for="rating3">3</label> <input id="rating2" type="radio"
									name="rating_${topSaleProduct.productId}" value="2"> <label
									for="rating2">2</label> <input id="rating1" type="radio"
									name="rating_${topSaleProduct.productId}" value="1"> <label
									for="rating1">1</label>
								</span>
							</p>
						</div>
						<div style="overflow: hidden; height: 70px;">
							<html:link
								page="/product.do?method=show&productId=${topSaleProduct.productId}"
								styleClass="product_name">${topSaleProduct.productName}</html:link>
							<%-- <input type="hidden"  name="topSaleProductId_${topSaleProduct.productId}"  id="topSaleProductId_${topSaleProduct.productId}" value="${topSaleProduct.productId}"/> --%>
						</div>
						<div style="overflow: hidden;">
							Quantity: <input type="number"
								name="topSaleProductQty_${topSaleProduct.productId}"
								id="topSaleProductQty_${topSaleProduct.productId}"
								style="width: 75px;height: 28px;" value="1" />
						</div>
						<div style="height: 30px; margin-top: 5px; overflow: hidden;">
							<p>
								<a class="" href="#"> <input type="hidden"
									name="topSaleProductPrice_${topSaleProduct.productId}"
									id="topSaleProductPrice_${topSaleProduct.productId}"
									value="${topSaleProduct.originalPrice}" />
									<button class="btn btn-success btn-sm"
										onclick="shoppingCart.add(${topSaleProduct.productId},$('#latestProductQty_${topSaleProduct.productId}').val());">
										<i></i>
										<c:if test="${topSaleProduct.discountPrice>0}">
											<span class="item_price" style="">$${topSaleProduct.discountPrice}<del
													style="color: black;">
													$${topSaleProduct.originalPrice}</del></span>
										</c:if>
										<c:if test="${topSaleProduct.discountPrice==0}">
											<span class="item_price">$${topSaleProduct.originalPrice}</span>
										</c:if>
									</button>
								</a>
							</p>
						</div>
					</div>
				</c:forEach>

				<div class="clearfix"></div>
			</div>
			<div class="products-grid">
				<header>
					<h3 class="section-title text-center">
						<bean:message key="topRatedProduct.title" />
					</h3>
				</header>
				<c:forEach items="${topRatedProductList}" var="topRatedProduct">
					<div
						class="col-md-2 col-sm-4 col-xs-6 product simpleCart_shelfItem text-center">
						<a
							href="${pageContext.request.contextPath}/product.do?method=show&productId=${topRatedProduct.productId}"><img
							src="resource/images/p2.jpg" alt="" /></a>
						<div class="mask">
							<a
								href="${pageContext.request.contextPath}/product.do?method=show&productId=${topRatedProduct.productId}">Quick
								View</a>
						</div>
						<div>
							<p>
								Rating: <span class="starRating"> <input id="rating5"
									type="radio" name="rating_${topRatedProduct.productId}"
									value="5"> <label for="rating5">5</label> <input
									id="rating4" type="radio"
									name="rating_${topRatedProduct.productId}" value="4"> <label
									for="rating4">4</label> <input id="rating3" type="radio"
									name="rating_${topRatedProduct.productId}" value="3" checked>
									<label for="rating3">3</label> <input id="rating2" type="radio"
									name="rating_${topRatedProduct.productId}" value="2"> <label
									for="rating2">2</label> <input id="rating1" type="radio"
									name="rating_${topRatedProduct.productId}" value="1"> <label
									for="rating1">1</label>
								</span>
							</p>
						</div>
						<div style="overflow: hidden; height: 70px;">
							<html:link
								page="/product.do?method=show&productId=${topRatedProduct.productId}"
								styleClass="product_name">${topRatedProduct.productName}</html:link>
							<%-- <input type="hidden"  name="topRatedProductId_${topRatedProduct.productId}"  id="topRatedProductId_${topRatedProduct.productId}" value="${topRatedProduct.productId}"/> --%>
						</div>
						<div style="overflow: hidden;">
							Quantity: <input type="number"
								name="topRatedProductQty_${topRatedProduct.productId}"
								id="topRatedProductQty_${topRatedProduct.productId}"
								style="width: 75px; height: 28px;" value="1" />
						</div>
						<div style="height: 30px; margin-top: 5px; overflow: hidden;">
							<p>
								<a class="" href="#"> <input type="hidden"
									name="topRatedProductPrice_${topRatedProduct.productId}"
									id="topRatedProductPrice_${topRatedProduct.productId}"
									value="${topRatedProduct.originalPrice}" />
									<button class="btn btn-success btn-sm"
										onclick="shoppingCart.add(${topRatedProduct.productId},$('#latestProductQty_${topRatedProduct.productId}').val());">
										<i></i>
										<c:if test="${topRatedProduct.discountPrice>0}">
											<span class="item_price" style="">$${topRatedProduct.discountPrice}<del
													style="color: black;">
													$${topRatedProduct.originalPrice}</del></span>
										</c:if>
										<c:if test="${topRatedProduct.discountPrice==0}">
											<span class="item_price">$${topRatedProduct.originalPrice}</span>
										</c:if>
									</button>
								</a>
							</p>
						</div>
					</div>
				</c:forEach>
				<div class="clearfix"></div>
			</div>
		</div>

	</div>

	<!-- content-section-ends-here -->
	<!--========================================Page JavaScript Section Starts===================================-->
	<script type="text/javascript">
			
		</script>
	<!--========================================Page JavaScript Section End===================================-->
	<!-- Footer section starts -->
	<c:import url="/resource/layout/layoutFooter.jsp"></c:import>
	<!-- Footer section end -->

</body>
</html>