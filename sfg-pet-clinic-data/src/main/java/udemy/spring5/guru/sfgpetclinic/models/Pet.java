package udemy.spring5.guru.sfgpetclinic.models;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import udemy.spring5.guru.sfgpetclinic.models.base.BaseEntity;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
	
	/*
	 * TODO si on supprime un animal, on supprime aussi ses visites
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
	private Set<Visit> visits = new LinkedHashSet<>();

	@Builder
	public Pet(Long id, String name, PetType petType, LocalDate birthDate, Owner owner, Set<Visit> visits) {
		super(id);
		this.name = name;
		this.petType = petType;
		this.birthDate = birthDate;
		this.owner = owner;
		this.visits = visits;
	}
	
}
