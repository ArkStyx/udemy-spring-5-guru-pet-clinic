package udemy.spring5.guru.sfgpetclinic.services.jpa;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import udemy.spring5.guru.sfgpetclinic.models.Owner;
import udemy.spring5.guru.sfgpetclinic.repositories.OwnerRepository;
import udemy.spring5.guru.sfgpetclinic.repositories.PetRepository;
import udemy.spring5.guru.sfgpetclinic.repositories.PetTypeRepository;
import udemy.spring5.guru.sfgpetclinic.services.OwnerService;

@AllArgsConstructor
@Service
@Profile("spring-data-jpa")
public class OwnerJPARepository implements OwnerService {

	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;

	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> listeProprietaires = new LinkedHashSet<>();
		ownerRepository.findAll().forEach(listeProprietaires::add);
		return listeProprietaires;
	}

	@Override
	public void delete(Owner owner) {
		ownerRepository.delete(owner);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

}
