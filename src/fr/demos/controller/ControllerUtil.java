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

				// r�cup�ration du produit s�lectionn� dans la BDD gr�ce
				// � la r�f�rence pass�e en requ�te
				try {

					Produit produit = daoProduit
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
				

			}

}
