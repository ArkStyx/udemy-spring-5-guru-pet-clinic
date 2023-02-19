package udemy.spring5.guru.sfgpetclinic.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import udemy.spring5.guru.sfgpetclinic.models.Owner;
import udemy.spring5.guru.sfgpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

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
	
}
