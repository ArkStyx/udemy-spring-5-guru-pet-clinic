package udemy.spring5.guru.sfgpetclinic.models;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import udemy.spring5.guru.sfgpetclinic.models.base.BasePerson;

@Getter
@Setter
public class Vet extends BasePerson {

	private Set<Speciality> specialities = new LinkedHashSet<>();
}
