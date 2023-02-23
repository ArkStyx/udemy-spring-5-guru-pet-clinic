package udemy.spring5.guru.sfgpetclinic.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import udemy.spring5.guru.sfgpetclinic.models.Owner;
import udemy.spring5.guru.sfgpetclinic.services.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";
	
	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
	
	@RequestMapping("/find")
	public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
	}
	
	@GetMapping
	public String processFindForm(Owner owner, BindingResult result, Model model) {
		if (owner.getLastName() == null) {
			// XXX : Empty string signifies broadest possible search
			owner.setLastName("");
		}
		
		List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
		if (results.isEmpty()) {
			/* 0 proprietaire trouve */
			String field = "lastName";
			String errorCode = "notFound";
			String defaultMessage = "not found";
			result.rejectValue(field, errorCode, defaultMessage);
			return "owners/findOwners";
		}
		else if (results.size() == 1) {
			/* 1 proprietaire trouve */
			owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
		}
		else {
			/* Plusieurs proprietaires trouves */
			model.addAttribute("selections", results);
            return "owners/ownersList";
		}
	}
	
	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
		ModelAndView mav = new ModelAndView("owners/ownerDetails");
		mav.addObject(ownerService.findById(ownerId));
		return mav;
	}

    @GetMapping("/new")
	public String initCreationForm(Model model) {
		model.addAttribute("owner", Owner.builder().build());
		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
	}
	
    @PostMapping("/new")
	public String processCreationForm(@Validated Owner owner, BindingResult result) {
    	if (result.hasErrors()) {
    		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    	}
    	else {
    		Owner savedOwner = ownerService.save(owner);
    		return "redirect:/owners/" + savedOwner.getId();
    	}
	}
    
    @GetMapping("{ownerId}/edit")
    public String initUpdateOwnerForm(Model model, @PathVariable Long ownerId) {
    	model.addAttribute("owner", ownerService.findById(ownerId));
    	return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }
    
    @PostMapping("{ownerId}/edit")
    public String processUpdateOwnerForm(@Validated Owner owner, BindingResult result, @PathVariable Long ownerId) {
    	if (result.hasErrors()) {
    		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    	}
    	else {
    		owner.setId(ownerId);
    		Owner savedOwner = ownerService.save(owner);
    		return "redirect:/owners/" + savedOwner.getId();
    	}
    }	
	
	/*
	 * -------------------------------------------------- TEST PERSO SUITE A REMARQUE --------------------------------------------------
	 * https://github.com/springframeworkguru/sfg-pet-clinic/commit/2928e9485a7332994f6557e81f51e183b5b8a578
	 * ---------------------------------------------------------------------------------------------------------------------------------
	 */
    @PostMapping("/new___PERSO_V01")
	public String processCreationForm___PERSO_V01(@ModelAttribute Owner owner, BindingResult result) {
    	if (result.hasErrors()) {
    		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    	}
    	else {
    		Owner savedOwner = ownerService.save(owner);
    		return "redirect:/owners/" + savedOwner.getId();
    	}
	}
    
    @PostMapping("{ownerId}/edit___PERSO_V01")
    public String processUpdateOwnerForm___PERSO_V01(@ModelAttribute Owner owner, BindingResult result, @PathVariable Long ownerId) {
    	if (result.hasErrors()) {
    		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    	}
    	else {
    		owner.setId(ownerId);
    		Owner savedOwner = ownerService.save(owner);
    		return "redirect:/owners/" + savedOwner.getId();
    	}
    }	
	
}
