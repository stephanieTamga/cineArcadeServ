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

<h1>  Votre Panier contient </h1>
<a>${panier.listelignePanier}</a>





<!--  <table border="1"> -->
<!--             <thead> -->
<!--                 <tr> -->
<!--                     <th>Votre panier</th> -->
<!--                     <th>Prix</th> -->
<!--                     <th>Quantité</th> -->
<!--                 </tr> -->
<!--             </thead> -->
<!--             <tbody> -->
<%--                 <c:forEach items="${listeLignePanier}" var="produit"> --%>
<!--                     <tr> -->
<%--                         <td><c:out value="${produit.id}"/></td> --%>
<%--                         <td><c:out value="${produit.libelle}"/></td> --%>
<%--                         <td><c:out value="${produit.quantite}"/></td> --%>
<!--                     </tr> -->
<%--                 </c:forEach> --%>
<!--             </tbody> -->
<!--         </table> -->

	<form>
  <a href="indexRetour.htm" >Retour</a>
</form>
<form>
  <a href="cleanPanier.htm" >Vider le panier</a>
</form>


</body>

</html>