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
		<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
		
		<script src="/js/scripts.js"></script>
		<title>Movie Mealtime</title>
	</head>
	<body>
		<div class="navbar-fixed">
			<nav>
				<div class="nav-wrapper grey darken-4">
					<a href="#!" class="brand-logo">Movie Mealtime</a>
			        <ul class="right hide-on-med-and-down">
			        <c:choose>
			        <c:when test="${not empty loggedInUser}">
					    <li><button id="mySetBtn">Settings</button></li>
					</c:when>
					<c:when test="${empty loggedInUser}">
					   	<li><button id="myLoginBtn">Login</button></li>
		        		<li><button id="myRegBtn">Register</button></li>
					</c:when>
					</c:choose>
			        </ul>
				</div>
			</nav>
		</div>
		<div class="row">
			<div class="col s3">
				<div class="col s12">
					<div class="nav-wrapper card-panel">
						<form id="searchy">
					        <div class="input-field">
					        	<input id="titleSearch" type="search" id="title" required">
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
						
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col s12 amber lighten-4">
				<p>Footer placeholder~</p>
			</div>
		</div>
		<div id="myLoginModal" class="modal">
		    <div class="modal-content card-panel">
		    <span id="logclose" class="close">&times;</span>
			    <form method="POST" action="/login">
			    	<c:if test="${errorMessage != null}">
        			<c:out value="${errorMessage}"></c:out>
    				</c:if>
		        
			        <p><label for="username">Email:</label>
			        <input type="text" id="username" name="username"/></p>
			        
			        <p><label for="password">Password</label>
			        <input type="password" id="logpassword" name="password"/></p>
			        
			        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			        <input type="submit" value="Login!"/>
		        
		        </form>
			</div>
		</div>
		<div id="myRegModal" class="modal">
		    <div class="modal-content card-panel">
		    <span id="regclose" class="close">&times;</span>
			    <form:form method="POST" action="/registration" modelAttribute="user">
        
		        <p><form:label path="firstName">First Name:</form:label>
			        <form:input path="firstName"/>
			        <form:errors path="firstName"/></p>
			        
			        <p><form:label path="lastName">Last Name:</form:label>
			        <form:input path="lastName"/>
			        <form:errors path="lastName"/></p>
			        
			        <p><form:label path="email">Email:</form:label>
			        <form:input path="email"/>
			        <form:errors path="email"/></p>
			                    
			        <p><form:label path="password">Password:</form:label>
			        <form:password path="password"/>
			        <form:errors path="password"/></p>
			                
			        <p><form:label path="passwordConfirmation">Password Confirmation:</form:label>
			        <form:password path="passwordConfirmation"/>
			        <form:errors path="passwordConfirmation"/></p>
			        
			        <input type="submit" value="Register!"/>
		        
		        </form:form>
			</div>
		</div>
		</div>
	</body>
</html>