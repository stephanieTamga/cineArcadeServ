package fr.demos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.demos.dao.ProduitDao;
import fr.demos.model.Panier;
import fr.demos.model.Produit;

@Controller
@SessionAttributes("panier")
public class ZoomController {

	@Autowired
	ProduitDao dao;	
	
	@RequestMapping(value = "/zoomArticle", method = RequestMethod.GET)
	public String affiche(ModelMap model, 
			@RequestParam("ref") String refDuProduitSelectionne,
			/*@ModelAttribute("produit") Produit produit,*/  
			@ModelAttribute("message") String msg) {		
		model.addAttribute("messageConfirmationAjoutPanier", "");
		model.addAttribute("produit", new Produit());
		
		Produit produit= (Produit) model.get("produit");
						
		try {
			System.out.println("la réf récupéré depuis la requête est: "+refDuProduitSelectionne);
			//récupération du produit en BDD grâce à la référence mise dans la requête
			produit = dao.rechercherparReference(refDuProduitSelectionne);			 
			System.out.println("la ref du produit récupéré depuis la BDD est: "+ produit.getReferenceProduit());
			System.out.println("le produit récupéré a pour titre: "+produit.getDesignation());
			System.out.println("le produit récupéré en BDD est un "+produit.getCategorie());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erreur de recup produit:"+e.getMessage());	
			System.out.println("la ref en CATCH de la requête récupéré est: "+refDuProduitSelectionne);
			//message renvoyé sur la page index en cas d'erreur d'éxécution de l'affichage de la page Zoom
			msg= "il y a eu un soucis avec la récupération du produit sélectionné car: "+e.getMessage();
			return "index";
		}
		
		System.out.println("la ref du produit récupéré depuis la BDD EN DEHORS DU TRY est: "+ produit.getReferenceProduit());
		System.out.println("EN DEHORS DU TRY le produit récupéré a pour titre: "+produit.getDesignation());
		System.out.println("EN DEHORS DU TRY le produit récupéré en BDD est un "+produit.getCategorie());
		return "zoomLivre";
	}
	
	
	//il nous faut faire des méthodes permettant d'effectuer des actions sur la page de zoom
	
	//pour ajouter l'article dans le panier depuis la page de zoom sur l'article
	@RequestMapping(value = "/ajoutePanierDepuisZoom", method = RequestMethod.GET)
	public String ajoutePanierDepuisZoom(
			@ModelAttribute("messageConfirmationAjoutPanier") String message,
			@ModelAttribute("panier") Panier panier,
			@RequestParam("ref") String refDuProduitSelectionne
	// evolution dans la V2 pour permettre d'ajouter plusieurs exemplaires du même article
	/* ,@RequestParam("ref2") int quantite */) {		
		ControllerUtil util = new ControllerUtil();
		util.ajoutePanier(message, panier, refDuProduitSelectionne, dao);
		//message de confirmation de l'ajout de(s) article(s) à l'attention des utilisateurs
		message = "Félicitations, l'article a bien été ajouté au panier!";
		/*mettre une expression de langage ${messageConfirmationAjout} afin de pouvoir afficher 
		 * un message de confirmation de l'ajout au panier sur la page principale*/
		return "listeProduit";				
	}
	
	
	
	
	
	
	
	

}
