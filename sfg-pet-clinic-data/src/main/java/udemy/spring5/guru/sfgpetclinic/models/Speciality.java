package udemy.spring5.guru.sfgpetclinic.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import udemy.spring5.guru.sfgpetclinic.models.base.BaseEntity;

@Getter
@Setter
@Entity
@Table(name = "tb_speciality")
public class Speciality extends BaseEntity {

	@Column(name = "description")
	private String description;
}
