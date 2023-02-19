package udemy.spring5.guru.sfgpetclinic.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
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
	void findOwners() throws Exception {
		mockMvc.perform(
					get("/owners/find")
				).
				andExpect(status().isOk()).
				andExpect(view().name("owners/findOwners")).
				andExpect(model().attributeExists("owner"));
		
		verifyNoInteractions(ownerService);
	}
	
	@Test
	void processFindFormReturnMany() throws Exception {
		Owner proprietaire01 = Owner.builder().id(1L).build();
		Owner proprietaire02 = Owner.builder().id(2L).build();
		List<Owner> listeProprietaires = Arrays.asList(proprietaire01, proprietaire02);
		when(ownerService.findAllByLastNameLike(anyString())).thenReturn(listeProprietaires);
		
		mockMvc.perform(
					get("/owners")
				).
				andExpect(status().isOk()).
				andExpect(view().name("owners/ownersList")).
				andExpect(model().attributeExists("selections")).
				andExpect(model().attribute("selections", hasSize(2)));
	}
	
	@Test
	void processFindFormReturnOne() throws Exception {
		
		Owner proprietaire01 = Owner.builder().id(1L).build();
		List<Owner> listeProprietaires = Arrays.asList(proprietaire01);
		when(ownerService.findAllByLastNameLike(anyString())).thenReturn(listeProprietaires);
		
		mockMvc.perform(
					get("/owners")
				).
				andExpect(status().is3xxRedirection()).
				andExpect(view().name("redirect:/owners/1"));
	}

	@Test
	void displayOwner() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());
		
		mockMvc.perform(get("/owners/123")).
				andExpect(status().isOk()).
				andExpect(view().name("owners/ownerDetails")).
				andExpect(model().attribute("owner", hasProperty("id", is(1L))));
	}

}
