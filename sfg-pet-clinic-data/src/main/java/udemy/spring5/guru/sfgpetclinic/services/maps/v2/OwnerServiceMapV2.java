package udemy.spring5.guru.sfgpetclinic.services.maps.v2;

import java.util.Set;

import udemy.spring5.guru.sfgpetclinic.models.Owner;
import udemy.spring5.guru.sfgpetclinic.services.OwnerService;

public class OwnerServiceMapV2 extends AbstractMapServiceV2<Owner, Long> implements OwnerService {

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}
	
	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner save(Long id, Owner owner) {
		return super.save(id, owner);
	}

	@Override
	public void delete(Owner owner) {
		super.delete(owner);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	/* -------------------------------------------------- OwnerService -------------------------------------------------- */
	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Owner save(Owner owner) {
		return super.save(owner.getId(), owner);
	}
}
