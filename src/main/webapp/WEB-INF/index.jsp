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
				<div class="nav-wrapper amber">
					<a href="#!" class="brand-logo">Movie Mealtime</a>
			        <ul class="right hide-on-med-and-down">
			        	<li><a class="waves-effect waves-light btn">Settings</a></li>
			        	<li><a class="waves-effect waves-light btn">Logout</a></li>
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
			<div class="col s9 right">
				<div class="col s12 yellow lighten-1 card-panel" id="movieDetails">
				
				</div>
				<div class="col s12 green accent-2 card-panel" id="foods">
					<div class="col s12">
					<span class="card-title"><h4>Suggested Foods</h4></span>
					</div>
					<div class="col s12" id="foodDetails">
					
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col s12 amber lighten-4">
				<p>Footer placeholder~</p>
			</div>
		</div>
	</body>
</html>