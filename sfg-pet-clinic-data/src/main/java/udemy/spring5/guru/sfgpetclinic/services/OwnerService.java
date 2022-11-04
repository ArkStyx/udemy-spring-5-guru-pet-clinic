package udemy.spring5.guru.sfgpetclinic.services;

import udemy.spring5.guru.sfgpetclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);
}
