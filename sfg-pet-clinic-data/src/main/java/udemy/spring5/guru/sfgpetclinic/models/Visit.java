package udemy.spring5.guru.sfgpetclinic.models;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import udemy.spring5.guru.sfgpetclinic.models.base.BaseEntity;

@Getter
@Setter
public class Visit extends BaseEntity {

	private LocalDate date;
	private String description;
	private Pet pet;
}
