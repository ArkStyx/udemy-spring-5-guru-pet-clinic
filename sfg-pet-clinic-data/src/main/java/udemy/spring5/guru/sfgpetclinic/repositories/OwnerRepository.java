package udemy.spring5.guru.sfgpetclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import udemy.spring5.guru.sfgpetclinic.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);
}
