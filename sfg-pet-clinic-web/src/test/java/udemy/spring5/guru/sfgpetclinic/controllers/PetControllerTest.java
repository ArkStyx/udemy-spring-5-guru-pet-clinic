package udemy.spring5.guru.sfgpetclinic.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

public class PetControllerTest {

	
	MockMvc mockMvc;
	
	/*
	TODO
	void initCreationForm()
	void processCreationForm()
	void initUpdateOwnerForm()
	void processUpdateOwnerForm()
	*/
	
	/*
	TODO
	/owners/1/pets/new
	/owners/1/pets/edit
	*/
	
	@Test
	void initCreationForm() throws Exception {
		mockMvc.perform(
					get("/owners/1/pets/new")
				).
				andExpect(status().isOk()).
				andExpect(view().name("pets/createOrUpdatePetForm")).
				andExpect(model().attributeExists("owner")).
				andExpect(model().attributeExists("pet"));
	}
	

	
	@Test
	void populatePetTypes() {
		// TODO implementation
	}
	
	@Test
	void findOwner() {
		// TODO implementation
	}
	
	@Test
	void initOwnerBinder() {
		// TODO implementation
	}
	
}
