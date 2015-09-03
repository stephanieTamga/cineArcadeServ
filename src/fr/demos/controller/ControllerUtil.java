package fr.demos.controller;

import fr.demos.dao.ProduitDao;
import fr.demos.model.Panier;
import fr.demos.model.Produit;

public class ControllerUtil {
	
	
	public void ajoutePanier(

			String message,
			Panier panier,
			String refDuProduitSelectionne,
			ProduitDao daoProduit
			// evolution dans la V2 pour plus
			/* ,@RequestParam("ref2") int quantite */) {

				// récupération du produit sélectionné dans la BDD grâce
				// à la référence passée en requête
				try {

					Produit produit = daoProduit
							.rechercherparReference(refDuProduitSelectionne);
					// actuellement la quantité est 1
					int quantite = 1;
					panier.ajouterPanier(refDuProduitSelectionne, produit, quantite);
				} catch (Exception e) {
					System.out.println("le produit n'a pas été récupéré car"
							+ e.getMessage());
					// message qui sera renvoyé sur la page d'erreur
					message = "le produit n'a pas été récupéré car" + e.getMessage();
				}

				// penser à mettre un ${message} pour afficher le message en cas
				// d'erreur
				

			}

}
