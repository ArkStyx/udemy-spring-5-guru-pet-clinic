package udemy.spring5.guru.sfgpetclinic.services;

import java.util.Set;

import udemy.spring5.guru.sfgpetclinic.models.Pet;

public interface PetService {

	Pet findById(Long id);
	
	Pet save(Pet pet);
	
	Set<Pet> findAll();
}
