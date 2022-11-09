package udemy.spring5.guru.sfgpetclinic.services.maps.v2;

import java.util.Set;

import udemy.spring5.guru.sfgpetclinic.models.Pet;
import udemy.spring5.guru.sfgpetclinic.services.PetService;

public class PetServiceMapV2 extends AbstractMapServiceV2<Pet, Long> implements PetService {

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}
	
	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Long id, Pet pet) {
		return super.save(id, pet);
	}

	@Override
	public void delete(Pet pet) {
		super.delete(pet);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
	/* -------------------------------------------------- PetService -------------------------------------------------- */
	@Override
	public Pet save(Pet pet) {
		return super.save(pet.getId(), pet);
	}

}
