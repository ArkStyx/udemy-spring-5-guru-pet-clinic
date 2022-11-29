package udemy.spring5.guru.sfgpetclinic.services.jpa;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import udemy.spring5.guru.sfgpetclinic.models.Visit;
import udemy.spring5.guru.sfgpetclinic.repositories.VisitRepository;
import udemy.spring5.guru.sfgpetclinic.services.VisitService;

@AllArgsConstructor
@Service
@Profile("spring-data-jpa")
public class VisitJPAService implements VisitService {

	private final VisitRepository visitRepository;
	
	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit visit) {
		return visitRepository.save(visit);
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> listeVisites = new LinkedHashSet<>();
		visitRepository.findAll().forEach(listeVisites::add);
		return listeVisites;
	}

	@Override
	public void delete(Visit visit) {
		visitRepository.delete(visit);
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}

}
