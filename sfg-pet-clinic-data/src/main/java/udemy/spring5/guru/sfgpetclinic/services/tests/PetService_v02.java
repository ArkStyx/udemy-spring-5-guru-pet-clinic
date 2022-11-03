package udemy.spring5.guru.sfgpetclinic.services.tests;

import java.util.Set;

import udemy.spring5.guru.sfgpetclinic.models.Pet;

public interface PetService_v02 extends TestInterface<Pet> {

	@Override
	default Pet findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Pet save(Pet t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Set<Pet> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
