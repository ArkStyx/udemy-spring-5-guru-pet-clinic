package udemy.spring5.guru.sfgpetclinic.services.maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import udemy.spring5.guru.sfgpetclinic.models.Pet;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetMapServiceTest {

    private PetMapService petMapService;

    private final Long idAnimal01 = 1L;
    private final Long idAnimal02 = 2L;
    private final Long idAnimal05 = 5L;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        petMapService.save(Pet.builder().id(idAnimal01).build());
    }

    @Test
    void findAll() {
        Set<Pet> petSet = petMapService.findAll();
        assertEquals(1, petSet.size());
    }

    @Test
    void findByIdExistingId() {
        Pet animal = petMapService.findById(idAnimal01);
        assertEquals(idAnimal01, animal.getId());
    }

    @Test
    void findByIdNotExistingId() {
        Pet animal = petMapService.findById(idAnimal05);
        assertNull(animal);
    }

    @Test
    void findByIdNullId() {
        Pet pet = petMapService.findById(null);
        assertNull(pet);
    }

    @Test
    void saveExistingId() {
        Pet animal = Pet.builder().id(idAnimal02).build();
        Pet animalSauvegarde = petMapService.save(animal);
        assertEquals(idAnimal02, animalSauvegarde.getId());
    }

    @Test
    void saveDuplicateId() {
        Pet animal = Pet.builder().id(idAnimal01).build();
        Pet animalSauvegarde = petMapService.save(animal);

        assertEquals(idAnimal01, animalSauvegarde.getId());
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void saveNoId() {
        Pet animalSauvegarde = petMapService.save(Pet.builder().build());

        assertNotNull(animalSauvegarde);
        assertNotNull(animalSauvegarde.getId());
        assertEquals(2, petMapService.findAll().size());
    }

    @Test
    void deletePet() {
        petMapService.delete(petMapService.findById(idAnimal01));
        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void deleteWithWrongId() {
        Pet pet = Pet.builder().id(idAnimal05).build();
        petMapService.delete(pet);
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteWithNullId() {
        Pet pet = Pet.builder().build();
        petMapService.delete(pet);
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteNull() {
        petMapService.delete(null);
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteByIdCorrectId() {
        petMapService.deleteById(idAnimal01);
        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void deleteByIdWrongId() {
        petMapService.deleteById(idAnimal05);
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteByIdNullId() {
        petMapService.deleteById(null);
        assertEquals(1, petMapService.findAll().size());
    }
}
