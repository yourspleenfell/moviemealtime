<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="/css/materialize.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<title>Movie Mealtime</title>
	</head>
	<body>
		<div class="navbar-fixed">
			<nav>
				<div class="nav-wrapper grey darken-4">
					<img src="/img/logo.png" class="logo-sm"><span class="brand-logo">Movie Mealtime</span>
			        <ul class="right hide-on-med-and-down">
			        	<c:choose>
			        		<c:when test="${currentUser == null}">
					        	<li><a href="#loginModal" class="btn waves-effect waves-light red accent-4 modal-trigger">Login/Register</a></li>
			        		</c:when>
			        		<c:otherwise>
			        			<li><a href="#settingsModal" class="btn waves-effect waves-light red accent-4 modal-trigger">Settings</a></li>
					        	<li><a href="<c:url value="/logout" />" class="btn waves-effect waves-light red accent-4" id="logOut">Logout</a></li>
			        		</c:otherwise>
			        	</c:choose>
			        </ul>
			        <c:if test="${currentUser != null}">
						<span class="right">Hello, <c:out value="${currentUser.firstName}"></c:out></span>
					</c:if>
				</div>
			</nav>
		</div>
		<div id="container">
			<div class="row">
				<div class="col s3">
					<div class="col s12 card-panel">
							<div class="nav-wrapper">
								<form id="searchy">
							        <div class="input-field">
							        	<input id="titleSearch" type="search" id="title" required" placeholder="Search movie titles here">
							        	<label class="label-icon" for="search"><i class="material-icons">search</i></label>
							        	<i class="material-icons">close</i>
							        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							    	</div>
							    </form>
							</div>
					</div>
					<div class="col s12" id="searchResults">
					
					</div>
				</div>
				<div class="col s9">
					<div class="col s12 " id="movieDetails">
						
					</div>
					<div class="col s12" id="foods">
						<div class="col s12">
							<span class="card-title"><h4>Suggested Recipes</h4></span>					
						</div>
						<div class="col s12" >
							<div class="container" id="foodDetails">
								<div id="meal1" class="col m4">
                                
	                            </div>
	                            <div id="meal2" class="col m4">
	                                
	                            </div>
	                            <div id="meal3" class="col m4">
	                                
	                            </div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<c:if test="${currentUser == null}">
			<div id="loginModal" class="modal">
			    <div class="modal-content">
			    	<div class="row">
				        <div class="col s6">
				        	<h5>Login</h5>
				        	<form id="login" method="POST" action="/">
				        		<c:if test="${error != null}">
			        				<p><c:out value="${error}"/></p>
			    				</c:if>
				        		<div class="input-field col s12">
				        			<i class="material-icons prefix">email</i>
						        	<input type="text" name="username" id="username" class="validate"/>
						        	<label for="username">Email</label>
				        		</div>
				        		<div class="input-field col s12">
				        			<i class="material-icons prefix">lock</i>
						        	<input type="password" name="password" id="passwordLogin" class="validate"/>
						        	<label for="passwordLogin">Password</label>
				        		</div>
						        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						        <button type="submit" class="btn waves-effect waves-light red accent-4 modal-close">Login</button>
				        	</form>
				        </div>
				        <div class="col s6">
				        	<h5>Register</h5>
				    		<form:form method="POST" action="/register" modelAttribute="user">
		        				<div class="input-field col s6">
		        					<i class="material-icons prefix">account_circle</i>
		        					<form:input path="firstName" class="validate"/>
		        					<form:label path="firstName">First Name</form:label>
		        					<span class="red-text text-lighten-1"><form:errors path="firstName"/></span>
						        </div>
						        <div class="input-field col s6">
		        					<form:input path="lastName" class="validate"/>
		        					<form:label path="lastName">Last Name</form:label>
		        					<span class="red-text text-lighten-1"><form:errors path="lastName"/></span>
						        </div>
						        <div class="input-field col s12">
		        					<i class="material-icons prefix">email</i>
		        					<form:input path="email" class="validate"/>
		        					<form:label path="email">Email</form:label>
		        					<span class="red-text text-lighten-1"><form:errors path="email"/></span>
						        </div>
						        <div class="input-field col s12">
		        					<i class="material-icons prefix">calendar_today</i>
		        					<form:input type="date" path="birthday" class="validate"/>
		        					<form:label path="birthday">Birthday</form:label>
		        					<span class="red-text text-lighten-1"><form:errors path="birthday"/></span>
						        </div>
						        <div class="input-field col s12">
		        					<i class="material-icons prefix">lock</i>
		        					<form:input type="password" path="password" class="validate"/>
		        					<form:label path="password">Password</form:label>
		        					<span class="red-text text-lighten-1"><form:errors path="password"/></span>
						        </div>
						        <div class="input-field col s12">
		        					<i class="material-icons prefix">lock_outlined</i>
		        					<form:input type="password" path="passwordConfirmation" class="validate"/>
		        					<form:label path="passwordConfirmation">Password Confirmation</form:label>
		        					<span class="red-text text-lighten-1"><form:errors path="passwordConfirmation"/></span>
						        </div>
						        
						        <button type="submit" class="btn waves-effect waves-light red accent-4">Register</button>
				        
				        	</form:form>
				    	</div>
				    </div>
				</div>
			</div>
		</c:if>
		<c:if test="${currentUser != null}">
			<div id="settingsModal" class="modal">
			    <div class="modal-content">
			    	<a class="modal-close waves-effect waves-green btn-flat right">X</a><h4>Update Account</h4>
				    <form:form action="/users/update" modelAttribute="currentUser">
				    	<div class="row">
					    	<div class="input-field col s6">
		       					<i class="material-icons prefix">account_circle</i>
		       					<form:input path="firstName" class="validate"/>
		       					<form:label path="firstName">First Name</form:label>
		       					<span class="red-text text-lighten-1"><form:errors path="firstName"/></span>
					        </div>
					        <div class="input-field col s6">
		       					<form:input path="lastName" class="validate"/>
		       					<form:label path="lastName">Last Name</form:label>
		       					<span class="red-text text-lighten-1"><form:errors path="lastName"/></span>
					        </div>
					        <div class="input-field col s12">
	        					<i class="material-icons prefix">email</i>
	        					<form:input path="email" class="validate"/>
	        					<form:label path="email">Email</form:label>
	        					<span class="red-text text-lighten-1"><form:errors path="email"/></span>
					        </div>
					        <div class="input-field col s12">
	        					<i class="material-icons prefix">calendar_today</i>
	        					<form:input type="date" path="birthday" class="validate"/>
	        					<form:label path="birthday">Birthday</form:label>
	        					<span class="red-text text-lighten-1"><form:errors path="birthday"/></span>
					        </div>
				        </div>
				        <button type="submit" class="btn waves-effect waves-light red accent-4">Update</button>
				    </form:form>
				</div>
			</div>
			<div id="dirModal" class="modal bottom-sheet">
				
			</div>
		</c:if>
		<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
		<script src="/js/materialize.js"></script>
		<script src="/js/scripts.js"></script>
		<c:if test="${currentUser == null}">
			<script>
				$(document).ready(function(){
					$('.modal').modal();
					$('#loginModal').modal('open');
					$('.trigger-modal').modal();
				});
			</script>
		</c:if>
		<c:if test="${editing}">
			<script>
				$(document).ready(function(){
					$('.modal').modal();
					$('#settingsModal').modal('open');
					$('.trigger-modal').modal();
				});
			</script>
		</c:if>
	</body>
</html>