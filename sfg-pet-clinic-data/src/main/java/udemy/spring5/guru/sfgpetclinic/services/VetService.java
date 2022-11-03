package udemy.spring5.guru.sfgpetclinic.services;

import java.util.Set;

import udemy.spring5.guru.sfgpetclinic.models.Vet;

public interface VetService {

	Vet findById(Long id);
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();
}
