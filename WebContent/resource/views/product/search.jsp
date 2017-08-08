<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<c:import url="/resource/layout/layoutHeader.jsp">
		<c:param name="pageTitle" value="search.header"></c:param>
	</c:import>
	<script type="text/javascript">
		var productList = [];
		var searchCriteria = "${searchCriteria}";
		$(document).ready(function(){
			var url = 'product.do?method=getSearchResults&searchCriteria='+searchCriteria;
			var imageUrl = 'product.do?method=getSearchResultsImages&searchCriteria='+searchCriteria;
			$.ajax({                                            
		        url: url,   
		        data: {},
				dataType : 'json',
				async : false,
				success : function(data) {
					/* console.log(data[0]["productName"]); */
					productList = data;
			/* Inner Ajax call for getting product images Start*/
					$.ajax({                                            
				        url: imageUrl,   
				        data: {},
						dataType : 'json',
						async : false,
						success : function(data) {
							productImagesList = data;
							console.log(productImagesList);
	/*======================Data population after two synchronous ajax call start */		
							var htmlString = "";
							var closerCounter=0;
							for(var i=0; i<productList.length; i++) {
								var imageName = "";
								for(var j=0; j<productImagesList.length; j++){
									if(productList[i]["productId"]==productImagesList[j]["product"]["productId"]){
										imageName = productImagesList[j]["imageName"];
										console.log(imageName);
										break;
									}
								}
								if(i==0){
									console.log("O is called!");
									console.log("index:"+i+" closerCounter:"+closerCounter);
		
									htmlString += '<div class="products-grid" style="padding:0px;">';
									closerCounter++;
								}
								htmlString += createProductListHtml(productList[i], imageName);
								if(i!=0 && i%5==0){
									if(closerCounter%2!=0){
										console.log("5 odd is called!");
										console.log("index:"+i+" closerCounter:"+closerCounter);
										htmlString += '</div>';
										closerCounter++;
									}if(closerCounter%2==0){
										console.log(closerCounter%2);
										console.log("5 even is called!");
										console.log("index:"+i+" closerCounter:"+closerCounter);
										htmlString += '<div class="products-grid" style="padding:0px;">';
										closerCounter++;
									}
								}
								if(i==(productList.length-1) && closerCounter%2!=0){
									console.log("Lenth is called!");
									console.log("index:"+i+" closerCounter:"+closerCounter);
									htmlString += '</div>';
									break;
									closerCounter++;
								}
							}
							$('#content').append(htmlString);
							console.log(closerCounter);
	/*======================Data population after two synchronous ajax call end */							
						}
					});// end of ajax call;
			/* Inner Ajax call for getting product images End*/
					console.log("ProductList ajax call success");
				}
			});// end of ajax call;
			//how much items per page to show
			var show_per_page = $("#numberOfProductPerPage").val(); 
			//getting the amount of elements inside content div
			var number_of_items = $('#content').children().size();
			//calculate the number of pages we are going to have
			var number_of_pages = Math.ceil(number_of_items/show_per_page);
			
			//set the value of our hidden input fields
			$('#current_page').val(0);
			$('#show_per_page').val(show_per_page);
			
			//now when we got all we need for the navigation let's make it '
			
			/* 
			what are we going to have in the navigation?
				- link to previous page
				- links to specific pages
				- link to next page
			*/
			var navigation_html = '<br><a class="previous_link" href="javascript:previous();">Prev</a>';
			var current_link = 0;
			while(number_of_pages > current_link){
				navigation_html += '<a class="page_link" href="javascript:go_to_page(' + current_link +')" longdesc="' + current_link +'">'+ (current_link + 1) +'</a>';
				current_link++;
			}
			navigation_html += '<a class="next_link" href="javascript:next();">Next</a>';
			
			$('#page_navigation').html(navigation_html);
			
			//add active_page class to the first page link
			$('#page_navigation .page_link:first').addClass('active_page');
			
			//hide all the elements inside content div
			$('#content').children().css('display', 'none');
			
			//and show the first n (show_per_page) elements
			$('#content').children().slice(0, show_per_page).css('display', 'block');
			
		});
		
		function previous(){
			
			new_page = parseInt($('#current_page').val()) - 1;
			//if there is an item before the current active link run the function
			if($('.active_page').prev('.page_link').length==true){
				go_to_page(new_page);
			}
			
		}
		
		function next(){
			new_page = parseInt($('#current_page').val()) + 1;
			//if there is an item after the current active link run the function
			if($('.active_page').next('.page_link').length==true){
				go_to_page(new_page);
			}
			
		}
		function go_to_page(page_num){
			//get the number of items shown per page
			var show_per_page = parseInt($('#show_per_page').val());
			
			//get the element number where to start the slice from
			start_from = page_num * show_per_page;
			
			//get the element number where to end the slice
			end_on = start_from + show_per_page;
			
			//hide all children elements of content div, get specific items and show them
			$('#content').children().css('display', 'none').slice(start_from, end_on).css('display', 'block');
			
			/*get the page link that has longdesc attribute of the current page and add active_page class to it
			and remove that class from previously active page link*/
			$('.page_link[longdesc=' + page_num +']').addClass('active_page').siblings('.active_page').removeClass('active_page');
			
			//update the current page input field
			$('#current_page').val(page_num);
		}
	  
		function createProductListHtml(product, imageName){
			/* var string = '<p><div class="row"><div class="col-md-12">'+product["productName"]+'</div></div></p>'; */
			var string = '<div class="col-md-2 col-sm-4 col-xs-6 product simpleCart_shelfItem text-center" style="border: 5px solid; border-color:gray;  padding: 10px; margin-top: 10px;">'
						+'<a href="${pageContext.request.contextPath}/product.do?method=show&productId='+product["productId"]+'"><img src="upload/product/'+imageName+'" alt="" style="min-height: 120px;"/></a>'
						+'<div class="mask">'
						+'<a href="${pageContext.request.contextPath}/product.do?method=show&productId='+product["productId"]+'">Quick View</a>'
						+'</div>'
						+'<div>'
						+'Rating'
						+'</div>'
						+'<div style="overflow: hidden; height: 70px;">'
						+'<html:link page="/productDetails.do" styleClass="product_name">'+product["productName"]+'</html:link>'
					<%-- <input type="hidden"  name="latestProductId_${latestProduct.productId}"  id="latestProductId_${latestProduct.productId}" value="${latestProduct.productId}"/> --%>
						+'</div>'
						+'<div style="overflow: hidden;">'
						+'Quantity:' 
						+'<input type="number" name="latestProductQty_'+product["productId"]+'" id="latestProductQty_'+product["productId"]+'" style="width: 75px; height: 28px;" value="1" />'
						+'</div>'
						+'<div style="height: 30px; margin-top: 5px; overflow: hidden;">'
						+'<p>'
						+'<a class="" href="#"> <input type="hidden" name="latestProductPrice_'+product["productId"]+'" id="latestProductPrice_'+product["productId"]+'" value="'+product["originalPrice"]+'" />'
			 if(product["discountPrice"]>0){
				string +='<button class="btn btn-success btn-sm" onclick="shoppingCart.add('+product["productId"]+',$(\'#latestProductQty_'+product["productId"]+'\').val());"> <i></i> <span class="item_price">'+product["discountPrice"]+'<del style="color: black;"> $'+product["originalPrice"]+'</del></span> </button>'
			}else{
				string +='<button class="btn btn-success btn-sm" onclick="shoppingCart.add('+product["productId"]+',$(\'#latestProductQty_'+product["productId"]+'\').val());"> <i></i> <span class="item_price">'+product["originalPrice"]+'</span> </button>'
			} 
						/* string +='<button class="btn btn-success btn-sm" onclick="shoppingCart.add('+product["productId"]+',$(\'#latestProductQty_'+product["productId"]+'\').val());"> <i></i> <span class="item_price">'+product["originalPrice"]+'</span> </button>' */
				string += '</a>'
						+'</p>'
						+'</div>'
						+'</div>'
			return string;
		}
	</script>
	<style>
	#page_navigation a{
		padding:3px;
		border:1px solid gray;
		margin:2px;
		color:black;
		text-decoration:none
	}
	.active_page{
		background:black;
		color:white !important;
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
				<h3 class="text-center section-title">
					Search Results
				</h3>
				<!-- the input fields that will hold the variables we will use -->
				<div style="background: #F5F5F5; padding: 0 0;" class="col-md-12">
					<form action="#">
						<div class="form-group col-md-4" style="padding: 0 0;">
							<label for="orderBy"
								class="col-sm-4 control-label form-title-text">Order By</label>
							<div class="col-sm-8">
								<select class="form-control" id="sel1"
									style="margin: 3px; display: inline;">
									<option
										value="http://www.meenabazar.com.bd/Dairy/BUTTER?sort=p.sort_order&amp;order=ASC"
										selected="selected">Default</option>
									<option value="BUTTER3631.html?sort=pd.name&amp;order=ASC">Name
										(A - Z)</option>
									<option value="BUTTERf933.html?sort=pd.name&amp;order=DESC">Name
										(Z - A)</option>
									<option value="BUTTERb721.html?sort=p.price&amp;order=ASC">Price
										(Low &gt; High)</option>
									<option value="BUTTER44ca.html?sort=p.price&amp;order=DESC">Price
										(High &gt; Low)</option>
								</select>
							</div>
						</div>
						<div class="form-group col-md-offset-4 col-md-4" style="padding: 0 0;">
							<label for="numberOfProductPerPage"
								class="col-sm-4 control-label form-title-text">Show</label>
							<div class="col-sm-8">
								<select class="form-control" id="numberOfProductPerPage"
									style="margin: 3px; display: inline;">
									<option value="1">5</option>
									<option value="4">20</option>
									<option value="8">40</option>
									<option value="12">60</option>
									<option value="20">100</option>
								</select>
							</div>
						</div>
					</form>
				</div>

				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<input type='hidden' id='current_page' />
						<input type='hidden' id='show_per_page' />
					
						<div id='content'></div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div id='page_navigation' align="center"
							style="padding: 15px;"></div>
					</div>
				</div>
			</div>
			<!-- Featured Products end -->

		</div>
	</div>
	<br>
	<!-- Sidebar and Featured Products Section End -->

	<!-- Footer section starts -->
	<c:import url="/resource/layout/layoutFooter.jsp"></c:import>
	<!-- Footer section end -->
	
	<!-- Page Script -->
		<script type="text/javascript">
			$(document).ready(function(){
				show_per_page = $("#numberOfProductPerPage").val();
				$("#numberOfProductPerPage").change(function(){
					show_per_page = $("#numberOfProductPerPage").val();
					location.reload();
				});
			});
		</script>
	<!-- Page Script End -->
</body>
</html>
