package udemy.spring5.guru.sfgpetclinic.services;

import java.util.List;

import udemy.spring5.guru.sfgpetclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);
}
