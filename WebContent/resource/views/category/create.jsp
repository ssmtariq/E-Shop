<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:if test="${categories!=null}">
	<c:set var="pageTitle" value="Update Category"></c:set>
</c:if>
<c:if test="${categories==null}">
	<c:set var="pageTitle" value="Create Category"></c:set>
</c:if>
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
				<div class="reg">
					<h3 class="text-center section-title">
						<c:if test="${categories!=null}">
							Update Category
						</c:if>
						<c:if test="${categories==null}">
							Create Category
						</c:if>
					</h3>
					<p>Welcome, please enter the following details to continue.</p>
					<p>
						If you have previously registered with us, <a href="#">click
							here</a>
					</p>
					
					<c:if test="${categories!=null}">
						<c:set var="formAction" value="/categoryAction?method=update"></c:set>
					</c:if>
					<c:if test="${categories==null}">
						<c:set var="formAction" value="/categoryAction?method=save"></c:set>
					</c:if>

					<html:form styleClass="form-horizontal" enctype="multipart/form-data"
						action="${formAction}"
						styleId="form-create-category">
						<div class="form-group">
							<div class="row">
							<label for="categoryName"
								class="col-sm-4 control-label form-title-text"> Name<span style="color: red;">*</span></label>
							<div class="col-sm-6 offset-sm-2">
								<c:if test="${categories!=null}">
									<html:hidden property="categoryId" styleClass="form-control" styleId="categoryId" value="${categories.categoryId}"></html:hidden>
									<html:hidden property="createdOn" styleClass="form-control" styleId="createdOn" value="${categories.createdOn}"></html:hidden>
									<html:hidden property="updatedOn" styleClass="form-control" styleId="updatedOn" value="${categories.updatedOn}"></html:hidden>
									<html:text property="categoryName" styleClass="form-control" styleId="categoryName" value="${categories.categoryName}"></html:text>
								</c:if>
								<c:if test="${categories==null}">
									<html:text property="categoryName" styleClass="form-control" styleId="categoryName"></html:text>
								</c:if>
							</div>
							</div>
							<div class="row">
								<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="categoryName"/></div>
							</div>
						</div>
						<div class="form-group">
							<label for="parentId"
								class="col-sm-4 control-label form-title-text">Parent </label>
							<div class="col-sm-6 offset-sm-2">
								<select name="parentId" class="form-control" id="parentId">
									<option value="null">Choose a Category</option>
									<c:forEach items="${categoriesList}" var="categories">
										<option value="${categories.categoryId}">${categories.categoryName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group" style="vertical-align: middle;">
							<label for="categoryImage"
								class="col-sm-4 control-label form-title-text">Image<span style="color: red;">*</span>
							</label>
							<%-- <div class="col-sm-3 offset-sm-2">
								<c:if test="${categories!=null}">
									<img class="img-responsive img-thumbnail" id="previousImage" height="80px;" width="200px;" src="upload/category/${categories.imageName}"/>
								</c:if>
							</div> --%>
							<div class="col-sm-3">
								<html:file property="categoryImage" styleId="categoryImage" onclick="hidePrevious();"></html:file>
							</div>
							<div class="row">
								<div class="col-sm-offset-4 col-sm-6  messages"><html:errors property="categoryImage"/></div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-6 offset-sm-2 ">
								<html:submit styleClass="btn btn-default btn-form-submit">
									<c:if test="${categories!=null}">
										UPDATE CATEGORY
									</c:if>
									<c:if test="${categories==null}">
										ADD CATEGORY
									</c:if>
								</html:submit>
								<p class="click">
									By clicking this button, you are agree to my <a href="#">Policy
										Terms and Conditions.</a>
								</p>
							</div>
						</div>
					</html:form>
				</div>
			</div>
			<!-- Featured Products end -->
		</div>
	</div>
	<!-- Sidebar and Featured Products Section End -->

	<!-- Footer section starts -->
	<c:import url="/resource/layout/layoutFooter.jsp"></c:import>
	<!-- Footer section end -->
	
<!--==========================Page Script Start==========================================-->
	<script type="text/javascript">
		var category = "${categories}";
		var parentId = "${categories.parent.categoryId}";
		$(document).ready(function(){
			$("#categoryName").attr('placeholder', 'Category Name');
			if($("#categoryImage").val()!=null && $("#categoryImage").val()!=""){
				$("#previousImage").hide();
			} 
			if(category!=null){
				alert(categories);
				$("#parentId").val(parentId);
			}
		});
		function hidePrevious(){
			if($("#categoryImage").val()!=null && $("#categoryImage").val()!=""){
				$("#previousImage").remove();
			} 
		}
	</script>
	<!--==========Validation Scripts Start============-->
	<!-- <script>
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
				/* email : {
					// Email is required
					presence : true,
					// and must be an email (duh)
					email : true
				},
				password : {
					// Password is also required
					presence : true,
					// And must be at least 5 characters long
					length : {
						minimum : 5
					}
				},
				"confirm-password" : {
					// You need to confirm your password
					presence : true,
					// and it needs to be equal to the other password
					equality : {
						attribute : "password",
						message : "^The passwords does not match"
					}
				}, */
				categoryName : {
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
				}/* ,
				username : {
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
			var form = document.querySelector("form#form-create-category");
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
					showSuccess();
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
	</script> -->
	<!--==========Validation Scripts End==============-->
<!--==========================Page Script End==========================================-->
</body>
</html>