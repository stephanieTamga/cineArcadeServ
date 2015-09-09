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
import org.springframework.web.servlet.ModelAndView;

import fr.demos.dao.ProduitDao;
import fr.demos.model.Criteres;
import fr.demos.model.Panier;
import fr.demos.model.Produit;

@Controller
@SessionAttributes({ "criteres", "listProduit", "panier" })
public class IndexController {

	@Autowired
	private ProduitDao daoProduit;

	// Etape 1
	// --> passer par spring: get en URL; constituer le modèles de la classe
	// criteres. Dans la jsp, l'objet criters associé au formulaire du
	// listeUser.jsp ---> stocké automatiquement dans l'objet modèle

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String affiche(ModelMap model) {
		model.addAttribute("produit", new Produit());
		model.addAttribute("criteres", new Criteres());
		model.addAttribute("listProduit", new ArrayList<Produit>());
		model.addAttribute("message", "");
		model.addAttribute("panier", new Panier());
		return "index";
	}

	// Etape 2: programme de recherche
	// reste dans le meme url car action non définit dans le listeProduit.jsp
	// criteres est rempli, non vide
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String recherche(@ModelAttribute("criteres") Criteres c,
			@ModelAttribute("produit") Produit produit,
			@ModelAttribute("listProduit") ArrayList<Produit> lProduit) {

		System.out.println(c.getCriteres());

		try {

			lProduit.clear();
			List<Produit> produits = daoProduit.rechercheTous();
			lProduit.addAll(produits);

			for (Produit lp : lProduit) {

				System.out.println("controller" + lp.getConcepteur());
			}

			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			return "index";
		}
	}

	//
	// // méthode permettant de faire l'ajout du produit sélectionné dans le
	// panier
	// // méthode en GET car on utilise des liens <a href> pour récupérer la
	// // référence du produit sélectionné
	//
	@RequestMapping(value = "/ajouterPanier", method = RequestMethod.GET)
	public String ajoutePanier(

	@ModelAttribute("message") String message,
			@ModelAttribute("panier") Panier panier,
			@RequestParam("ref") String refDuProduitSelectionne
	// evolution dans la V2 pour plus
	/* ,@RequestParam("ref2") int quantite */) {

		ControllerUtil util = new ControllerUtil();
		

		// récupération du produit sélectionné dans la BDD grâce
		// à la référence passée en requête
		util.ajoutePanier(message, panier, refDuProduitSelectionne, daoProduit);
			
		
		// penser à mettre un ${message} pour afficher le message en cas
		// d'erreur

		return "index";

	}
	
	@RequestMapping(value="/allerSurLeZoomProduit", method= RequestMethod.GET)
	public String zoomSurleProduit(@ModelAttribute("message") String messageErreurProduitZoom){
		
		//@ModelAttribute("produit") Produit produit,
		//@RequestParam("ref") String refDuProduitSelectionne,
		//System.out.println("la reference du produit recup depuis l'index dans IndexController est: "+refDuProduitSelectionne);
		/*try {
			produit= daoProduit.rechercherparReference(refDuProduitSelectionne);			
		} catch (Exception e) {			
			messageErreurProduitZoom = "Le produit n'a pas été récupéré depuis la liste car"+e.getMessage();
			e.printStackTrace();
			return "index";
		}*/			
		
		// redirection vers le ZoomController
		return "forward:/zoomArticle.htm";
		//+produit.getReferenceProduit()
	}

}
