package udemy.spring5.guru.sfgpetclinic.services.maps.v2;

import java.util.Set;

import udemy.spring5.guru.sfgpetclinic.models.Pet;
import udemy.spring5.guru.sfgpetclinic.models.Vet;
import udemy.spring5.guru.sfgpetclinic.services.VetService;

public class VetServiceMapV2 extends AbstractMapServiceV2<Vet, Long> implements VetService {

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}
	
	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Long id, Vet vet) {
		return super.save(id, vet);
	}

	@Override
	public void delete(Vet vet) {
		super.delete(vet);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	/* -------------------------------------------------- PetService -------------------------------------------------- */
	@Override
	public Vet save(Vet vet) {
		return super.save(vet.getId(), vet);
	}

}
