package udemy.spring5.guru.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import udemy.spring5.guru.sfgpetclinic.models.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
