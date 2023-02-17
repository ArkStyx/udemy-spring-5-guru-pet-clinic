package udemy.spring5.guru.sfgpetclinic.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import udemy.spring5.guru.sfgpetclinic.models.base.BaseEntity;

@Getter
@Setter
@Entity
@Table(name = "tb_pet_type")
public class PetType extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Override
	public String toString() {
		return name;
	}
	
}
