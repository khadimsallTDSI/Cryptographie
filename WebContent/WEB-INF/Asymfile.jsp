<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Chiffrement Asymetrique d'un fichier</title>
<style type="text/css">



</style>
</head>
<body>
<%@ include file="menu.jsp"%>
<div class="container card">

        <c:if test="${ !empty form.resultat }"><p><c:out value=" ${ form.resultat }" /></p></c:if>
        
        <c:if test="${ !empty fichier }"><p style="color: green"><c:out value="Le fichier ${ fichier } (${ description }) a été uploadé !" /></p>
        <div id="content">
<textarea id="w3review" name="w3review" rows="10" cols="50">

<c:out value="${line }">
			</c:out>
</textarea>

<textarea id="w3review" name="w3review" rows="10" cols="50">

<c:out value="${chiffrer} ">
			</c:out>
</textarea>
<br>
Detail du Chiffrement : <c:out value="${algo} "></c:out><br>

</div> 
</c:if>
      <fieldset>
      <legend class="btn btn-primary">Chiffrement Asymetrique d'un fichier</legend>
        <form action="Asymfile"  method="POST" enctype="multipart/form-data" >
        <!-- <p>
            <label for="login">Login : </label>
            <input type="text" name="login" id="login" />
           </p> 
           <p>
            <label for="pass">Password : </label>
            <input type="password" name="pass" id="pass" />
            </p>
              <p>
            <label for="description">Description du fichier : </label>
            <input type="text" name="description" id="description" />
        </p> -->
        <p>
            <label for="upload">Choisir un fichier  : </label>
            <input type="file" name="fichier" id="upload"  class="btn btn-primary" />
        </p>
    
            <input type="submit" value="Soumettre" class="btn btn-primary"   />
        </form>
        
        </fieldset>
        </div>
        
        
     
        
    </body>
</html> 