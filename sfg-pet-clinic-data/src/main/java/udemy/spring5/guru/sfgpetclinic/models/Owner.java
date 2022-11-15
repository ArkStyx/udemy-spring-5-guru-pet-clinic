package udemy.spring5.guru.sfgpetclinic.models;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Owner extends Person {

	private Set<Pet> pets;
}
