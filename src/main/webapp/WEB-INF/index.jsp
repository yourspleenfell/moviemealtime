<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="/css/materialize.css">
		<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
		<script src="/js/scripts.js"></script>
		<title>Movie Mealtime</title>
	</head>
	<body>
		<div class="row">
			<div class="col s12 amber lighten-4">
				<h1>Header placeholder~</h1>
			</div>
		</div>
		<div class="row">
			<div class="col s3 light-green lighten-3" id="searchResults">
			<form id="search">
				
				<table>
					<tr>
						<td><input type="text" name="title"></td>
						<td><input type="submit" value="Go!" class="inline"></td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
			</div>
			<div class="col s9 lime lighten-2">
				<div class="col s12 yellow lighten-1 card-panel">
					<p>Testing for test</p>
					<p>Testing for test</p>
					<p>Testing for test</p>
					<p>Testing for test</p>
					<p>Testing for test</p>
					<p>Testing for test</p>
				</div>
				<div class="col s12 green accent-2 card-panel">
					<p>Testing for test</p>
					<p>Testing for test</p>
					<p>Testing for test</p>
					<p>Testing for test</p>
					<p>Testing for test</p>
					<p>Testing for test</p>
					<p>Testing for test</p>
					<p>Testing for test</p>
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