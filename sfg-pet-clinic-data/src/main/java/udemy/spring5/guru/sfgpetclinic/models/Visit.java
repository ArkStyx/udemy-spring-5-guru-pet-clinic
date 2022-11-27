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
@Table(name = "tb_visit")
public class Visit extends BaseEntity {

	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;
}
