package udemy.spring5.guru.sfgpetclinic.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import udemy.spring5.guru.sfgpetclinic.models.Owner;
import udemy.spring5.guru.sfgpetclinic.services.OwnerService;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
	
	@Mock
	OwnerService ownerService;
	
	@InjectMocks
	OwnerController ownerController;
	
	Set<Owner> listeProprietaires;
	Long idProprietaire01 = 1L;
	Long idProprietaire02 = 2L;
	
	MockMvc mockMvc;
	
	@BeforeEach
	void setUp() throws Exception {
		listeProprietaires = new LinkedHashSet<>();
		listeProprietaires.add(Owner.builder().id(idProprietaire01).build());
		listeProprietaires.add(Owner.builder().id(idProprietaire02).build());
		
		mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
	}

	@Test
	void listOwners() throws Exception {
		when(ownerService.findAll()).thenReturn(listeProprietaires);
		
		// TODO FIXME org.junit.platform.engine.ConfigurationParameters org.junit.platform.launcher.TestPlan
		mockMvc.perform(get("/owners"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/index"))
				.andExpect(model().attribute("listeProprietaires", hasSize(2)));
	}

	@Test
	void findOwners() throws Exception {
		mockMvc.perform(get("/owners/find"))
				.andExpect(status().isOk())
				.andExpect(view().name("not-implemented-yet"));
		
		verifyNoInteractions(ownerService);
	}
	
	@Test
	void displayOwner() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());
		
		mockMvc.perform(get("/owners/123")).
				andExpect(status().isOk()).
				andExpect(view().name("owners/ownerDetails")).
				andExpect(model().attribute("owner", hasProperty("id", is(11))));
	}

}
