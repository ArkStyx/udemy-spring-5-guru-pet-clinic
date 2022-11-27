package udemy.spring5.guru.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import udemy.spring5.guru.sfgpetclinic.models.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
