package udemy.spring5.guru.sfgpetclinic.services.tests;

import java.util.Set;

import udemy.spring5.guru.sfgpetclinic.models.Owner;

public interface OwnerService_v03 extends TestInterface<Owner> {

	Owner findByLastName(String lastName);
	
	@Override
	Owner findById(Long id);

	@Override
	Owner save(Owner owner);

	@Override
	Set<Owner> findAll();

}
