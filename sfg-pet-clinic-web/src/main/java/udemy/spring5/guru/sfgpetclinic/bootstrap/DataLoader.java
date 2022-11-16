package udemy.spring5.guru.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import udemy.spring5.guru.sfgpetclinic.models.Owner;
import udemy.spring5.guru.sfgpetclinic.models.PetType;
import udemy.spring5.guru.sfgpetclinic.models.Vet;
import udemy.spring5.guru.sfgpetclinic.services.OwnerService;
import udemy.spring5.guru.sfgpetclinic.services.PetService;
import udemy.spring5.guru.sfgpetclinic.services.PetTypeService;
import udemy.spring5.guru.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetService petService;
	private final PetTypeService petTypeService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petService = petService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		creerProprietairesEtVeterinaires();
	}

	private void creerProprietairesEtVeterinaires() {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		petTypeService.save(cat);
		
		Owner owner01 = new Owner();
		owner01.setFirstName("Michael");
		owner01.setLastName("Westen");
		
		ownerService.save(owner01);
		
		Owner owner02 = new Owner();
		owner02.setFirstName("Fionna");
		owner02.setLastName("Glenanne");
		
		ownerService.save(owner02);
		
		System.out.println("Loaded Owners...");
		
		Vet vet01 = new Vet();
		vet01.setFirstName("Sam");
		vet01.setLastName("Axe");
		
		vetService.save(vet01);
		
		Vet vet02 = new Vet();
		vet02.setFirstName("Jessie");
		vet02.setLastName("Porter");
		
		vetService.save(vet02);
		
		System.out.println("Loaded Vets...");
	}
	
}
