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
@SessionAttributes({ "criteres", "listProduit", "panier" })
public class IndexController {

	@Autowired
	private ProduitDao daoProduit;

	// Etape 1
	// --> passer par spring: get en URL; constituer le mod�les de la classe
	// criteres. Dans la jsp, l'objet criters associ� au formulaire du
	// listeUser.jsp ---> stock� automatiquement dans l'objet mod�le

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String afficheInitial(ModelMap model) {
		model.addAttribute("produit", new Produit());
		model.addAttribute("criteres", new Criteres());
		model.addAttribute("listProduit", new ArrayList<Produit>());
		model.addAttribute("message", "");
		model.addAttribute("panier", new Panier());
		return "index";
	}

	@RequestMapping(value = "/indexRetour", method = RequestMethod.GET)
	public String afficheEncours() {

		return "index";
	}

	// Etape 2: programme de recherche
	// reste dans le meme url car action non d�finit dans le listeProduit.jsp
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
	// // m�thode permettant de faire l'ajout du produit s�lectionn� dans le
	// panier
	// // m�thode en GET car on utilise des liens <a href> pour r�cup�rer la
	// // r�f�rence du produit s�lectionn�

	@RequestMapping(value = "/ajouterPanier", method = RequestMethod.GET)
	public String ajoutePanier(

	@ModelAttribute("message") String message,
			@ModelAttribute("panier") Panier panier,
			@RequestParam("ref") String refDuProduitSelectionne
	// evolution dans la V2 pour plus
	/* ,@RequestParam("ref2") int quantite */) {
		try {
			ControllerUtil util = new ControllerUtil();

			// r�cup�ration du produit s�lectionn� dans la BDD gr�ce
			// � la r�f�rence pass�e en requ�te
			util.ajoutePanier(message, panier, refDuProduitSelectionne,
					daoProduit);

			// penser � mettre un ${message} pour afficher le message en cas
			// d'erreur

			return "index";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "index";
		}
	}

	@RequestMapping(value="/allerSurLeZoomProduit", method= RequestMethod.GET)
	public String zoomSurleProduit(@ModelAttribute("message") String messageErreurProduitZoom){
		
		//@ModelAttribute("produit") Produit produit,
		//@RequestParam("ref") String refDuProduitSelectionne,
		//System.out.println("la reference du produit recup depuis l'index dans IndexController est: "+refDuProduitSelectionne);
		/*try {
			produit= daoProduit.rechercherparReference(refDuProduitSelectionne);			
		} catch (Exception e) {			
			messageErreurProduitZoom = "Le produit n'a pas �t� r�cup�r� depuis la liste car"+e.getMessage();
			e.printStackTrace();
			return "index";
		}*/			
		
		// redirection vers le ZoomController
		return "forward:/zoomArticle.htm";
		//+produit.getReferenceProduit()
	}



}
