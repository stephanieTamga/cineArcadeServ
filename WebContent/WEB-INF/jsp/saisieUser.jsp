<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Saisie User
<form:form method="POST" commandName="person">
<table>
<tr>
<td>nom:</td>
<td><form:input path="nom" /></td>
<td><form:errors path="nom"/></td>
</tr>
<tr>
<td>prenom :</td>
<td><form:input path="prenom" /></td>
<td><form:errors path="prenom"/></td>
</tr>
<tr>
<td>Adresse de Livraison :</td>
<td><form:input path="adresseLivraison" /></td>
<td><form:errors path="adresseLivraison"/></td>
</tr>
<td>Adresse de Facturation :</td>
<td><form:input path="adresseFacturation" /></td>
			<td><form:errors path="adresseFacturation" /></td>
			</tr>
<tr>
<td>Email :</td>
<td><form:input path="email" /></td>
<td><form:errors path="email"/></td>
</tr>
<tr>
<td>Password :</td>
<td><form:input path="password" /></td>
<td><form:errors path="password"/></td>
</tr>
<tr>
<td>Téléphone :</td>
<td><form:input path="telephone" /></td>
<td><form:errors path="telephone"/></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="valider"></td>
</tr>
</table>
</form:form>

</body>
</html>