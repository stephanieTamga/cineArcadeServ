<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- la page affichera le nom du livre dans le cadre sup�rieur du navigateur -->
<title>Zoom sur le livre: ${livre.designation}</title>
<!-- voir si possibilit� d'afficher le nom du livre dans le titre de la page -->
</head>
<body>
	<!-- Nous utilisons des id dans chaque balise afin de pouvoir mettre en place le responsive web design par la suite -->

<span id="encadreImageDuProduit"> <!-- <img alt="image Du Produit" src="${livre.image}" id="">  -->
	</span>
<h1 id="titrePageZoom">D�tails sur le livre</h1>	

	<!-- dans le fichoer css, faire un affichage des �l�ments sous faire de bulletPoint -->
	<div id="encadreDetailsDuProduit"><!-- nous utilisons une balise div car ces �l�ments constituent un bloc -->
		
		<label><b>Titre: </b></label>${livre.designation}
		<br /><!-- affiche le nom du livre -->
		<label><b>Auteur: </b></label>${livre.concepteur}<br /><!-- affiche le nom du concepteur du livre -->
		<label><b>Editeur: </b></label>${livre.fabricant}<br /><!-- affiche le nom du fabricant du livre -->
		<label><b>ISBN: </b></label>${livre.numeroIsbn}<br/><!-- affiche le numero ISBN du livre -->
		<label><b>Informations suppl�mentaires:</b></label><br/>
		<br/>${livre.caracteristiques}
		</div></p>

	<div id="encadreDescriptionDuProduit"><!-- la balise div nous permet de d�clarer que ces �l�ments constituent un bloc -->
	<label><b>Description:  </b></label><br/>
		<p id="descriptionDuProduit">${livre.description}</p>
		<br />
		<!-- affiche la description d�taill�e du livre sur lequel on zoom� -->
	</div>


	<!--  <a id="lienAjoutPanier"	href="ajoutePanierDepuisZoom.htm?ref=${livre.referenceProduit}">
		Ajouter au panier</a><br/>-->
	<!-- ajoute le livre zoom� au panier gr�ce la r�f�rence du livre envoy�e en param�tre de la requ�te -->

<button onclick="document.location='ajoutePanierDepuisZoom.htm?ref=${livre.referenceProduit}'">Ajouter au panier</button><br/>
<button onclick="document.location='indexRetour.htm'">Retour sur la recherche</button><br/>
<button onclick="document.location='#encadreImageDuProduit'">Revenir en haut de la page</button>

<!-- <a href="#encadreImageDuProduit">Revenir en haut de la page</a> -->
	<!-- mettre un bouton pour retourner en haut de la page -->

</body>
</html>