package udemy.spring5.guru.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import udemy.spring5.guru.sfgpetclinic.models.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

}
