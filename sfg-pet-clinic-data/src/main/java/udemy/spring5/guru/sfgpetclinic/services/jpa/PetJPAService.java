package udemy.spring5.guru.sfgpetclinic.services.jpa;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import udemy.spring5.guru.sfgpetclinic.models.Pet;
import udemy.spring5.guru.sfgpetclinic.repositories.PetRepository;
import udemy.spring5.guru.sfgpetclinic.services.PetService;

@AllArgsConstructor
@Service
@Profile("spring-data-jpa")
public class PetJPAService implements PetService {

	private final PetRepository petRepository;

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet pet) {
		return petRepository.save(pet);
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> listeAnimaux = new LinkedHashSet<>();
		petRepository.findAll().forEach(listeAnimaux::add);
		return listeAnimaux;
	}

	@Override
	public void delete(Pet pet) {
		petRepository.delete(pet);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}
	
}
