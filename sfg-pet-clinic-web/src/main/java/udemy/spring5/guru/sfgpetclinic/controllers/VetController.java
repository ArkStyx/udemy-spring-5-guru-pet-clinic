package udemy.spring5.guru.sfgpetclinic.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import udemy.spring5.guru.sfgpetclinic.models.Vet;
import udemy.spring5.guru.sfgpetclinic.services.VetService;

@Controller
public class VetController {

	private final VetService vetService;

	public VetController(VetService vetService) {
		super();
		this.vetService = vetService;
	}

	@RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
	public String listVets(Model model) {
		
		String nomAttributDansTemplateThymeleaf = "listeVeterinaires";
		model.addAttribute(nomAttributDansTemplateThymeleaf, vetService.findAll());
		
		String nomRepertoireThymeleaf = "vets";
		String nomTemplateThymeleaf = "index";
		String modelPourRetour = nomRepertoireThymeleaf + "/" + nomTemplateThymeleaf;
		
		return modelPourRetour;
	}
	
    @GetMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetsJson(){
        return vetService.findAll();
    }
    
}
