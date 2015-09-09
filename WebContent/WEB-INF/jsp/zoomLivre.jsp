<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- la page affichera le nom du livre dans le cadre supérieur du navigateur -->
<title>Zoom sur le livre: ${produit.designation}</title>
<!-- voir si possibilité d'afficher le nom du livre dans le titre de la page -->
</head>
<body>


<c:out value="${produit}"></c:out><br/>
------
<c:out value="${produit.getDesignation()}"></c:out>
------



<!-- 
	<!-- le livre sélectionné pour plus de détails doit être renvoyé par le controlleur (IndexController)  
	qui envoie sur cette page, afin de pouvoir en afficher les détails et caractéristiques	 -->

	<!-- Nous utilisons des id dans chaque balise afin de pouvoir mettre en place le responsive web design par la suite -->


<span id="encadreImageDuProduit"> <!-- <img alt="image Du Produit" src="${livre.image}" id="">  -->
	</span>
<h2 id="titrePageZoom">Détails sur le livre</h2>
	

	<!-- dans le fichoer css, faire un affichage des éléments sous faire de bulletPoint -->
	<div id="encadreDetailsDuProduit"><!-- nous utilisons une balise div car ces éléments constituent un bloc -->
		
		<p id="designationDuProduit">${produit.designation}</p>
		<br /><!-- affiche le nom du livre -->
		<label>Auteur:</label>
		<p id="concepteurDuProduit">${produit.concepteur}</p><br /><!-- affiche le nom du concepteur du livre -->
		<label>Editeur:</label>
		<p id="fabricantDuProduit">${livre.fabricant}</p><br /><!-- affiche le nom du fabricant du livre -->
		<label>ISBN:</label>		
		<p id="numeroIsbn">${livre.numeroIsbn}</p>
		<br /><!-- affiche le numero ISBN du livre -->
		<label>Informations supplémentaires:</label>
		<p id="informationSupplémentaire">${livre.caracteristiques}</p>
		</div>

	<div id="encadreDescriptionDuProduit">
		<!-- la balise div nous permet de déclarer que ces éléments constituent un bloc -->
		<p id="descriptionDuProduit">${livre.description}</p>
		<br />
		<!-- affiche la description détaillée du livre sur lequel on zoomé -->
	</div>


	<a id="lienAjoutPanier"
		href="ajoutePanierDepuisZoom.htm?ref=${livre.referenceProduit}">
		Ajouter au panier</a><br/>
	<!-- ajoute le livre zoomé au panier grâce la référence du livre envoyée en paramètre de la requête -->



<a href="#encadreImageDuProduit">Revenir en haut de la page</a>
	<!-- mettre un bouton pour retourner en haut de la page -->


 -->

</body>
</html>