package udemy.spring5.guru.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import udemy.spring5.guru.sfgpetclinic.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Owner findByLastName(String lastName);
}
