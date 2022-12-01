package udemy.spring5.guru.sfgpetclinic.models;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import udemy.spring5.guru.sfgpetclinic.models.base.BasePerson;

@Getter
@Setter
@Entity
@Table(name = "tb_vet")
public class Vet extends BasePerson {

	/*
	 * TODO Si on laisse le FetchType par defaut, qui est de LAZY pour @ManyToMany, alors les specialites ne seront pas charges sur appel de l'objet Vet
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_vet_speciality", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
	private Set<Speciality> specialities = new LinkedHashSet<>();
}
