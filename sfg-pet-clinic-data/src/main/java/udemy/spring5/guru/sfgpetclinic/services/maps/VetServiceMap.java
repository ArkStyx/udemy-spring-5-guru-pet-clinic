package udemy.spring5.guru.sfgpetclinic.services.maps;

import java.util.Set;

import org.springframework.stereotype.Service;

import udemy.spring5.guru.sfgpetclinic.models.Vet;
import udemy.spring5.guru.sfgpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

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
		return super.save(vet.getId(), vet);
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