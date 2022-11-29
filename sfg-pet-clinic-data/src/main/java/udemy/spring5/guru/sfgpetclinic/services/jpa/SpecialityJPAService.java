package udemy.spring5.guru.sfgpetclinic.services.jpa;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import udemy.spring5.guru.sfgpetclinic.models.Speciality;
import udemy.spring5.guru.sfgpetclinic.repositories.SpecialityRepository;
import udemy.spring5.guru.sfgpetclinic.services.SpecialityService;

@AllArgsConstructor
@Service
@Profile("spring-data-jpa")
public class SpecialityJPAService implements SpecialityService {
	
	private final SpecialityRepository specialityRepository;
	
	@Override
	public Speciality findById(Long id) {
		return specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality speciality) {
		return specialityRepository.save(speciality);
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> listeSpecialites = new LinkedHashSet<>();
		specialityRepository.findAll().forEach(listeSpecialites::add);
		return listeSpecialites;
	}

	@Override
	public void delete(Speciality speciality) {
		specialityRepository.delete(speciality);
	}

	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);
	}

}
