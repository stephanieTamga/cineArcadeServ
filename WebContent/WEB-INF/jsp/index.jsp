<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CinéArcade Logithèque spécialisée</title>
</head>

<body onload="init()">
	<img src="" id="imageId" height="100px" width="200px" />
	<br />
	<input type="button" value="stop diaporama" onclick="stop()" />

</body>
<body>
	<table border="1">
		<tr>
			<td colspan="3" width="5"><img name="photo" id="photo"
				src="Images/Book.jpg" align="top" width="100">

				<h1>
					<b>CINEARCADE</b>
				</h1></td>
			<td>Recherche par Critères</td>
			<form:form method="POST" action="index.htm" commandName="criteres">
				<td><form:input path="criteres" /></td>
				<td><form:errors path="criteres" /></td>
				<td><input type="submit" value="rechercher"></td>
			</form:form>
			<td><a href="createUser.htm">Mon Compte</a></td>
			<td><a href="pan.htm">Mon Panier</a></td>
		</tr>
		<tr>
			<td colspan="3" width="20"><h2>Catalogue</h2></td>
			<td colspan="4" width="20" align="left">
				<h2>Notre Sélection</h2>
				
				<br /> <script type="text/javascript">
					var image;
					var tabImages;
					var i = 0;
					var interval1;
					function init() {
						image = document.getElementById("imageId");
						tabImages = new Array(3);
						tabImages[0] = new Image();
						tabImages[1] = new Image();
						tabImages[2] = new Image();
						tabImages[0].src = "Images/Abbas.jpg";
						tabImages[1].src = "Images/EconomieDuCinema.jpg";
						tabImages[2].src = "Images/FantastiqueFrancais.jpg";
						interval1 = setInterval(changementImage, 2000);
					}

					function changementImage() {
						image.src = tabImages[i].src;
						i++;
						if (i == tabImages.length) {
							i = 0;
						}
					}

					function stop() {
						clearInterval(interval1);
					}
				</script> <c:if test="${not empty listProduit}">

					<ul>
						<c:forEach var="listProduit" items="${listProduit}">
							<li>${listProduit.concepteur}<a href="allerSurLeZoomProduit.htm?ref=${listProduit.referenceProduit}&categorie=${listProduit.categorie}">détails</a><a
								href="ajouterPanier.htm?ref=${listProduit.referenceProduit}">
									Ajouter au panier</a></li>

						</c:forEach>
					</ul>

				</c:if>
			</td>
		</tr>

	</table><br/>
	<p><b>${message}</b></p><!-- message eb cas de non r&cupération du produit sur lequel on a voulu zoomé -->
	
	<%-- 	<form:form method="POST" commandName="criteres"> --%>
	<!-- 		<table> -->
	<!-- 			<tr> -->
	<!-- 				<td>criteres:</td> -->
	<%-- 				<td><form:input path="criteres" /></td> --%>
	<%-- 				<td><form:errors path="criteres" /></td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td colspan="2"><input type="submit" value="rechercher"></td> -->
	<!-- 			</tr> -->
	<!-- 		</table> -->
	<%-- 	</form:form> --%>
	<!-- 	<br /> -->
	<!-- 	<h2>Liste des produits</h2> -->

	<%-- 	<c:if test="${not empty listProduit}"> --%>

	<!-- 		<ul> -->
	<%-- 			<c:forEach var="listProduit" items="${listProduit}"> --%>
	<%-- 				<li>${listProduit.concepteur}</li> --%>

	<%-- 			</c:forEach> --%>
	<!-- 		</ul> -->

	<%-- 	</c:if> --%>
	<!-- </body> -->
</html>