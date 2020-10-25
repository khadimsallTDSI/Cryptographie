<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="menu.jsp"%>



       
        <div id="content">
 Private Key
<textarea id="w3review" name="w3review" rows="10" cols="50">

<c:out value="${priv}">
			</c:out>
</textarea>
Public Key
<textarea id="w3review" name="w3review" rows="10" cols="50">

<c:out value="${publicKey}">
			</c:out>
</textarea>
</div>
	




	
</body>
</html>