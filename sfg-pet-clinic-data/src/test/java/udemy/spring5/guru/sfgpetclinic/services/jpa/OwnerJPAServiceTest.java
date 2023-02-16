package udemy.spring5.guru.sfgpetclinic.services.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import udemy.spring5.guru.sfgpetclinic.models.Owner;
import udemy.spring5.guru.sfgpetclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

	@Mock
	OwnerRepository ownerRepository;
	
	@InjectMocks
	OwnerJPAService ownerJPAService;
	
	Owner returnedOwner;
	Long idProprietaire01 = 1L;
	Long idProprietaire02 = 2L;
	
	String nomDeFamille = "Smith";
	
	@BeforeEach
	void setUp() throws Exception {
		
		/*
		 * FIXME REMPLACE PAR @InjectMocks
		 */
//		MockitoAnnotations.openMocks(ownerRepository);
//		ownerJPAService = new OwnerJPAService(ownerRepository);
		
		returnedOwner = Owner.builder().id(idProprietaire01).lastName(nomDeFamille).build();
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));
		
		Owner proprietaireRetourne = ownerJPAService.findById(idProprietaire01);
		
		assertNotNull(proprietaireRetourne);
		assertEquals(idProprietaire01, proprietaireRetourne.getId());
	}
	
	@Test
	void testFindByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
		
		Owner proprietaireRetourne = ownerJPAService.findById(idProprietaire01);
		
		assertNull(proprietaireRetourne);
	}
	
	@Test
	void testFindByLastName() {
		when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);
		
		Owner proprietaireRetourne = ownerJPAService.findByLastName(nomDeFamille);
		
		assertEquals(nomDeFamille, proprietaireRetourne.getLastName());
		verify(ownerRepository).findByLastName(any());
	}

	@Test
	void testFindAll() {
		Set<Owner> listeProprietaires = new LinkedHashSet<>();
		listeProprietaires.add(Owner.builder().id(idProprietaire01).build());
		listeProprietaires.add(Owner.builder().id(idProprietaire02).build());
		
		when(ownerRepository.findAll()).thenReturn(listeProprietaires);
		
		Set<Owner> listeProprietairesRetournes = ownerJPAService.findAll();
		
		assertNotNull(listeProprietairesRetournes);
		assertEquals(2, listeProprietairesRetournes.size());
		verify(ownerRepository, times(1)).findAll();
	}
	
	@Test
	void testSave() {
		when(ownerRepository.save(any())).thenReturn(returnedOwner);
		
		Owner proprietaire = Owner.builder().id(idProprietaire01).build();
		Owner proprietaireRetourne = ownerJPAService.save(proprietaire);
		
		assertNotNull(proprietaireRetourne);
		assertEquals(idProprietaire01, proprietaireRetourne.getId());
	}
	
	@Test
	void testDelete() {
		ownerJPAService.delete(returnedOwner);
		verify(ownerRepository, times(1)).delete(any());
	}

	@Test
	void testDeleteById() {
		ownerJPAService.deleteById(idProprietaire01);
		verify(ownerRepository, times(1)).deleteById(anyLong());
	}

}
