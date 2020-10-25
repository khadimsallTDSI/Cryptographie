
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
 <fieldset>
      <legend>Generation de cle</legend>
	<form method="get" action="gen" enctype="multipart/form-data">
		<p>
			<label for="login">Algorithme : </label> <select style="width:200px;"> 
				<option value="saab"><c:out value="${algo1}"></c:out></option>
				<option value="saab"><c:out value="${algo2}"></c:out></option>
				<option value="saab"><c:out value="${algo3}"></c:out></option>

			</select>
		</p>
		<p>
			<label for="login">Provider : </label> <select  style="width:200px;">
				<option value="saab"><c:out value="${provider1}"></c:out></option>
				<option value="saab"><c:out value="${provider2}"></c:out></option>
				<option value="saab"><c:out value="${provider3}"></c:out></option>

			</select>
		</p>
		</p>
		<label for="login">Taille : </label> <select style="width:200px;">
			<option value="saab"><c:out value="${taille1}"></c:out></option>
			<option value="saab"><c:out value="${taille2}"></c:out></option>
		</select>
		</p>
		<input type="submit" value="generer" class="btn btn-primary"/>

	</form>
	</fieldset>
	
	<input type="text" value="Voir la cle publique"  class="alert alert-success" role="alert">
<div id="content">
<textarea id="w3review" name="w3review" rows="10" cols="50">

<c:out value="${pub }">
			</c:out>
</textarea>
</div>
	


<input type="text" value="Voir la cle prive"   class="alert alert-success" role="alert">
<div id="content">
<textarea id="w3review" name="w3review" rows="10" cols="50">

<c:out value="${priv }">
			</c:out>
</textarea>
</div>

</div>

</body>
</html>