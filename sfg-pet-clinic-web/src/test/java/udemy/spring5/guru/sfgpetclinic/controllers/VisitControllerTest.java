package udemy.spring5.guru.sfgpetclinic.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriTemplate;

import udemy.spring5.guru.sfgpetclinic.models.Owner;
import udemy.spring5.guru.sfgpetclinic.models.Pet;
import udemy.spring5.guru.sfgpetclinic.models.PetType;
import udemy.spring5.guru.sfgpetclinic.services.PetService;
import udemy.spring5.guru.sfgpetclinic.services.VisitService;

@ExtendWith(MockitoExtension.class)
public class VisitControllerTest {

	private static final String URL_APPEL_PROCESS_NEW_VISIT_FORM = "/owners/{ownerId}/pets/{petId}/visits/new";
	
	private static final String URL_RETOUR_CREATE_OR_UPDATE_VISIT_FORM = "pets/createOrUpdateVisitForm";
	private static final String URL_RETOUR_REDIRECTION = "redirect:/owners/{ownerId}";

    private URI uriDesVisites;
	
    private Owner proprietaire01;
    private Pet animal01;
    private PetType typeAnimal01;

	private Long idProprietaire01 = 1L;
	private Long idTypeAnimal01 = 1L;
	private Long idAnimal01 = 1L;
    
	@Mock
	VisitService visitService;
	
	@Mock
    PetService petService;
	
	@InjectMocks
	VisitController visitController;
	
	MockMvc mockMvc;
	
	@BeforeEach
	void setUp() throws Exception {
		initialisationDesInstances();
		initialisationDesURI();
		mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
	}
	
	private void initialisationDesInstances() {
		proprietaire01 = Owner.builder().id(idProprietaire01).
	            lastName("Doe").
	            firstName("Joe").
				build();
		
		typeAnimal01 = PetType.builder().id(idTypeAnimal01).name("Dog").
						build();
		
		animal01 = Pet.builder().
				id(idAnimal01).
				birthDate(LocalDate.of(2018,11,13)).
		        name("Cutie").
		        visits(new HashSet<>()).
		        owner(proprietaire01).
		        petType(typeAnimal01).
		        build();
	}
	
	private void initialisationDesURI() {
	    Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("ownerId", String.valueOf(idProprietaire01));
        uriVariables.put("petId", String.valueOf(idAnimal01));

        uriDesVisites = new UriTemplate(URL_APPEL_PROCESS_NEW_VISIT_FORM).expand(uriVariables);
	}
	
	@Test
	void initNewVisitForm() throws Exception {
		when(petService.findById(anyLong())).thenReturn(animal01);
		
		mockMvc.perform(
					get(uriDesVisites)
				).
				andExpect(status().isOk()).
				andExpect(view().name(URL_RETOUR_CREATE_OR_UPDATE_VISIT_FORM));
	}

	@Test
	void processNewVisitForm_Redirection_OK() throws Exception {
		when(petService.findById(anyLong())).thenReturn(animal01);
		
		mockMvc.perform(
					post(uriDesVisites).
					contentType(MediaType.APPLICATION_FORM_URLENCODED).
                    param("date","2018-11-11").
                    param("description", "Une nouvelle visite")
				).
				andExpect(status().is3xxRedirection()).
				andExpect(view().name(URL_RETOUR_REDIRECTION));
	}
	
	@Test
	void processNewVisitForm_Redirection_KO() throws Exception {
		when(petService.findById(anyLong())).thenReturn(animal01);
	
		mockMvc.perform(
					post(uriDesVisites).
					contentType(MediaType.APPLICATION_FORM_URLENCODED).
                    param("date","azerty").
                    param("description", "Une nouvelle visite")
				).
				andExpect(status().isOk()).
				andExpect(view().name(URL_RETOUR_CREATE_OR_UPDATE_VISIT_FORM));
	}
	
}
