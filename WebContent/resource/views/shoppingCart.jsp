<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<c:import url="/resource/layout/layoutHeader.jsp">
		<c:param name="pageTitle" value="shoppingCart.header"></c:param>
	</c:import>
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
</head>
<body>
	<!-- header-section-starts -->
		<c:import url="/resource/layout/layoutNavigator.jsp"></c:import>
	<!-- header-section-ends -->
	
	<!-- Banner top starts -->
		<c:import url="/resource/layout/layoutBanner.jsp"></c:import>
	<!-- Banner top end -->

	<!-- checkout -->
		<div class="cart-items">
			<div class="container">
				<div class="dreamcrub">
					<ul class="breadcrumbs">
						<li class="home"><a href="${pageContext.request.contextPath}/home.do" title="Go to Home Page">Home</a>&nbsp;
							<span>&gt;</span></li>
						<li class="women">Cart</li>
					</ul>
					<ul class="previous">
						<li><a href="${pageContext.request.contextPath}/home.do">Back to Home Page</a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<h2>MY SHOPPING BAG (${numberOfItems})</h2>
				<div class="cart-gd">
					<c:forEach items="${shoppingList}" var="shoppingCart">
						<script>
							var productId = "${shoppingCart.productId}";
							$(document).ready(function(c) {
								/* $(".close"+productId).on('click', function(c) {
									alert("clicked");
									$('.cart-header'+productId).fadeOut('slow', function(c) {
										$('.cart-header'+productId).remove();
									});
								}); */
							});
						</script>
						<div class="cart-header${shoppingCart.productId} shoppingCartHeader">
							<div class="close${shoppingCart.productId} closeButton" onclick="cartObject.remove(${shoppingCart.productId})"></div>
							<div class="cart-sec simpleCart_shelfItem">
								<div class="cart-item cyc">
									<img src="upload/product/${shoppingCart.imageName}" class="img-responsive" alt="">
								</div>
								<div class="cart-item-info">
									<h3>
										<a href="#"> ${shoppingCart.productName} </a><span>Category: ${shoppingCart.productName}</span>
									</h3>
									<ul class="qty">
										<li><p>Quantity:
										<input type="number" name="checkoutQuantity${shoppingCart.productId}" id="checkoutQuantity${shoppingCart.productId}" style="width: 75px; height: 28px;" value="${shoppingCart.quantity}"/>
										</p></li>
										<li><p>Unit Price:
										${shoppingCart.unitPrice}
										</p></li>
										<li><p>Discount:
										$0</p></li>
									</ul>
									<div class="delivery">
										<p>Item Total : ${shoppingCart.unitPrice*shoppingCart.quantity}</p>
										<span>Delivered in 1-1:30 hours</span>
										<div class="clearfix"></div>
									</div>
								</div>
								<div class="clearfix"></div>
		
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-md-2">
						<html:link page="/home.do">
						<button class="btn btn-success btn-md btn-block pull-left"><i class="fa fa-share-square-o fa-lg"></i> Continue
						</button>
						</html:link>
					</div>
					<div class="col-md-3">
						 <div class="input-group">
					      <span class="input-group-addon">Total Quantity: </span>
					      <input type="text" class="form-control" id="inputGroupSuccess3" aria-describedby="inputGroupSuccess3Status" value="${numberOfItems}" style="text-align: right; font-weight: bold;font-size: 22px;">
					    </div>
						 <!-- <input type="text" class="form-control input-md" name="totalCosts" id="totalCosts" readonly="readonly"> -->
					</div>
					<div class="col-md-3">
						 <div class="input-group">
					      <span class="input-group-addon">Total Costs: $</span>
					      <input type="text" class="form-control" id="inputGroupSuccess3" aria-describedby="inputGroupSuccess3Status" value="${totalPrice}" style="text-align: right; font-weight: bold;font-size: 22px;">
					    </div>
						 <!-- <input type="text" class="form-control input-md" name="totalCosts" id="totalCosts" readonly="readonly"> -->
					</div>
					<div class="col-md-2">
						 <button id="btnUpdate" class="btn btn-success btn-md btn-block pull-right" onclick="cartObject.update()"><i class="fa fa-refresh fa-lg"></i>
						 &nbsp;&nbsp;&nbsp;Update</button>
					</div>
					<div class="col-md-2">
						<html:link page="/order.do?method=create">
							<button class="btn btn-danger btn-md btn-block pull-right" id="btnCheckout">
								<i class="fa fa-shopping-cart fa-lg"></i>
								&nbsp;&nbsp;&nbsp;Checkout
							</button>
						</html:link>
					</div>
				</div>
			</div>
		</div>

	<!-- //checkout -->	
		
	<!-- Footer section starts -->
		<c:import url="/resource/layout/layoutFooter.jsp"></c:import>
	<!-- Footer section end -->
	
	<!-- Page Scripts Start -->
		<script type="text/javascript">
			var numberOfItems = "${numberOfItems}";
			$(document).ready(function(){
				if(numberOfItems==null || numberOfItems==""|| numberOfItems==0){
					$("#btnUpdate").attr('disabled','true');
					$("#btnCheckout").attr('disabled','true');
				}
			});
			var removeProductList = [];
			var updatedProductList = [];
			
			var cartObject = {
					remove:function(productId){
						removeProductList.push(productId);
						$('.cart-header'+productId).fadeOut('slow', function(c) {
							$('.cart-header'+productId).remove();
						});
						for(var i=0; i<removeProductList.length; i++){
							console.log(removeProductList[i]);
						}
					},
					
					update:function(){
						$.ajax({                                            
					        url: 'shoppingCart.do?method=getItemList',   
					        data: {},
							dataType : 'json',
							async : false,
							success : function(data) {
								updatedProductList = data;
								console.log("ajax call getItemList success");
							}
						});
						for(var i=0; i<updatedProductList.length; i++){
							var quantity = $("#checkoutQuantity"+updatedProductList[i]["productId"]).val();
							updatedProductList[i]["quantity"] = quantity;
							console.log(updatedProductList[i]["productId"]);
							console.log(updatedProductList[i]["quantity"]);
						}
						$.ajax({                                            
					        url: 'shoppingCart.do?method=update',   
					        data: {
					        	removeProductList: JSON.stringify(removeProductList),
					        	updatedProductList: JSON.stringify(updatedProductList)
					        },
							dataType : 'json',
							async : false,
							success : function(data) {
								$("#shoppintCartTotalItem").text("");
								$("#shoppintCartTotalAmount").text("");
								console.log("Cart Updated successfully");
								location.reload();
							}
						}); // end of ajax call;
					}
				};
		</script>
	<!-- Page Scripts End -->
</body>
</html>