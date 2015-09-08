package fr.demos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.demos.dao.ProduitDao;
import fr.demos.model.Criteres;
import fr.demos.model.Panier;
import fr.demos.model.Produit;
@Controller
@SessionAttributes({"criteres","listProduit","panier"})
public class ProduitController {
	
	@Autowired
	private ProduitDao daoProduit;

	// Etape 1
	// --> passer par spring: get en URL; constituer le modèles de la classe
	// criteres. Dans la jsp, l'objet criters associé au formulaire du
	// listeUser.jsp ---> stocké automatiquement dans l'objet modèle

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String affiche(ModelMap model) {
	    model.addAttribute("criteres", new Criteres());
		model.addAttribute("listProduit", new ArrayList<Produit>());
		model.addAttribute("message", "");
		model.addAttribute("panier", new Panier());
		return "listeProduit";
	}

	// Etape 2: programme de recherche
	// reste dans le meme url car action non définit dans le listeProduit.jsp
	// criteres est rempli, non vide
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String recherche(@ModelAttribute("criteres") Criteres c,
			@ModelAttribute("Produit") Produit produit,
			@ModelAttribute("listProduit") ArrayList<Produit> lProduit) {

		System.out.println(c.getCriteres());

		try {

			lProduit.clear();
			List<Produit> produits = daoProduit.rechercheTous();
			lProduit.addAll(produits);

			for (Produit lp : lProduit) {

			System.out.println("controller" + lp.getConcepteur());
			}

			return "listeProduit";
		} catch (Exception e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
			return "listeProduit";
		}
	}

	// méthode permettant de faire l'ajout du produit sélectionné dans le panier
	// méthode en GET car on utilise des liens <a href> pour récupérer la
	// référence du produit sélectionné
	
	@RequestMapping(value = "/monPanier", method = RequestMethod.GET)
	public String ajoutePanier(

			@ModelAttribute("message") String message,
			@ModelAttribute("panier") Panier panier,
			@RequestParam("ref") String refDuProduitSelectionne,
			@RequestParam("produit") Produit p
	// evolution dans la V2 pour plus
	/* ,@RequestParam("ref2") int quantite */) {

		
		ControllerUtil util = new ControllerUtil();
		util.ajoutePanier(message, panier, refDuProduitSelectionne, daoProduit, p);
		
		
		/*
		
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
		*/
		return "listeProduit";

		
	}
	
}
