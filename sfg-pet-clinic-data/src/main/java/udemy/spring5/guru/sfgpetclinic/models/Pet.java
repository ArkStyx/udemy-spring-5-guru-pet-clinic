package udemy.spring5.guru.sfgpetclinic.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import udemy.spring5.guru.sfgpetclinic.models.base.BaseEntity;

@Getter
@Setter
@Entity
@Table(name = "tb_pet")
public class Pet extends BaseEntity {

	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
}
