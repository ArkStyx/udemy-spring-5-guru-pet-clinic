package udemy.spring5.guru.sfgpetclinic.services;

import java.util.Set;

import udemy.spring5.guru.sfgpetclinic.models.Owner;

public interface OwnerService {

	Owner findByLastName(String lastName);
	
	Owner findById(Long id);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll();
}
