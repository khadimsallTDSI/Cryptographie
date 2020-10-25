<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

        <meta charset="utf-8" />
        <title>Chiffrement Asymetrique</title>
        <link type="text/css" rel="stylesheet" href="../styles/form.css" />
       
        </head>
<body>
<%@include file="menu.jsp"%>

<div class="container">
<fieldset>
<legend class="btn btn-primary" >Chiffrement Asymetrique</legend>
<hr>
	<form action="asym" method="POST">
		<p>
			<label for="plainText">Entrez le text a chiffrer : </label> <input
				type="text" name="plainText" size="120" placeholder="Entrez le mesage a chiffrer.........."  />

		</p>
		<input type="submit" value="Soumettre"  class="btn btn-primary"/>
	</form>

	
	<c:if test="${ !empty chiffrer }">
	<p>
		Message chiffre : 
		<textarea id="w3review" name="w3review" rows="10" cols="50">

<c:out value="${chiffrer}"></c:out>
</textarea>
		
	</p>
	
</c:if>
</fieldset>
</div>
</body>
</html>