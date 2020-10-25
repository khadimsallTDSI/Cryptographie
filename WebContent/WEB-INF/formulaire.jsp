<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Chiffrement Symetrique d'un fichier</title>
</head>
<body>
<%@ include file="menu.jsp"%>
<div  class="container">
        <c:if test="${ !empty form.resultat }"><p><c:out value=" ${ form.resultat }" /></p></c:if>
        
        <c:if test="${ !empty fichier }"><p><c:out value="Le fichier ${ fichier } (${ description }) a été uploadé !" /></p>
        <div id="content">
<textarea id="w3review" name="w3review" rows="10" cols="50">

<c:out value="${line}">
			</c:out>
</textarea>

<textarea id="w3review" name="w3review" rows="10" cols="50">

<c:out value="${chiffrer}">
			</c:out>
</textarea>
</div>
	
    </c:if>  
      <fieldset>
      <legend class="btn btn-primary">Chiffrement Symetrique d'un fichier</legend>
        <form action="formulaire"  method="POST" enctype="multipart/form-data" >
       <!--  <p>
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
            <label for="fichier">Fichier à envoyer : </label>
            <input type="file" name="fichier" id="fichier" class="btn btn-primary"/>
        </p>
    
            <input type="submit" value="Soumettre" class="btn btn-primary"/>
        </form>
        </fieldset>
        </div>
    </body>
</html> 