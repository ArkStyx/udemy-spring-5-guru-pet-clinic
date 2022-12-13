package udemy.spring5.guru.sfgpetclinic.controllers;

import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.LinkedHashSet;
import java.util.Set;

import org.hamcrest.Matchers;
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
	void testListOwners() throws Exception {
		when(ownerService.findAll()).thenReturn(listeProprietaires);
		
		// TODO FIXME org.junit.platform.engine.ConfigurationParameters org.junit.platform.launcher.TestPlan
		mockMvc.perform(get("/owners"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/index"))
				.andExpect(model().attribute("listeProprietaires", Matchers.hasSize(2)));
		
		
//		mockMvc.perform(get("/owners"))
//				.andExpect(status().isOk())
//				.andExpect(view().name("owners/index"));
	}

	@Test
	void testFindOwners() throws Exception {
		mockMvc.perform(get("/owners/find"))
				.andExpect(status().isOk())
				.andExpect(view().name("not-implemented-yet"));
		
		verifyNoInteractions(ownerService);
	}

}
