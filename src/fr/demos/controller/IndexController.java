package fr.demos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class IndexController {
	
	@RequestMapping(value = "/pageAccueil", method = RequestMethod.GET)
	public String affiche(ModelMap model) {
		return "index";
	}
}
