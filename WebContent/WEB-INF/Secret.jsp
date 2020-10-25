<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8" />
        <title>Generation de cle</title>
        <link type="text/css" rel="stylesheet" href="../styles/form.css" />
        <style type="text/css">
        
        

#content {
  display: none;
}
input[type="text"]{
    color: transparent;
    text-shadow: 0 0 0 #000;
    padding: 6px 12px;
    width: 150px;
    cursor: pointer;
}
input[type="text"]:focus{
    outline: none;
}
input:focus + div#content {
  display: block;
}

  
 
        </style>
        
      
    </head>
<body>


	<%@include file="menu.jsp"%>
	
	<div class="container">
	   <c:if test="${ !empty erreur }"><p style="color:red;"><c:out value="${ erreur }" /></p></c:if>
      <fieldset>
      <legend>Generation de cle Symetrique </legend>
<c:if test="${ !empty secret}">
      
<input type="text" value="Voir la cle Symetrique"   class="alert alert-success" role="alert">
<div id="content">
<textarea id="w3review" name="w3review" rows="4" cols="20">

<c:out value="${secret}"></c:out>
</textarea>
</div>

  </c:if>
	<form action="secret" method="get">
		<p>
			<label for="login">Algorithme : </label> 
			<select  style="width:200px;">
				<option value="saab">choisir..</option>
			
				<option value="saab"><c:out value="${algo1}"></c:out></option>
				<option value="saab"><c:out value="${algo2}"></c:out></option>

			</select>
		</p>
		<p>
			<label for="login">Provider : </label> 
			<select style="width:200px;">
				<option value="saab"><c:out value="${provider}"></c:out></option>

			</select>
		</p>
		</p>
		<label for="login">Taille : </label> 
		<select  style="width:200px;">
			<option value="saab"><c:out value="${taille}"></c:out></option>
			<option value="saab"><c:out value="${taille1}"></c:out></option>


		</select>
		</p>
		<input type="submit" value="generer" class="btn btn-primary" />

	</form>
	
	<br><br>

</div>
</fieldset>
</body>
</html>