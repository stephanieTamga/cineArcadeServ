package fr.demos.controller;

import java.util.List;

import fr.demos.dao.ProduitDao;
import fr.demos.model.Panier;
import fr.demos.model.Produit;

public class ControllerUtil {

	public void ajoutePanier(

//<<<<<<< HEAD
//	String message, Panier panier, String refDuProduitSelectionne,
//			ProduitDao daoProduit, Produit p
//	// evolution dans la V2 pour plus
//	/* ,@RequestParam("ref2") int quantite */) {
//
//		// r�cup�ration du produit s�lectionn� dans la BDD gr�ce
//		// � la r�f�rence pass�e en requ�te
//		try {
//
//			Produit produit = daoProduit.rechercherparReference(refDuProduitSelectionne, p);
//
//			// actuellement la quantit� est 1
//
//			int quantite = 1;
//			panier.ajouterPanier(refDuProduitSelectionne, produit, quantite);
//			System.out
//					.println("  methode ajoutePanier: la ref du produit reccupere: "
//							+ refDuProduitSelectionne);
//			System.out
//					.println("  methode ajoutePanier: la  ref du produit reccupere: "
//							+ p.getReferenceProduit());
//
//
//
//		} catch (Exception e) {
//			System.out.println("le produit n'a pas �t� r�cup�r� car"
//					+ e.getMessage());
//			// message qui sera renvoy� sur la page d'erreur
//			message = "le produit n'a pas �t� r�cup�r� car" + e.getMessage();
//		}
//
//		// penser � mettre un ${message} pour afficher le message en cas
//		// d'erreur
//=======
			String message,
			Panier panier,
			String refDuProduitSelectionne,
			ProduitDao produitDao
			
			// evolution dans la V2 pour plus
			/* ,@RequestParam("ref2") int quantite */) {

				// r�cup�ration du produit s�lectionn� dans la BDD gr�ce
				// � la r�f�rence pass�e en requ�te
				try {

//					Produit produit = daoProduit
//							.rechercherparReference(refDuProduitSelectionne);
					Produit produit = produitDao
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

