package udemy.spring5.guru.sfgpetclinic.services.maps.v2;

import java.util.Set;

import udemy.spring5.guru.sfgpetclinic.models.Owner;

public class OwnerServiceMapV2 extends AbstractMapServiceV2<Owner, Long> {

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

}
