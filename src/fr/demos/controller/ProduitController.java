package fr.demos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fr.demos.dao.ProduitDao;
import fr.demos.model.Criteres;
import fr.demos.model.Produit;
@Controller
public class ProduitController {
	
	@Autowired
	private ProduitDao DaoProduit;

	// Etape 1
	// --> passer par spring: get en URL; constituer le mod�les de la classe
	// criteres. Dans la jsp, l'objet criters associ� au formulaire du
	// listeUser.jsp ---> stock� automatiquement dans l'objet mod�le

	@RequestMapping(value = "/rechercheProducts", method = RequestMethod.GET)
	public String affiche(ModelMap model) {
		model.addAttribute("criteres", new Criteres());
		model.addAttribute("listProduit", new ArrayList<Produit>());
		return "listeProduit";
	}

	// Etape 2: programme de recherche
	// reste dans le meme url car action non d�finit dans le listeProduit.jsp
	// criteres est rempli, non vide

	@RequestMapping(value = "/rechercheProducts", method = RequestMethod.POST)
	public String recherche(@ModelAttribute("criteres") Criteres c,
			@ModelAttribute("Produit") Produit produit,
			@ModelAttribute("listProduit") ArrayList<Produit> lProduit) {

		System.out.println(c.getCriteres());

		try {

			List<Produit> produits = DaoProduit.rechercheTous(produit);
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
	
}
