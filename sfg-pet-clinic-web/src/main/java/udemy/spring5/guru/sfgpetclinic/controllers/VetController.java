package udemy.spring5.guru.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import udemy.spring5.guru.sfgpetclinic.services.VetService;

@Controller
@RequestMapping({"/vets", "/vets.html"})
public class VetController {

	private final VetService verService;

	public VetController(VetService verService) {
		super();
		this.verService = verService;
	}

	@RequestMapping({"", "/", "/index", "/index.html"})
	public String listVets(Model model) {
		
		String nomAttributDansTemplateThymeleaf = "listeVeterinaires";
		model.addAttribute(nomAttributDansTemplateThymeleaf, verService.findAll());
		
		String nomRepertoireThymeleaf = "vets";
		String nomTemplateThymeleaf = "index";
		String modelPourRetour = nomRepertoireThymeleaf + "/" + nomTemplateThymeleaf;
		
		return modelPourRetour;
	}
}
