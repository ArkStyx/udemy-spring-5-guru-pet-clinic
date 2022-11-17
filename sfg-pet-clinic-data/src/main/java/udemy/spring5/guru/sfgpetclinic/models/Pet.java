package udemy.spring5.guru.sfgpetclinic.models;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pet extends BaseEntity {

	private String name;
	private PetType petType;
	private LocalDate birthDate;
	private Owner owner;
}
