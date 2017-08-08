<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header">
	<div class="header-top-strip">
		<div class="container">
			<div class="row">
				<div class="header-top-left col-md-4 col-sm-8 col-xs-12" style="margin-top: 15px; margin-bottom: 5px;">
					<ul>
						<c:if test="${signInStatus!=true}">
							<li><html:link page="/user.do?method=signIn"><i class="fa fa-sign-in fa-lg"></i> <bean:message key="login.title"/></html:link></li>
						</c:if>
						<c:if test="${signInStatus==true && currentUser!=null}">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"><b class="text-uppercase">${currentUser.firstName}&nbsp;${currentUser.lastName}</b><b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li>
										<a href="${pageContext.request.contextPath}/user.do?method=signOut" style="color: black;">Log Out</a>
									</li>
									<li>
										<a href="${pageContext.request.contextPath}/order.do?method=list" style="color: black;">Order Informations</a>
									</li>
									<li>
										<a href="${pageContext.request.contextPath}/payment.do?method=list" style="color: black;">Payment Informations</a>
									</li>
								</ul>
							</li>
						</c:if>
						<c:if test="${signInStatus==true && currentAdmin!=null}">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"><b class="text-uppercase">${currentAdmin.name}</b><b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li>
										<a href="${pageContext.request.contextPath}/user.do?method=signOut" style="color: black;">Log Out</a>
									</li>
									<li>
										<a href="${pageContext.request.contextPath}/order.do?method=list" style="color: black;">Order Informations</a>
									</li>
									<li>
										<a href="${pageContext.request.contextPath}/payment.do?method=list" style="color: black;">Payment Informations</a>
									</li>
									<li>
										<a href="${pageContext.request.contextPath}/dashboard.do?method=show" style="color: black;">Dashboard</a>
									</li>
								</ul>
							</li>
						</c:if>
						<!-- <li><a href="register.html"><span class="glyphicon glyphicon-lock"> </span>Create an Account</a></li> -->
						<li style="color: white;">
							<bean:message key="languate.title"/>: 
							<html:link page="/localization.do?method=english&currentAction=${currentAction}">
								<img alt="English" src="resource/images/uk.gif" height="15px;" width="25px;">
							</html:link>
							<html:link page="/localization.do?method=japanese&currentAction=${currentAction}">
							 | <img alt="Japan" src="resource/images/japan.gif" height="17px;" width="25px;">
							 </html:link>
						</li>
					</ul>
				</div>
				<div class="he col-md-8 col-sm-12 col-xs-12">
					<div class="" style="">
						<form class="navbar-form navbar-left" style="margin-top: 0 0;">
							<div class="form-group">
								<input required="required" name="searchCriteria" id="searchCriteria" type="text" size="40" class="form-control input-sm" placeholder="Search" style="height: 40px; width: 300px;  font-size: 16px; font-weight: bold;padding: 0 0; margin: 0 0;padding-left: 10px;">
							</div>
							<button name="btnSearch" id="btnSearch" type="button" onclick="searchProducts();" class="btn btn-sm" style="background-color: black; border-color: white;">
								<i class="fa fa-search fa-2x" style="color: white;"></i>
							</button>
						</form>
						<div class="cart box_1">
							<%-- <a href="${pageContext.request.contextPath}/shoppingCart.do?method=show"> --%>
								<h3 style="margin-top: 13px">
									<button class="btn btn-md btn-success" onclick="shoppingCart.viewCart();">
										 <bean:message key="costs.header"/>: <span class="" id="shoppingCartTotalAmount">${totalPrice} </span> 
										| <bean:message key="items.header"/>:<span id="shoppingCartTotalItem" class="">
												${numberOfItems} </span> <i class="fa fa-shopping-bag fa-lg"></i>
									</button>
								</h3>
					  <!-- ==================Modal Start===========================================================-->
									  <div class="modal fade" id="myModal" role="dialog">
									    <div class="modal-dialog">
									    
									      <!-- Modal content-->
									      <div class="modal-content">
									        <div class="modal-header" style="color: white; background: black;" align="center">
									          <button type="button" class="close" data-dismiss="modal" style="color: white;">&times;</button>
									          <h4 class="modal-title text-uppercase"><i class="fa fa-shopping-bag fa-2x"></i>&nbsp;&nbsp;<b>Shopping Cart</b></h4>
									        </div>
									        <div class="modal-body">
									        	<div class="row">
										        	<div id="modalContent" align="center">
										        	
										        	</div>
									        	</div>
									        </div>
									        <div class="modal-footer">
									          <!-- <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
									          <a href="${pageContext.request.contextPath}/shoppingCart.do?method=show">
									          	<button type="button" class="btn btn-default" style="color: white; background: black; ">View Cart Details</button>
									          </a>
									        </div>
									      </div>
									      
									    </div>
									  </div>
					<!-- ==================Modal End===========================================================-->			  
							<!-- </a> -->
							<p style="margin-top: 21px;">
								<strong><a href="javascript:;" class="simpleCart_empty" style="color:white;" onclick="shoppingCart.empty();"><bean:message key="cart.empty.title"/></a>
							</p>
							<div class="clearfix">
								</strong>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
</div>
