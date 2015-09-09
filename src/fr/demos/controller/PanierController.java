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
	public String afficher() {
	
	return "lepanier";
}



	@RequestMapping(value = "/cleanPanier", method = RequestMethod.GET)
	public String cleanPanier(

	@ModelAttribute("message") String message,
			@ModelAttribute("panier") Panier panier

	// evolution dans la V2 pour plus
	/* ,@RequestParam("ref2") int quantite */) {
		try {
			ControllerUtil util = new ControllerUtil();

			// r�cup�ration du produit s�lectionn� dans la BDD gr�ce
			// � la r�f�rence pass�e en requ�te
			util.cleanPanier(message, panier);
			panier.clearPanier();

			return "lepanier";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "lepanier";
		}

	}
}