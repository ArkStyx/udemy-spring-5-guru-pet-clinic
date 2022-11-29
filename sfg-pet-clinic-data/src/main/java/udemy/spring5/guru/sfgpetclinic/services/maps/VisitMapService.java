package udemy.spring5.guru.sfgpetclinic.services.maps;

import java.util.Set;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import udemy.spring5.guru.sfgpetclinic.models.Visit;
import udemy.spring5.guru.sfgpetclinic.repositories.VisitRepository;
import udemy.spring5.guru.sfgpetclinic.services.VisitService;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Visit save(Visit visit) {
		if (visit.getPet() == null || visit.getPet().getId() == null || 
			visit.getPet().getOwner() == null || visit.getPet().getOwner().getId() == null) {
			throw new RuntimeException("Visit must have Pet and Owner"));
		}
		
		return super.save(visit);
	}

	@Override
	public void delete(Visit visit) {
		super.delete(visit);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
}
