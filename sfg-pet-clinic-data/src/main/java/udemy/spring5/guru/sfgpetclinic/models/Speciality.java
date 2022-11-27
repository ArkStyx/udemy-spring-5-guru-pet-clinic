package udemy.spring5.guru.sfgpetclinic.models;

import lombok.Getter;
import lombok.Setter;
import udemy.spring5.guru.sfgpetclinic.models.base.BaseEntity;

@Getter
@Setter
public class Speciality extends BaseEntity {

	private String description;
}
