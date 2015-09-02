<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cine Arcade</title>
</head>
<body>
CineArcade

 <nav>
        <ul>
            <li><a href="createUser.htm">Mon Compte</a></li>
            <li><a href="monPanier.htm">Mon Panier</a></li>
<%--             <li><a href="<%=request.getContextPath()%>/livre/livres.htm">Les livres</a></li> --%>
<%--             <li><a href="<%=request.getContextPath()%>/livre/ajoutLivre.htm">Ajout livre</a></li> --%>
       </ul>
    </nav>
    
    <form:form method="POST" commandName="criteres">
		<table>
			<tr>
				<td>criteres:</td>
				<td><form:input path="criteres" /></td>
				<td><form:errors path="criteres" /></td>
			</tr>
		
				<td colspan="2"><input type="submit" value="rechercher"></td>
			</tr>
		</table>
	</form:form>
<br/>
	<h2> List Produits</h2>

	<c:if test="${not empty listProduit}">

		<ul>
			<c:forEach var="listProduit" items="${listProduit}">
				<li>${listProduit.concepteur}</li>
				
			</c:forEach>
		</ul>

	</c:if>
	
</body>
</html>