<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<c:set var="pageTitle">signUp.header</c:set>
	<c:import url="/resource/layout/layoutHeader.jsp">
		<c:param name="pageTitle" value="${pageTitle}"></c:param>
	</c:import>
</head>
<body>
	<!-- header-section-starts -->
		<c:import url="/resource/layout/layoutNavigator.jsp"></c:import>
	<!-- header-section-ends -->
		
	<!-- Banner top starts -->
		<c:import url="/resource/layout/layoutBanner.jsp"></c:import>
	<!-- Banner top end -->
	
	<!-- registration-form -->
		<div class="registration-form" style="padding-top: 0;">
			<div class="container">
				<div class="dreamcrub" style="padding-bottom: 0px; margin: 0 0;">
					   	 <ul class="breadcrumbs">
		                    <li class="home">
		                       <a href="${pageContext.request.contextPath}/home.do" title="Go to Home Page"><bean:message key="home.header"/></a>&nbsp;
		                       <span>/</span>
		                    </li>
		                    <li class="">
		                       <bean:message key="registration.header"/>
		                    </li>
		                </ul>
		                <ul class="previous">
		                	<li><a href="${pageContext.request.contextPath}/user.do?method=signIn"><bean:message key="back.previous.header"/></a></li>
		                </ul>
		                <div class="clearfix"></div>
			   </div>
				<h2><bean:message key="registration.header"/></h2>
				<div class="registration-grids">
					<div class="row">
						<div class="col-md-7">
							<div class="reg">
								 <p><bean:message key="reg.welcome.header"/>,<br> <a href="#"><bean:message key="click.header"/></a></p>
								 <html:form styleClass="form-horizontal" action="/userAction?method=saveUser" styleId="form-user-registration">
									  <div class="form-group">
									    <label for="firstName" class="col-sm-4 control-label form-title-text"><bean:message key="firstName.header"/><span style="color: red;">*</span></label>
									    <div class="col-sm-8">
									      <html:text property="firstName" styleClass="form-control" styleId="firstName"></html:text>
									    </div>
									    <div class="row">
											<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="firstName"/></div>
										</div>
									  </div>
									  <div class="form-group">
									    <label for="lastName" class="col-sm-4 control-label form-title-text"><bean:message key="lastName.header"/></label>
									    <div class="col-sm-8">
									      <html:text property="lastName" styleClass="form-control" styleId="lastName"></html:text>
									    </div>
									    <div class="row">
											<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="lastName"/></div>
										</div>
									  </div>
									  <div class="form-group">
									    <label for="emailAddress" class="col-sm-4 control-label form-title-text emailLabel"><bean:message key="email.header"/><span style="color: red;">*</span></label>
									    <div class="col-sm-8">
									      <html:text property="email" styleClass="form-control" styleId="emailAddress"></html:text>
									    </div>
									    <div class="row">
											<div class="col-sm-offset-4 col-sm-6  messages emailExistance"><html:errors property="email"/></div>
										</div>
									  </div>
									  <div class="form-group">
									    <label for="password" class="col-sm-4 control-label form-title-text"><bean:message key="password.header"/><span style="color: red;">*</span></label>
									    <div class="col-sm-8">
									      <html:password property="password" styleClass="form-control" styleId="password"></html:password>
									    </div>
									    <div class="row">
											<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="password"/></div>
										</div>
									  </div>
									  <div class="form-group">
									    <label for="confirmPassword" class="col-sm-4 control-label form-title-text"><bean:message key="confirmPassword.header"/><span style="color: red;">*</span></label>
									    <div class="col-sm-8">
									      <html:password property="confirmPassword" styleClass="form-control" styleId="confirmPassword"></html:password>
									    </div>
									    <div class="row">
											<div class="col-sm-offset-4 col-sm-6  messages"></div>
										</div>
									  </div>
									  <div class="form-group">
									    <label for="mobile" class="col-sm-4 control-label form-title-text"><bean:message key="mobileNo.header"/><span style="color: red;">*</span></label>
									    <div class="col-sm-8">
									      <html:text property="mobileNo" styleClass="form-control" styleId="mobileNo"></html:text>
									    </div>
									    <div class="row">
											<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="mobileNo"/></div>
										</div>
									  </div>
									  <div class="form-group">
									    <label for="billingCountryId" class="col-sm-4 control-label form-title-text"><bean:message key="billingCountry.header"/><span style="color: red;">*</span></label>
									    <div class="col-sm-8">
									      <select name="billingCountryId" class="form-control" id="billingCountryId">
									      	<option value="">Choose a Country</option>
									    	<c:forEach items="${countriesList}" var="countries">
									    		<option value="${countries.countryId}">${countries.countryName}</option>
									    	</c:forEach>
									      </select>
									    </div>
									    <div class="row">
											<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="billingCountryId"/></div>
										</div>
									  </div>
									  <div class="form-group">
									    <label for="billingCity" class="col-sm-4 control-label form-title-text"><bean:message key="billingCity.header"/><span style="color: red;">*</span></label>
									    <div class="col-sm-8">
									    	<html:text property="billingCity" styleClass="form-control" styleId="billingCity"></html:text>
									    </div>
									    <div class="row">
											<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="billingCity"/></div>
										</div>
									  </div>
									  <div class="form-group">
									    <label for="billingAddress" class="col-sm-4 control-label form-title-text"><bean:message key="billingAddress.header"/><span style="color: red;">*</span></label>
									    <div class="col-sm-8">
									      	<html:textarea property="billingAddress" rows="5" cols="5" styleClass="form-control" styleId="billingAddress"></html:textarea>
									    </div>
									    <div class="row">
											<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="billingAddress"/></div>
										</div>
									  </div>
									  <div class="form-group">
									    <label for="billingZipcode" class="col-sm-4 control-label form-title-text"><bean:message key="billingZipcode.header"/><span style="color: red;">*</span></label>
									    <div class="col-sm-8">
									      	<html:text property="billingZipcode" styleClass="form-control" styleId="billingZipcode"></html:text>
									    </div>
									    <div class="row">
											<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="billingZipcode"/></div>
										</div>
									  </div>
	  								  <div class="form-group">
									    <div class="col-sm-offset-4 col-sm-8">
									      <div class="checkbox">
									        <label>
									          <input type="checkbox" name="sameAsBilling" id="sameAsBilling" onclick="userRegistrationObject.copyAddress();"> <bean:message key="sameAsBilling.header"/>
									        </label>
									      </div>
									    </div>
									    <div class="row">
											<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="sameAsBilling"/></div>
										</div>
									  </div>
									  <div class="form-group">
									    <label for="shippingCountryId" class="col-sm-4 control-label form-title-text"><bean:message key="shippingCountry.header"/>y<span style="color: red;">*</span></label>
									    <div class="col-sm-8">
									      <select name="shippingCountryId" class="form-control" id="shippingCountryId">
									      	<option value="0">Choose a Country</option>
									    	<c:forEach items="${countriesList}" var="countries">
									    		<option value="${countries.countryId}">${countries.countryName}</option>
									    	</c:forEach>
									      </select>
									    </div>
									    <div class="row">
											<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="shippingCountryId"/></div>
										</div>
									  </div>
									  <div class="form-group">
									    <label for="shippingCity" class="col-sm-4 control-label form-title-text"><bean:message key="shippingCity.header"/><span style="color: red;">*</span></label>
									    <div class="col-sm-8">
									    	<html:text property="shippingCity" styleClass="form-control" styleId="shippingCity"><span style="color: red;">*</span></html:text>
									    </div>
									    <div class="row">
											<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="shippingCity"/></div>
										</div>
									  </div>
									<div class="form-group">
										<label for="shippingAddress"
											class="col-sm-4 control-label form-title-text"><bean:message key="shippingAddress.header"/><span style="color: red;">*</span>
										</label>
										<div class="col-sm-8">
											<html:textarea property="shippingAddress" rows="5" cols="5"
												styleClass="form-control" styleId="shippingAddress"></html:textarea>
										</div>
										<div class="row">
											<div class="col-sm-offset-4 col-sm-6  messages">
												<html:errors property="shippingAddress" />
											</div>
										</div>
									</div>
									<div class="form-group">
									    <label for="shippingZipcode" class="col-sm-4 control-label form-title-text"><bean:message key="shippingZipcode.header"/><span style="color: red;">*</span></label>
									    <div class="col-sm-8">
									      	<html:text property="shippingZipcode" styleClass="form-control" styleId="shippingZipcode"></html:text>
									    </div>
									    <div class="row">
											<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="shippingZipcode"/></div>
										</div>
									  </div>
	  								
									  
									  <div class="form-group">
									    <div class="col-sm-offset-4 col-sm-8 ">
									      <html:submit styleClass="btn btn-default btn-form-submit text-uppercase"><bean:message key="btnRegister.header"/></html:submit>
									      <p class="click"><bean:message key="userAgreement.header"/> <a href="#"><bean:message key="userPolicy.header"/></a></p> 
									    </div>
									  </div>
								</html:form>
							 </div>
						</div>
						<div class="col-md-5">
							 <h3>Completely Free Account</h3>
							 <div class="strip"></div>
							 <p style="color: #CAC9C9">Pellentesque neque leo, dictum sit amet accumsan non, dignissim ac mauris. Mauris rhoncus, lectus tincidunt tempus aliquam, odio 
							 libero tincidunt metus, sed euismod elit enim ut mi. Nulla porttitor et dolor sed condimentum. Praesent porttitor lorem dui, in pulvinar enim rhoncus vitae. Curabitur tincidunt, turpis ac lobortis hendrerit, ex elit vestibulum est, at faucibus erat ligula non neque.</p>
							 <h3 class="lorem">Lorem ipsum dolor.</h3>
							 <div class="strip"></div>
							 <p style="color: #CAC9C9">Tincidunt metus, sed euismod elit enim ut mi. Nulla porttitor et dolor sed condimentum. Praesent porttitor lorem dui, in pulvinar enim rhoncus vitae. Curabitur tincidunt, turpis ac lobortis hendrerit, ex elit vestibulum est, at faucibus erat ligula non neque.</p>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
		</div>
	<!-- registration-form -->
			
	<!-- Footer section starts -->
		<c:import url="/resource/layout/layoutFooter.jsp"></c:import>
	<!-- Footer section end -->
	
	<!-- Page Scripts start-->
		<script type="text/javascript">
			$(document).ready(function(){
			    $("#firstName").attr("placeholder", "First Name");
			    $("#lastName").attr("placeholder", "Last Name");
			    $("#emailAddress").attr("placeholder", "Email");
			    $("#password").attr("placeholder", "Password");
			    $("#mobileNo").attr("placeholder", "Mobile");
			    $("#billingCity").attr("placeholder", "Billing City");
			    $("#shippingCity").attr("placeholder", "Shipping City");
			    $("#billingZipcode").attr("placeholder", "Billing Zipcode");
			    $("#shippingZipcode").attr("placeholder", "Shipping Zipcode");
			    
			    $("#form-user-registration").trigger('reset');
				
			    $("#emailAddress").blur(function(){
				    var email = $("#emailAddress").val();
				    if(email!=null && email!=""){
				    	$.ajax({                                            
					        url: 'user.do?method=isEmailExists',   
					        data: {email:email},
							dataType : 'json',
							async : false,
							success : function(data) {
								console.log(data);
								if(data==true){
									$(".emailExistance").html("<span style='color:red;'>Email Address Already Registered. Please sign in or try with a different one.</span>");
									$("#emailAddress").val("");
									$(".emailLabel").attr('color', 'red');
								}else{
									$(".emailExistance").html("");
									$(".emailLabel").attr('color', 'green');
								}
								console.log("ajax call success");
							}
						});// end of ajax call;
				    }
			    });

			});

			var userRegistrationObject = {
				copyAddress: function(){
					if($("input[name='sameAsBilling']:checked").val()){
						$("#shippingCountryId").val($("#billingCountryId").val());
						$("#shippingCity").val($("#billingCity").val());
						$("#shippingAddress").val($("#billingAddress").val());
						$("#shippingZipcode").val($("#billingZipcode").val());
					}else{
						$("#shippingCountryId").val(0);
						$("#shippingCity").val("");
						$("#shippingAddress").val("");
						$("#shippingZipcode").val("");
					}
				}
			}
		</script>
		<!--==========Validation Scripts Start============-->
		<script>
			(function() {
				// Before using it we must add the parse and format functions
				// Here is a sample implementation using moment.js
				validate.extend(validate.validators.datetime, {
					// The value is guaranteed not to be null or undefined but otherwise it
					// could be anything.
					parse : function(value, options) {
						return +moment.utc(value);
					},
					// Input is a unix timestamp
					format : function(value, options) {
						var format = options.dateOnly ? "YYYY-MM-DD"
								: "YYYY-MM-DD hh:mm:ss";
						return moment.utc(value).format(format);
					}
				});
				// These are the constraints used to validate the form
				var constraints = {
					/* firstName : {
						// You need to pick a username too
						presence : true,
						// And it must be between 3 and 20 characters long
						length : {
							minimum : 3,
							maximum : 30
						},
						format : {
							// We don't allow anything that a-z and 0-9
							pattern : "[a-z]+",
							// but we don't care if the username is uppercase or lowercase
							flags : "i",
							message : "can only contain a-z and A-Z letters only"
						}
					},
					lastName : {
						// You need to pick a username too
						//presence : true,
						// And it must be between 3 and 20 characters long
						length : {
							minimum : 3,
							maximum : 30
						},
						format : {
							// We don't allow anything that a-z and 0-9
							pattern : "[a-z]+",
							// but we don't care if the username is uppercase or lowercase
							flags : "i",
							message : "can only contain a-z and A-Z letters only"
						}
					},
					email : {
						// Email is required
						presence : true,
						// and must be an email (duh)
						email : true
					}, */
					password : {
						// Password is also required
						presence : true,
						// And must be at least 5 characters long
						length : {
							minimum : 5
						}
					},
					confirmPassword : {
						// You need to confirm your password
						presence : true,
						// and it needs to be equal to the other password
						equality : {
							attribute : "password",
							message : "^The passwords does not match"
						}
					}/*, */
					/* username : {
						// You need to pick a username too
						presence : true,
						// And it must be between 3 and 20 characters long
						length : {
							minimum : 3,
							maximum : 20
						},
						format : {
							// We don't allow anything that a-z and 0-9
							pattern : "[a-z0-9]+",
							// but we don't care if the username is uppercase or lowercase
							flags : "i",
							message : "can only contain a-z and 0-9"
						}
					},
					birthdate : {
						// The user needs to give a birthday
						presence : true,
						// and must be born at least 18 years ago
						date : {
							latest : moment().subtract(18, "years"),
							message : "^You must be at least 18 years old to use this service"
						}
					},
					country : {
						// You also need to input where you live
						presence : true,
						// And we restrict the countries supported to Sweden
						inclusion : {
							within : [ "SE" ],
							// The ^ prevents the field name from being prepended to the error
							message : "^Sorry, this service is for Sweden only"
						}
					},
					zip : {
						// Zip is optional but if specified it must be a 5 digit long number
						format : {
							pattern : "\\d{5}"
						}
					},
					"number-of-children" : {
						presence : true,
						// Number of children has to be an integer >= 0
						numericality : {
							onlyInteger : true,
							greaterThanOrEqualTo : 0
						}
					} */
				};
				// Hook up the form so we can prevent it from being posted
				var form = document.querySelector("form#form-user-registration");
				form.addEventListener("submit", function(ev) {
					ev.preventDefault();
					handleFormSubmit(form);
				});
				// Hook up the inputs to validate on the fly
				var inputs = document.querySelectorAll("input, textarea, select")
				for (var i = 0; i < inputs.length; ++i) {
					inputs.item(i).addEventListener("change", function(ev) {
						var errors = validate(form, constraints) || {};
						showErrorsForInput(this, errors[this.name])
					});
				}
				function handleFormSubmit(form, input) {
					console.log(form);
					console.log("handleFormSubmit=" + input);
					// validate the form aainst the constraints
					var errors = validate(form, constraints);
					// then we update the form to reflect the results
					showErrors(form, errors || {});
					if (!errors) {
						/* showSuccess(); */
						$("#form-user-registration").submit();
					}
				}
				// Updates the inputs with the validation errors
				function showErrors(form, errors) {
					// We loop through all the inputs and show the errors for that input
					_.each(form.querySelectorAll("input[name], select[name]"),
							function(input) {
								// Since the errors can be null if no errors were found we need to handle
								// that
								console.log("showErrors=" + input);
								showErrorsForInput(input, errors
										&& errors[input.name]);
							});
				}
				// Shows the errors for a specific input
				function showErrorsForInput(input, errors) {
					console.log("showErrorsForInput=" + input);
					console.log("showErrorsForInput="
							+ closestParent(input.parentNode, "form-group"));
					// This is the root of the input
					var formGroup = closestParent(input.parentNode, "form-group")
					// Find where the error messages will be insert into
					, messages = formGroup.querySelector(".messages");
					// First we remove any old messages and resets the classes
					resetFormGroup(formGroup);
					// If we have errors
					if (errors) {
						// we first mark the group has having errors
						formGroup.classList.add("has-error");
						// then we append all the errors
						_.each(errors, function(error) {
							addError(messages, error);
						});
					} else {
						// otherwise we simply mark it as success
						formGroup.classList.add("has-success");
					}
				}
				// Recusively finds the closest parent that has the specified class
				function closestParent(child, className) {
					if (!child || child == document) {
						return null;
					}
					if (child.classList.contains(className)) {
						return child;
					} else {
						return closestParent(child.parentNode, className);
					}
				}
				function resetFormGroup(formGroup) {
					// Remove the success and error classes
					formGroup.classList.remove("has-error");
					formGroup.classList.remove("has-success");
					// and remove any old messages
					_.each(formGroup.querySelectorAll(".help-block.error"),
							function(el) {
								el.parentNode.removeChild(el);
							});
				}
				// Adds the specified error with the following markup
				// <p class="help-block error">[message]</p>
				function addError(messages, error) {
					var block = document.createElement("p");
					block.classList.add("help-block");
					block.classList.add("error");
					block.innerText = error;
					messages.appendChild(block);
				}
				function showSuccess() {
					// We made it \:D/
					alert("Success!");
				}
			})();
		</script>
	<!--==========Validation Scripts End==============-->
	<!-- Page Scripts end -->
	
</body>
</html>