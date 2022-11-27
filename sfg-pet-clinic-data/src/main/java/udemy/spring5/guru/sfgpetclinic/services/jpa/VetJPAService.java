package udemy.spring5.guru.sfgpetclinic.services.jpa;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import udemy.spring5.guru.sfgpetclinic.models.Vet;
import udemy.spring5.guru.sfgpetclinic.repositories.VetRepository;
import udemy.spring5.guru.sfgpetclinic.services.VetService;

@AllArgsConstructor
@Service
@Profile("spring-data-jpa")
public class VetJPAService implements VetService {

	private final VetRepository vetRepository;
	
	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet vet) {
		return vetRepository.save(vet);
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> listeVeterinaires = new LinkedHashSet<>();
		vetRepository.findAll().forEach(listeVeterinaires::add);
		return listeVeterinaires;
	}

	@Override
	public void delete(Vet vet) {
		vetRepository.delete(vet);
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}

}
