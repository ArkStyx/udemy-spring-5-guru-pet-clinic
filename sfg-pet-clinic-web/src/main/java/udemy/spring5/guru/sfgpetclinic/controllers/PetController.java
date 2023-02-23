package udemy.spring5.guru.sfgpetclinic.controllers;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import udemy.spring5.guru.sfgpetclinic.models.Owner;
import udemy.spring5.guru.sfgpetclinic.models.PetType;
import udemy.spring5.guru.sfgpetclinic.services.OwnerService;
import udemy.spring5.guru.sfgpetclinic.services.PetTypeService;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

	// TODO A DECOMMENTER
//	private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
	
	private final OwnerService ownerService;
	
	private final PetTypeService petTypeService;

	public PetController(OwnerService ownerService, PetTypeService petTypeService) {
		super();
		this.ownerService = ownerService;
		this.petTypeService = petTypeService;
	}

	@ModelAttribute("types")
	public Collection<PetType> populatePetTypes() {
		return petTypeService.findAll();
	}
	
	@ModelAttribute("owner")
	public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
		return ownerService.findById(ownerId);
	}
	
	@InitBinder("owner")
	public void initOwnerBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
}