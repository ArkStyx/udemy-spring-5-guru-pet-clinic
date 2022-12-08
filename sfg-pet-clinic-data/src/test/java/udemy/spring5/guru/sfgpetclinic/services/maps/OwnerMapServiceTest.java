package udemy.spring5.guru.sfgpetclinic.services.maps;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import udemy.spring5.guru.sfgpetclinic.models.Owner;
import udemy.spring5.guru.sfgpetclinic.models.PetType;
import udemy.spring5.guru.sfgpetclinic.services.PetTypeService;

class OwnerMapServiceTest {

	OwnerMapService ownerMapService;
	
	Long idProprietaire01 = 1L;
	Long idProprietaire02 = 2L;
	
	String nomDeFamille = "Smith";
	
	@BeforeEach
	void setUp() throws Exception {
		ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
		ownerMapService.save(new Owner().builder().id(idProprietaire01).lastName(nomDeFamille).build());
	}

	@Test
	void testFindAll() {
		Set<Owner> listeProprietaires = ownerMapService.findAll();
		assertEquals(1, listeProprietaires.size());
	}

	@Test
	void testFindByIdLong() {
		Owner proprietaire = ownerMapService.findById(idProprietaire01);
		assertEquals(idProprietaire01, proprietaire.getId());
	}

	@Test
	void testSaveOwnerExistant() {
		Owner proprietaire02 = new Owner().builder().id(idProprietaire02).build();
		Owner proprietaire02Sauvegarde = ownerMapService.save(proprietaire02);
		assertEquals(idProprietaire02, proprietaire02Sauvegarde.getId());
	}
	
	@Test
	void testSaveOwnerNonExistant() {
		Owner proprietaireNonExistant = new Owner().builder().build();
		Owner proprietaireNonExistantSauvegarde = ownerMapService.save(proprietaireNonExistant);
		
		assertNotNull(proprietaireNonExistantSauvegarde);
		assertNotNull(proprietaireNonExistantSauvegarde.getId());
	}

	@Test
	void testDeleteOwner() {
		ownerMapService.delete(ownerMapService.findById(idProprietaire01));
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testDeleteByIdLong() {
		ownerMapService.deleteById(idProprietaire01);
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner monsieurSmith = ownerMapService.findByLastName(nomDeFamille);
		
		assertNotNull(monsieurSmith);
		assertEquals(idProprietaire01, monsieurSmith.getId());
	}

}
