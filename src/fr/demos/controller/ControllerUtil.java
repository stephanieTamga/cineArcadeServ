package fr.demos.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import fr.demos.model.Panier;
import fr.demos.model.Produit;

public class ControllerUtil {


	 String message;
			Panier panier,
		 String refDuProduitSelectionne,
		 ProduitDao daoProduit;
	 
	try {

		Produit produit = dao
				.rechercherparReference(refDuProduitSelectionne);
		// actuellement la quantit� est 1
		int quantite = 1;
		panier.ajouterPanier(refDuProduitSelectionne, produit, quantite);
	} catch (Exception e) {
		System.out.println("le produit n'a pas �t� r�cup�r� car"
				+ e.getMessage());
		// message qui sera renvoy� sur la page d'erreur
		message = "le produit n'a pas �t� r�cup�r� car" + e.getMessage();
	}

	// penser � mettre un ${message} pour afficher le message en cas
	// d'erreur
	return "retour sur la page de s�lection";

}
}
