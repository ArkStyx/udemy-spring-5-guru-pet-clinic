package udemy.spring5.guru.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import udemy.spring5.guru.sfgpetclinic.models.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
