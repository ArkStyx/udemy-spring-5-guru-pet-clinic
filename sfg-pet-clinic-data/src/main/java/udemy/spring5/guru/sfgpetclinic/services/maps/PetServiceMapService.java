package udemy.spring5.guru.sfgpetclinic.services.maps;

import java.util.Set;

import org.springframework.stereotype.Service;

import udemy.spring5.guru.sfgpetclinic.models.Pet;
import udemy.spring5.guru.sfgpetclinic.services.PetService;

@Service
public class PetServiceMapService extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}
	
	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Pet pet) {
		return super.save(pet);
	}

	@Override
	public void delete(Pet pet) {
		super.delete(pet);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
