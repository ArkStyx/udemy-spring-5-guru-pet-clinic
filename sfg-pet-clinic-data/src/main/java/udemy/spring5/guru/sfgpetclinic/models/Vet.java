package udemy.spring5.guru.sfgpetclinic.models;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vet extends Person {

	private Set<Speciality> specialities = new LinkedHashSet<>();
}
