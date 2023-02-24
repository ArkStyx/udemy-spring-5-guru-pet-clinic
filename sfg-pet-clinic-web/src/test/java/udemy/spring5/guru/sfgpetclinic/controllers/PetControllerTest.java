package udemy.spring5.guru.sfgpetclinic.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import udemy.spring5.guru.sfgpetclinic.models.Owner;
import udemy.spring5.guru.sfgpetclinic.models.Pet;
import udemy.spring5.guru.sfgpetclinic.models.PetType;
import udemy.spring5.guru.sfgpetclinic.services.OwnerService;
import udemy.spring5.guru.sfgpetclinic.services.PetService;
import udemy.spring5.guru.sfgpetclinic.services.PetTypeService;

@ExtendWith(MockitoExtension.class)
public class PetControllerTest {

	@Mock
	OwnerService ownerService;
	
	@Mock
	PetTypeService petTypeService;
	
	@Mock
	PetService petService;
	
	@InjectMocks
	private PetController petController;
	
	MockMvc mockMvc;

    Owner owner;
    
    Pet pet;
    
    PetType dogType;
    PetType catType;
    
    Set<PetType> petTypes;
	
	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
		
		owner = Owner.builder().id(1L).build();
		
		pet = Pet.builder().id(2L).build();
		
		dogType = PetType.builder().id(1L).name("dog").build();
		catType = PetType.builder().id(2L).name("cat").build();
		
		petTypes = new LinkedHashSet<>();
		petTypes.add(dogType);
		petTypes.add(catType);
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

	@Test
	void initCreationForm() throws Exception {
		
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);
		
		mockMvc.perform(
					get("/owners/1/pets/new")
				).
				andExpect(status().isOk()).
				andExpect(model().attributeExists("owner")).
				andExpect(model().attributeExists("pet")).
				andExpect(view().name("pets/createOrUpdatePetForm"));
	}
	
	@Test
	void processCreationForm() throws Exception {
		
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);
		
        mockMvc.perform(
        			post("/owners/1/pets/new")
		        ).
		        andExpect(status().is3xxRedirection()).
		        andExpect(view().name("redirect:/owners/1"));

        verify(petService).save(ArgumentMatchers.any());
	}
	
	@Test
	void initUpdateOwnerForm() throws Exception {
		
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);
		when(petService.findById(anyLong())).thenReturn(pet);
		
		mockMvc.perform(
					get("/owners/1/pets/2/edit")
				).
				andExpect(status().isOk()).
				andExpect(model().attributeExists("owner")).
				andExpect(model().attributeExists("pet")).
				andExpect(view().name("pets/createOrUpdatePetForm"));
	}
	
	@Test
	void processUpdateOwnerForm() throws Exception {

		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);
		
		mockMvc.perform(
					MockMvcRequestBuilders.post("/owners/1/pets/2/edit")
				).
				andExpect(status().is3xxRedirection()).
				andExpect(view().name("redirect:/owners/1"));
		
		verify(petService).save(ArgumentMatchers.any());
	}
	
}
