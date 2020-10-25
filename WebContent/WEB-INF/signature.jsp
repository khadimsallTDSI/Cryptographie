<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="menu.jsp"%>



<div class="container">
<c:if test="${ !empty signature}">
	
		<p>Message signe: <c:out value="${signature}"></c:out>  </p>
		
	<p style="color: green">Verification de signature: <c:out value="vrai"></c:out>  </p>
	</c:if>
		<fieldset>
			<legend class="btn btn-primary">Signer un message</legend>
			<hr>
			<form action="signature" method="POST">
				<p>
					<label for="plainText">Entrez le message a signer : </label> 
					<input
						type="text" name="plainText" size="120" placeholder="Entrez le message a signer.........."/>
				</p>
				<input type="submit" value="Soumettre" class="btn btn-primary" />
			</form>

		</fieldset>
		
</div>


</body>
</html>