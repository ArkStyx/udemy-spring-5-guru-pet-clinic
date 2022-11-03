package udemy.spring5.guru.sfgpetclinic.services.tests;

import java.util.Set;

import udemy.spring5.guru.sfgpetclinic.models.Pet;

public interface PetService_v03 extends TestInterface<Pet> {

	@Override
	Pet findById(Long id);

	@Override
	Pet save(Pet pet);

	@Override
	Set<Pet> findAll();

}
