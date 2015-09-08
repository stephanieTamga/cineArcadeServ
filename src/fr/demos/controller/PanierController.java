package fr.demos.controller;

import java.util.ArrayList;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import antlr.collections.List;
import fr.demos.dao.ProduitDao;
import fr.demos.model.LignePanier;
import fr.demos.model.Panier;
import fr.demos.model.Produit;

@Controller
@SessionAttributes("panier")
public class PanierController {

	@Autowired
	ProduitDao dao;


@RequestMapping(value = "/pan", method = RequestMethod.GET)
public String afficher(){
	
	return "lepanier";
}

//	//
//	// // m�thode permettant de faire l'ajout du produit s�lectionn� dans le
//	// panier
//	// // m�thode en GET car on utilise des liens <a href> pour r�cup�rer la
//	// // r�f�rence du produit s�lectionn�
//	//@RequestMapping(value = "/basket", method = RequestMethod.GET)
//	//public String ajoutePanier(
//
//	//@ModelAttribute("message") String message,
//		//	@ModelAttribute("panier") Panier panier,
//		//	@RequestParam("ref") String refDuProduitSelectionne

//	@RequestMapping(value = "/pan", method = RequestMethod.GET)
//	public String afficher(@RequestParam("ref") String ref, ModelMap modelMap){
//		modelMap.addAttribute("listeProduit", ref);
//		
//		return "panier";
//	}

//	// m�thode permettant de faire l'ajout du produit s�lectionn� dans le panier
//	// m�thode en GET car on utilise des liens <a href> pour r�cup�rer la
//	// r�f�rence du produit s�lectionn�
//	@RequestMapping(value = "/monPanier", method = RequestMethod.GET)
//	public String ajoutePanier(
//
//	@ModelAttribute("message") String message,
//			@ModelAttribute("panier") Panier panier,
//			@RequestParam("ref") String refDuProduitSelectionne
//
//	// evolution dans la V2 pour plus
//	/* ,@RequestParam("ref2") int quantite */) {
////
////		// r�cup�ration du produit s�lectionn� dans la BDD gr�ce
////		// � la r�f�rence pass�e en requ�te
////		try {
////
////			Produit produit = dao
////					.rechercherparReference(refDuProduitSelectionne);
////			// actuellement la quantit� est 1
////			int quantite = 1;
////			panier.ajouterPanier(refDuProduitSelectionne, produit, quantite);
////		} catch (Exception e) {
////			System.out.println("le produit n'a pas �t� r�cup�r� car"
////					+ e.getMessage());
////			// message qui sera renvoy� sur la page d'erreur
////			message = "le produit n'a pas �t� r�cup�r� car" + e.getMessage();
////		}
////
////		// penser � mettre un ${message} pour afficher le message en cas
////		// d'erreur
////		return "panier";
//
//	}

}
