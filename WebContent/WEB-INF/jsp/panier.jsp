<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%--  ${String refProduit = request.getParameter("ref"} --%>

	<h1>Votre Panier contient ${panier.nbrProduit}</h1>


	<table border="1">
		<thead>
			<tr>
				<th>Votre panier</th>
				<th>Description</th>
				<th>Categorie</th>
				<th>Quantité</th>
				<th>PrixHT</th>
				<th>TVA</th>
				<th>PrixTTC</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${panier.listelignePanier}" var="ligne">
				<tr>
					<td><c:out value="${ligne.produit.designation}" /></td>
					<td><c:out value="${ligne.produit.description}" /></td>
					<td><c:out value="${ligne.produit.categorie}" /></td>
					<td>
						<form>
							<select name="quantite" size="1">
								<option selected="selected">${ligne.quantite}
								<option>1
								<option>2
								<option>3
								<option>4
								<option>5
								<option>6
							</select>
							<%--                         <c:out value="${ligne.quantite}"/>  --%>
						</form>
					</td>
					<td><c:out value="${ligne.produit.prixProduit.prixHT}" /></td>
					<td><c:out
							value="${ligne.produit.prixProduit.tauxTaxeProduit}" /></td>
					<td><c:out value="${ligne.prixttcLigne}" /></td>
					<td>
					
<%-- 					<a href="supprimerLigne.htm?ref=${ligne.produit.reference }"> </a> --%>
					
						<form action="supprimerLigne.htm">
							<input type="submit" value="Supprimer">
						</form> 
						
						
						<%--                             <c:url value="pan.htm" var="url"> --%>

						<%--                              <c:param name="" value="${ligne.produit.referenceProduit}"/> --%>
						<%--                             </c:url> --%> <%--                             <a href="${url}"> --%>
						<!--                                Supprimer --> <!--                             </a> -->
					</td>
				</tr>
			</c:forEach>
									<form action="indexRetour.htm">
							<input type="submit" value="Retour à la page d'accueil">
						</form>
						<form action="cleanPanier.htm">
							<input type="submit" value="Vider le panier">
						</form>
		</tbody>
		<tfoot>
			<td>${panier.sommeTotal}</td>
		</tfoot>
	</table>

	<form action="index.htm">
		<input type="submit" value="Continuer vos achats ">
	</form>
</body>
</html>