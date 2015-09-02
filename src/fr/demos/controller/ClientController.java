package fr.demos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.demos.dao.ClientDao;
import fr.demos.model.Client;

@Controller
public class ClientController {
	// on initialise pas l'objet dao, car on va l'injecter
	@Autowired
	private ClientDao dao;
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public String affiche(ModelMap model) {
		model.addAttribute("person", new Client());
		return "saisieUser";
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String inserer(@ModelAttribute("person") Client user,
			BindingResult result) {

		if (result.hasErrors()) {
			return "saisieUser";
		} else {

			// enregistrement en base
			try {
				dao.ajout(user);
				System.out.println("nom" + user.getNom() + "prenom"
						+ user.getPrenom() + "adresseFacturation" + user.getAdresseFacturation()
						+ "email" + user.getEmail() + "password"
						+ user.getPassword()
						+ "telephone" + user.getTelephone()
						+"adresseLivraison" + user.getAdresseLivraison());
				return "success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "saisieUser";
			}
		}
	}
}
