package udemy.spring5.guru.sfgpetclinic.services.tests;

import java.util.Set;

import udemy.spring5.guru.sfgpetclinic.models.Owner;

public interface OwnerService_v02 extends TestInterface<Owner> {

	Owner findByLastName(String lastName);
	
	@Override
	default Owner findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Owner save(Owner t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Set<Owner> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
