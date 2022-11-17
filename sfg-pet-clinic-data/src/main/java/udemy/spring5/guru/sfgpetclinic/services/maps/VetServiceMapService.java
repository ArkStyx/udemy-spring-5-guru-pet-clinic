package udemy.spring5.guru.sfgpetclinic.services.maps;

import java.util.Set;

import org.springframework.stereotype.Service;

import udemy.spring5.guru.sfgpetclinic.models.Speciality;
import udemy.spring5.guru.sfgpetclinic.models.Vet;
import udemy.spring5.guru.sfgpetclinic.services.SpecialityService;
import udemy.spring5.guru.sfgpetclinic.services.VetService;

@Service
public class VetServiceMapService extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialityService specialityService;

	public VetServiceMapService(SpecialityService specialityService) {
		super();
		this.specialityService = specialityService;
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}
	
	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet vet) {
		if (vet.getSpecialities().size() > 0) {
			vet.getSpecialities().forEach(speciality -> {
				if (speciality.getId() == null) {
					Speciality savedSpeciality = specialityService.save(speciality);
					speciality.setId(savedSpeciality.getId());
				}
			});
		}
		
		
		return super.save(vet);
	}

	@Override
	public void delete(Vet vet) {
		super.delete(vet);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
