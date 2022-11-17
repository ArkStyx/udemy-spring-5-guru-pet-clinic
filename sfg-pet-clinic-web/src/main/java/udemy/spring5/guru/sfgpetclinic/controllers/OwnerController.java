package udemy.spring5.guru.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import udemy.spring5.guru.sfgpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}

	@RequestMapping({"", "/", "/index", "/index.html"})
	public String listOwners(Model model) {
		
		String nomAttributDansTemplateThymeleaf = "listeProprietaires";
		model.addAttribute(nomAttributDansTemplateThymeleaf, ownerService.findAll());
		
		String nomRepertoireThymeleaf = "owners";
		String nomTemplateThymeleaf = "index";
		String modelPourRetour = nomRepertoireThymeleaf + "/" + nomTemplateThymeleaf;
		
		return modelPourRetour;
	}
	
	@RequestMapping("/find")
	public String findOwners() {
		return "not-implemented-yet";
	}
	
}
