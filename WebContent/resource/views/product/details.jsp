<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:import url="/resource/layout/layoutHeader.jsp">
	<c:param name="pageTitle" value="productDetails.header"></c:param>
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
	<div class="container">
		<div class="products-page">
			<!-- Sidebar Starts -->
			<div class="products">
				<c:import url="/resource/layout/layoutSidebar.jsp"></c:import>
			</div>
			<!-- Sidebar End -->
			<div class="new-product" style="padding-top: 0px;">
				<div class="col-md-5 zoom-grid">
					<div class="flexslider">
						<ul class="slides">
							<li data-thumb="upload/product/${productImages.imageName}">
								<div class="thumb-image">
									<img src="upload/product/${productImages.imageName}" data-imagezoom="true"
										class="img-responsive" alt="" />
								</div>
							</li>
							<li data-thumb="upload/product/${productImages.imageName}">
								<div class="thumb-image">
									<img src="upload/product/${productImages.imageName}" data-imagezoom="true"
										class="img-responsive" alt="" />
								</div>
							</li>
							<!-- <li data-thumb="resource/images/si2.jpg">
								<div class="thumb-image">
									<img src="resource/images/si2.jpg" data-imagezoom="true"
										class="img-responsive" alt="" />
								</div>
							</li> -->
						</ul>
					</div>
				</div>
				<div class="col-md-7 dress-info">
					<div class="dress-name">
						<h3><span class="text-uppercase">${products.productName}</span></h3>
						<a href="#" class="item_price">
						<c:if test="${products.discountPrice>0}"><span style="color: green;">$${products.discountPrice}<del style="color: red;"> $${products.originalPrice}</del></span></c:if>
						<c:if test="${products.discountPrice==0}"><span>$${products.originalPrice}</span></c:if>
						</a>
						<div class="clearfix"></div>
						<p>${products.description}</p>
					</div>
					<div class="span span1">
						<p class="left"><span class=" text-uppercase">Category</span></p>
						<p class="right">${products.category.categoryName}</p>
						<div class="clearfix"></div>
					</div>
					<div class="span span2">
						<p class="left"><span class=" text-uppercase">Availability</span></p>
						<p class="right">
							<c:if test="${products.availability==1}">Available</c:if>
							<c:if test="${products.availability==2}">Coming Soon</c:if>
							<c:if test="${products.availability==3}">Not for Sale</c:if>
						</p>
						<div class="clearfix"></div>
					</div>
					<div class="span span3">
						<p class="left">COLOR</p>
						<p class="right">White</p>
						<div class="clearfix"></div>
					</div>
					<div class="span span4">
						<p class="left">SIZE</p>
						<p class="right">
							<span class="selection-box"><select class="domains valid"
								name="domains">
									<option>M</option>
									<option>L</option>
									<option>XL</option>
									<option>FS</option>
									<option>S</option>
							</select></span>
						</p>
						<div class="clearfix"></div>
					</div>
					<div class="purchase simpleCart_shelfItem">
						<a href="#" class=""> <input id="detailsProductQty_${products.productId}" type="number" class="item_add"
							value="1" />
							<button class="btn" onclick="shoppingCart.add(${products.productId},$('#detailsProductQty_${products.productId}').val());"
								style="background: #000000; color: white; text-transform: uppercase; font-size: 15px;">
								Purchase Now</button>
						</a>
						<div class="social-icons">
							<ul>
								<li><a class="facebook1" href="#"></a></li>
								<li><a class="twitter1" href="#"></a></li>
								<li><a class="googleplus1" href="#"></a></li>
							</ul>
						</div>
						<div class="clearfix"></div>
					</div>
					<script
						src="${pageContext.request.contextPath}/resource/js/imagezoom.js"></script>
					<!-- FlexSlider -->
					<script defer
						src="${pageContext.request.contextPath}/resource/js/jquery.flexslider.js"></script>
					<script>
						// Can also be used with $(document).ready()
						$(window).load(function() {
						  $('.flexslider').flexslider({
							animation: "slide",
							controlNav: "thumbnails"
						  });
						});
					</script>
				</div>
				<div class="clearfix"></div>
				<div class="reviews-tabs">
					<!-- Main component for a primary marketing message or call to action -->
					<ul class="nav nav-tabs responsive hidden-xs hidden-sm" id="myTab">
						<li class="test-class active"><a class="deco-none misc-class"
							href="#how-to"> More Information</a></li>
						<li class="test-class"><a href="#features">Specifications</a></li>
						<li class="test-class"><a class="deco-none" href="#source">Reviews
								(7)</a></li>
					</ul>

					<div class="tab-content responsive hidden-xs hidden-sm">
						<div class="tab-pane active" id="how-to">
							<p class="tab-text">Maecenas mauris velit, consequat sit amet
								feugiat rit, elit vitaeert scelerisque elementum, turpis nisl
								accumsan ipsum Lorem Ipsum is simply dummy text of the printing
								and typesetting industry. and scrambled it to make a type
								specimen book. It has survived Auction your website on Flippa
								and you'll get the best price from serious buyers, dedicated
								support and a much better deal than you'll find with any website
								broker. Sell your site today I need a twitter bootstrap 3.0
								theme for the full-calendar plugin. it would be great if the
								theme includes the add event; remove event, show event details.
								this must be RESPONSIVE and works on mobile devices. Also, I've
								seen so many bootstrap themes that comes up with the
								fullcalendar plugin. However these .</p>
						</div>
						<div class="tab-pane" id="features">
							<p class="tab-text">Lorem ipsum dolor sit amet, consectetur
								adipiscing elit. Vestibulum nibh urna, euismod ut ornare non,
								volutpat vel tortor. Integer laoreet placerat suscipit. Sed
								sodales scelerisque commodo. Nam porta cursus lectus. Proin nunc
								erat, gravida a facilisis quis, ornare id lectus. Proin
								consectetur nibh quis urna gravida mollis.This tab has icon in
								consectetur adipiscing eliconse consectetur adipiscing elit.
								Vestibulum nibh urna, ctetur adipiscing elit. Vestibulum nibh
								urna, t.consectetur adipiscing elit. Vestibulum nibh urna,
								Vestibulum nibh urna,it.</p>
							<p class="tab-text">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit,There are many variations of passages of Lorem
								Ipsum available, sed do eiusmod tempor incididunt ut labore et
								dolore magna aliqua.</p>
						</div>
						<div class="tab-pane" id="source">
							<div class="response">
								<div class="media response-info">
									<div class="media-left response-text-left">
										<a href="#"> <img class="media-object"
											src="resource/images/icon1.png" alt="" />
										</a>
										<h5>
											<a href="#">Username</a>
										</h5>
									</div>
									<div class="media-body response-text-right">
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit,There are many variations of passages of Lorem Ipsum
											available, sed do eiusmod tempor incididunt ut labore et
											dolore magna aliqua.</p>
										<ul>
											<li>MARCH 21, 2015</li>
											<li><a href="single.html">Reply</a></li>
										</ul>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="media response-info">
									<div class="media-left response-text-left">
										<a href="#"> <img class="media-object"
											src="resource/images/icon1.png" alt="" />
										</a>
										<h5>
											<a href="#">Username</a>
										</h5>
									</div>
									<div class="media-body response-text-right">
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit,There are many variations of passages of Lorem Ipsum
											available, sed do eiusmod tempor incididunt ut labore et
											dolore magna aliqua.</p>
										<ul>
											<li>MARCH 26, 2054</li>
											<li><a href="single.html">Reply</a></li>
										</ul>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="media response-info">
									<div class="media-left response-text-left">
										<a href="#"> <img class="media-object"
											src="resource/images/icon1.png" alt="" />
										</a>
										<h5>
											<a href="#">Username</a>
										</h5>
									</div>
									<div class="media-body response-text-right">
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit,There are many variations of passages of Lorem Ipsum
											available, sed do eiusmod tempor incididunt ut labore et
											dolore magna aliqua.</p>
										<ul>
											<li>MAY 25, 2015</li>
											<li><a href="single.html">Reply</a></li>
										</ul>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="media response-info">
									<div class="media-left response-text-left">
										<a href="#"> <img class="media-object"
											src="resource/images/icon1.png" alt="" />
										</a>
										<h5>
											<a href="#">Username</a>
										</h5>
									</div>
									<div class="media-body response-text-right">
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit,There are many variations of passages of Lorem Ipsum
											available, sed do eiusmod tempor incididunt ut labore et
											dolore magna aliqua.</p>
										<ul>
											<li>FEB 13, 2015</li>
											<li><a href="single.html">Reply</a></li>
										</ul>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="media response-info">
									<div class="media-left response-text-left">
										<a href="#"> <img class="media-object"
											src="resource/images/icon1.png" alt="" />
										</a>
										<h5>
											<a href="#">Username</a>
										</h5>
									</div>
									<div class="media-body response-text-right">
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit,There are many variations of passages of Lorem Ipsum
											available, sed do eiusmod tempor incididunt ut labore et
											dolore magna aliqua.</p>
										<ul>
											<li>JAN 28, 2015</li>
											<li><a href="single.html">Reply</a></li>
										</ul>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="media response-info">
									<div class="media-left response-text-left">
										<a href="#"> <img class="media-object"
											src="resource/images/icon1.png" alt="" />
										</a>
										<h5>
											<a href="#">Username</a>
										</h5>
									</div>
									<div class="media-body response-text-right">
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit,There are many variations of passages of Lorem Ipsum
											available, sed do eiusmod tempor incididunt ut labore et
											dolore magna aliqua.</p>
										<ul>
											<li>APR 18, 2015</li>
											<li><a href="single.html">Reply</a></li>
										</ul>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="media response-info">
									<div class="media-left response-text-left">
										<a href="#"> <img class="media-object"
											src="resource/images/icon1.png" alt="" />
										</a>
										<h5>
											<a href="#">Username</a>
										</h5>
									</div>
									<div class="media-body response-text-right">
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit,There are many variations of passages of Lorem Ipsum
											available, sed do eiusmod tempor incididunt ut labore et
											dolore magna aliqua.</p>
										<ul>
											<li>DEC 25, 2014</li>
											<li><a href="single.html">Reply</a></li>
										</ul>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="other-products products-grid">
		<div class="container">
			<header>
				<h3 class="like text-center">Latest Products</h3>
			</header>
			<c:forEach items="${latestProductList}" var="latestProduct">
				<div
					class="col-md-2 col-sm-4 col-xs-6 product simpleCart_shelfItem text-center">
					<a
						href="${pageContext.request.contextPath}/product.do?method=show&productId=${latestProduct.productId}"><img
						src="resource/images/p1.jpg" alt="" /></a>
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
								value="${latestProduct.originalPrice}" />
								<button class="btn btn-success btn-sm"
									onclick="shoppingCart.add(${latestProduct.productId},$('#latestProductQty_${latestProduct.productId}').val());">
									<i></i> 
									<c:if test="${latestProduct.discountPrice>0}"><span class="item_price" style="">$${latestProduct.discountPrice}<del style="color: black;"> $${latestProduct.originalPrice}</del></span></c:if>
									<c:if test="${latestProduct.discountPrice==0}"><span class="item_price">$${latestProduct.originalPrice}</span></c:if>
								</button>
							</a>
						</p>
					</div>
				</div>
			</c:forEach>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- content-section-ends -->

	<!-- Footer section starts -->
	<c:import url="/resource/layout/layoutFooter.jsp"></c:import>
	<!-- Footer section end -->

	<script
		src="${pageContext.request.contextPath}/resource/js/responsive-tabs.js"></script>
	<script type="text/javascript">
      $( '#myTab a' ).click( function ( e ) {
        e.preventDefault();
        $( this ).tab( 'show' );
      } );

      $( '#moreTabs a' ).click( function ( e ) {
        e.preventDefault();
        $( this ).tab( 'show' );
      } );

      ( function( $ ) {
          // Test for making sure event are maintained
          $( '.js-alert-test' ).click( function () {
            alert( 'Button Clicked: Event was maintained' );
          } );
          fakewaffle.responsiveTabs( [ 'xs', 'sm' ] );
      } )( jQuery );

    </script>

</body>
</html>