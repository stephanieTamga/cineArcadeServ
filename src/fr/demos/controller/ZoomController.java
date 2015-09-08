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

@Controller
@SessionAttributes("panier")
public class ZoomController {

	@Autowired
	ProduitDao dao;	
	
	//il nous faut faire des méthodes permettant d'effectuer des actions sur la page de zoom
	
	//pour ajouter l'article dans le panier depuis la page de zoom sur l'article
	@RequestMapping(value = "/ajoutePanierDepuisZoom", method = RequestMethod.GET)
	public String ajoutePanierDepuisZoom(
			@ModelAttribute("messageConfirmationAjout") String message,
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
