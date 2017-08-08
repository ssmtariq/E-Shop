<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Online Deliver Section Starts -->			
	<div class="online-strip" style="margin: 0px 0px; padding: 10px 0;">
		<div class="col-md-4 col-sm-4 follow-us">
			<h3>
				<bean:message key="follow.header"/> : <a class="twitter" href="#"></a><a class="facebook" href="#"></a>
			</h3>
		</div>
		<div class="col-md-4 col-sm-4 shipping-grid">
			<div class="shipping">
				<img src="resource/images/shipping.png" alt="" />
			</div>
			<div class="shipping-text">
				<h3><bean:message key="order.online.header"/></h3>
				<p><bean:message key="order.over.header"/> $ 199</p>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="col-md-4 col-sm-4 online-order">
			<p><bean:message key="order.online.header"/></p>
			<h3><bean:message key="mobile.header"/>:+8801780714716</h3>
		</div>
		<div class="clearfix"></div>
	</div>
<!-- Online Deliver Section end -->

<div class="footer">
	<div class="container">
		<div class="footer_top">
			<div class="span_of_4">
				<div class="col-md-3 col-sm-3 col-xs-6 span1_of_4">
					<h4><bean:message key="topCategories.title"/></h4>
					<ul class="f_nav">
						<c:forEach items="${topCategoriesList}" var="topCategory">
							<li><a href="${pageContext.request.contextPath}/product.do?method=categoryWiseProducts&categoryId=${topCategory.categoryId}">${topCategory.categoryName}</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-6 span1_of_4">
					<h4><bean:message key="help.title"/></h4>
					<ul class="f_nav">
						<li><a href="#">frequently asked questions</a></li>
						<li><a href="#">men</a></li>
						<li><a href="#">women</a></li>
						<li><a href="#">accessories</a></li>
						<li><a href="#">kids</a></li>
						<li><a href="#">brands</a></li>
					</ul>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-6 span1_of_4">
					<h4><bean:message key="account.title"/></h4>
					<ul class="f_nav">
						<li><a href="account.html">login</a></li>
						<li><a href="register.html">create an account</a></li>
						<li><a href="#">create wishlist</a></li>
						<li><a href="checkout.html">my shopping bag</a></li>
						<li><a href="#">brands</a></li>
						<li><a href="#">create wishlist</a></li>
					</ul>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-6 span1_of_4">
					<h4><bean:message key="popular.title"/></h4>
					<ul class="f_nav">
						<c:forEach items="${topSaleProductList}" var="topSaleProduct">
							<li><a href="${pageContext.request.contextPath}/product.do?method=show&productId=${topSaleProduct.productId}">${topSaleProduct.productName}</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="cards text-center" style="margin: 0px 0px;">
			<img src="resource/images/pp.jpg" alt="" class="img-thumbnail" />
		</div>
		<div class="copyright text-center" style="margin-top: 30px">
			<p>
				© <bean:message key="copyRightYear.header"/>. <bean:message key="copyRight.header"/> <a href="http://tariqnotes.wordpress.com"> SSM TARIQ</a>
			</p>
		</div>
	</div>
</div>
<!--========================================Page JavaScript Section Starts===================================-->
<script type="text/javascript">
	var numberOfItems = "${numberOfItems}";
	var totalPrice = "${totalPrice}";
	var currentAction = "${currentAction}";
	var shoppingCart = {
			add:function(productId, productQuantity){
				console.log("Product Id:"+productId);
				console.log("Product Qty:"+productQuantity);
				
				$.ajax({                                            
			        url: 'shoppingCart.do?method=add',   
			        data: { 
			        	productId: productId, 
			        	productQuantity: productQuantity
					},
					dataType : 'json',
					async : false,
					success : function(data) {
						console.log(data["numberOfItems"]);
						$("#shoppingCartTotalItem").text("");
						$("#shoppingCartTotalAmount").text("");
						$("#shoppingCartTotalItem").text(data["numberOfItems"]);
						$("#shoppingCartTotalAmount").text(data["totalPrice"]);
						console.log("ajax call success");
					}
				});// end of ajax call;
			},
			
			remove:function(productId){
				/* var productId = "${shoppingCart.productId}"; */
				$('.cart-header'+productId).fadeOut('slow', function(c) {
					$('.cart-header'+productId).remove();
				});
			},
			
			empty:function(){
				$.ajax({                                            
			        url: 'shoppingCart.do?method=empty',   
			        data: {},
					dataType : 'json',
					async : false,
					success : function(data) {
						$("#shoppintCartTotalItem").text("");
						$("#shoppintCartTotalAmount").text("");
						console.log("ajax call success");
						location.reload();
					}
				});// end of ajax call;
			},
			
			viewCart: function(){
				$.ajax({                                            
			        url: 'shoppingCart.do?method=myCartProductsList',   
			        data: {},
					dataType : 'json',
					async : false,
					success : function(data) {
							$('#myModal').modal();
							if(data==null || data=="" || data.length==0){
								$('#modalContent').html("<h4>Your Cart Is Empty!</h4>");
								return false;
							}
							$("#shoppintCartTotalItem").text("");
							$("#shoppintCartTotalAmount").text("");
							productList = data;
							console.log(data[0]["originalPrice"]);
							console.log(data[0]["discountPrice"]);
							/* Inner Ajax call for getting product images Start*/
							$.ajax({
									url : 'shoppingCart.do?method=myCartProductsListImages',
									data : {},
									dataType : 'json',
									async : false,
									success : function(data) {
										productImagesList = data;
										/*======================Data population after two synchronous ajax call start */
											var htmlString = "";
											for (var i = 0; i < productList.length; i++) {
												var imageName = "";
												for (var j = 0; j < productImagesList.length; j++) {
													if (productList[i]["productId"] == productImagesList[j]["product"]["productId"]) {
														imageName = productImagesList[j]["imageName"];
														break;
													}
												}
												htmlString += '<div class="products-grid" style="padding:0px;">';
												htmlString += createShoppingListHtml(productList[i], imageName);
												htmlString += '</div>';
											}
											$('#modalContent').html(htmlString);
										/*======================Data population after two synchronous ajax call end */
									}
									});// end of ajax call;
							/* Inner Ajax call for getting product images End*/
							console.log("ProductList ajax call success");
						}
					});// end of ajax call;
		}
	};

	function searchProducts() {
		if ($('#searchCriteria').val() == "") {
			return false;
		} else {
			var searchCriteria = $('#searchCriteria').val();
			location.href = "/eCommerceBjitFinalProject/product.do?method=search&searchCriteria="
					+ searchCriteria;
		}
	}

	$(document).ready(function() {
		$('#searchCriteria').keypress(function(e) {
			var key = e.which;
			if (key == 13) // the enter key code
			{
				$("#btnSearch").click();
				return false;
			}
		});
	});
	
	function createShoppingListHtml(product, imageName){
		var string = '<div class="cart-header col-md-12 col-sm-12 col-xs-12 product simpleCart_shelfItem text-center" style="border: 2px dashed; border-color:gray;  padding: 10px; margin-top: 10px;">'
					+'<a class="col-md-3" href="${pageContext.request.contextPath}/product.do?method=show&productId='+product["productId"]+'"><img src="upload/product/'+imageName+'" alt="" style="min-height: 50px;"/></a>'
					+'<div style="overflow: hidden; height: 70px;" class="col-md-3">'
					+'<html:link page="/productDetails.do" styleClass="product_name"><b>'+product["productName"]+'</b><br><h4><b style="color: green;">'+product["discountPrice"]+'</b>&nbsp;<del><b style="color: red;">'+product["originalPrice"]+'</b></del></h4></html:link>'
					+'</div>'
					+'<div style="overflow: hidden;" class="col-md-3">'
					+'<b>Quantity</b><br>' 
					+'<input type="number" onchange="modalCartObject.update();" name="modalCartQty'+product["productId"]+'" id="modalCartQty'+product["productId"]+'" style="width: 75px; height: 28px; margin-top: 10px;" value="'+product["quantity"]+'" />'
					+'</div>'
					+'<div style="height: 30px; margin-top: 5px; overflow: ;" class="col-md-3">'
					+'<p>'
					+'<a class="" href="#"> <input type="hidden" name="modatCartProductPrice_'+product["productId"]+'" id="modatCartProductPrice_'+product["productId"]+'" value="'+product["originalPrice"]+'" />'
					string += '<div class="close'+product["productId"]+' closeButton" onclick="modalCartObject.remove('+product["productId"]+')"></div>'
			string += '</a>'
					+'</p>'
					+'</div>'
					+'</div>'
		return string;
	}
</script>
<!--==========================Modal Cart Data Scripts Start==================================-->
<script type="text/javascript">
	var modalCartRemoveProductList = [];
	var modalCartUpdatedProductList = [];
	
	var modalCartObject = {
			remove:function(productId){
				modalCartRemoveProductList.push(productId);
				$('.cart-header'+productId).fadeOut('slow', function(c) {
					$('.cart-header'+productId).remove();
				});
				for(var i=0; i<modalCartRemoveProductList.length; i++){
					console.log("modalCartRemoveProductList "+i+"="+modalCartRemoveProductList[i]);
				}
				modalCartObject.update();
			},
			
			update:function(){
				$.ajax({                                            
			        url: 'shoppingCart.do?method=getItemList',   
			        data: {},
					dataType : 'json',
					async : false,
					success : function(data) {
						modalCartUpdatedProductList = data;
						console.log("modalCartUpdatedProductList size = "+modalCartUpdatedProductList.length);
						console.log("ajax call getItemList success");
					}
				});
				for(var i=0; i<modalCartUpdatedProductList.length; i++){
					var quantity = $("#modalCartQty"+modalCartUpdatedProductList[i]["productId"]).val();
					console.log("New Quantity = "+quantity);
					modalCartUpdatedProductList[i]["quantity"] = quantity;
					console.log("modalCartUpdatedProductList="+modalCartUpdatedProductList[i]["productId"]);
					console.log("modalCartUpdatedProductList="+modalCartUpdatedProductList[i]["quantity"]);
				}
				$.ajax({                                            
			        url: 'shoppingCart.do?method=update',   
			        data: {
			        	removeProductList: JSON.stringify(modalCartRemoveProductList),
			        	updatedProductList: JSON.stringify(modalCartUpdatedProductList)
			        },
					dataType : 'json',
					async : false,
					success : function(data) {
						$("#shoppintCartTotalItem").text("");
						$("#shoppintCartTotalAmount").text("");
						console.log("Cart Updated successfully");
						shoppingCart.viewCart();
					}
				}); // end of ajax call;
			}
		};
</script>
<!--==========================Modal Cart Data Scripts End==================================-->
<!--========================================Page JavaScript Section End===================================-->
