<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

        <meta charset="utf-8" />
        <title>Chiffrement Symetrique</title>
        <link type="text/css" rel="stylesheet" href="../styles/form.css" />
       
        </head>
<body>
<%@ include file="menu.jsp"%>


<div class="container">
   <fieldset>
   <legend  class="btn btn-primary">Chiffrement Symetrique</legend>
   <hr>
	<form action="chiffrement" method="POST">
		<p>
			<label for="plainText">Entrez le text a chiffrer : </label> 
			<input
				type="text" name="plainText" size="120" placeholder="Entrez le mesage a chiffrer.........."/>
		</p>
		<input type="submit" value="Soumettre"  class="btn btn-primary"/>
	</form>
	
	
	</fieldset>
	<c:if test="${ !empty test}">
	<p>
		<p>Message chiffre: <c:out value="${cipher}"></c:out>  </p>
	</p>
	</c:if>
	</div>
</body>
</html>