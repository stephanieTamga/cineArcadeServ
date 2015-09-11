package fr.demos.controller;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import antlr.collections.List;
import fr.demos.dao.ProduitDao;
import fr.demos.model.Criteres;
import fr.demos.model.LignePanier;
import fr.demos.model.Panier;
import fr.demos.model.Produit;

@Controller
@SessionAttributes("panier")
public class PanierController {

	@Autowired
	ProduitDao dao;

	@Autowired
	private ProduitDao daoProduit;

	@RequestMapping(value = "/pan", method = RequestMethod.GET)
	public String afficher(ModelMap model) {

		return "panier";
	}

	@RequestMapping(value = "/changementQuantite", method = RequestMethod.GET)
	public @ResponseBody String changementQuantite(
			@RequestParam("qte") int quantite,
			@RequestParam("ref") String reference,
			@ModelAttribute("panier") Panier panier) {
		// lancer la modifiction de quantite du panier

		// reccuperer prixtotal nb et prix total + concatener
		// remettre dans le bonnes cases -> value= pr la realimanter -> methdoe
		// de trairement de chaine de caractere
		
		String result = panier.modificationQuantite(reference, quantite);
			

		return result;
		

	}

	@RequestMapping(value = "/supprimerLigne", method = RequestMethod.GET)
	public String supprimerLigne(

			@ModelAttribute("message") String message,
			@ModelAttribute("panier") Panier panier,
			@RequestParam("ref") String refDuProduitSelectionne
	// evolution dans la V2 pour plus
	/* ,@RequestParam("ref2") int quantite */) {
		try {
			ControllerUtil util = new ControllerUtil();

			// récupération du produit sélectionné dans la BDD grâce
			// à la référence passée en requête
			util.supprimerLigne(message, panier, refDuProduitSelectionne,
					daoProduit);

			// penser à mettre un ${message} pour afficher le message en cas
			// d'erreur

			return "panier";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "panier";
		}
	}

	@RequestMapping(value = "/cleanPanier", method = RequestMethod.GET)
	public String cleanPanier(

	@ModelAttribute("message") String message,
			@ModelAttribute("panier") Panier panier

	// evolution dans la V2 pour plus
	/* ,@RequestParam("ref2") int quantite */) {
		try {
			ControllerUtil util = new ControllerUtil();

			// récupération du produit sélectionné dans la BDD grâce
			// à la référence passée en requête
			util.cleanPanier(message, panier);
			panier.clearPanier();

			return "panierVidee";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "panierVidee";
		}

	}

}