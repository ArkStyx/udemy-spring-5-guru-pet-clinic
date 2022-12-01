package udemy.spring5.guru.sfgpetclinic.models;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import udemy.spring5.guru.sfgpetclinic.models.base.BasePerson;

@Getter
@Setter
@Entity
@Table(name = "tb_owner")
public class Owner extends BasePerson {

	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "telephone")
	private String telephone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new LinkedHashSet<>();
}
