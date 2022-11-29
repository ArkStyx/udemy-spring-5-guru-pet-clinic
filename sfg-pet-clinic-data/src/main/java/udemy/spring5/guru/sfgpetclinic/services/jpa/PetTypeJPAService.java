package udemy.spring5.guru.sfgpetclinic.services.jpa;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import udemy.spring5.guru.sfgpetclinic.models.PetType;
import udemy.spring5.guru.sfgpetclinic.repositories.PetTypeRepository;
import udemy.spring5.guru.sfgpetclinic.services.PetTypeService;

@AllArgsConstructor
@Service
@Profile("spring-data-jpa")
public class PetTypeJPAService implements PetTypeService {

	private final PetTypeRepository petTypeRepository;

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType petType) {
		return petTypeRepository.save(petType);
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> listeTypeAnimaux = new LinkedHashSet<>();
		petTypeRepository.findAll().forEach(listeTypeAnimaux::add);
		return listeTypeAnimaux;
	}

	@Override
	public void delete(PetType petType) {
		petTypeRepository.delete(petType);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}
	
}
