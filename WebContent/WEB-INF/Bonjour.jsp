
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%@include file="menu.jsp" %>
	<p>Cryptographie en java</p>
		   <c:out value="${ algo }" />
	
<%--         <c:if test="${ !empty algo}"><p><c:out value="Algo ${ fichier } " /></p></c:if> --%>
<p>Clef prive </p>
        	   <c:out value="${cle}"> </c:out>
        
        <select name="cars" id="cars"  style="width:200px;">
  
  <option value="saab"><c:out value="${algo}"></c:out></option>
 
</select>

  
 <select name="cars" id="cars"  style="width:200px;">
  
  <option value="saab"><c:out value="${pro}"></c:out></option>
 
</select>

<select name="cars" id="cars"  style="width:200px;">
  
  <option value="saab"><c:out value="${taille}"  ></c:out></option>
 
</select>
        
        

</body>
</html>