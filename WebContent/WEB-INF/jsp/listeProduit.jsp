<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="POST" commandName="criteres">
		<table>
			<tr>
				<td>criteres:</td>
				<td><form:input path="criteres" /></td>
				<td><form:errors path="criteres" /></td>
			</tr>
<tr>		
 	<td colspan="2"><input type="submit" value="rechercher"></td>
			</tr>
		</table>
	</form:form>
<br/>
	<h2> Liste des produits</h2>

	<c:if test="${not empty listProduit}">

		<ul>
			<c:forEach var="listProduit" items="${listProduit}">
				<li>${listProduit.concepteur}</li>
				
			</c:forEach>
		</ul>

	</c:if>
</body>
</html>