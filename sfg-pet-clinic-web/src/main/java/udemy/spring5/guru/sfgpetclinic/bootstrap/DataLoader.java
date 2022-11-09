package udemy.spring5.guru.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import udemy.spring5.guru.sfgpetclinic.models.Owner;
import udemy.spring5.guru.sfgpetclinic.models.Vet;
import udemy.spring5.guru.sfgpetclinic.services.OwnerService;
import udemy.spring5.guru.sfgpetclinic.services.PetService;
import udemy.spring5.guru.sfgpetclinic.services.VetService;
import udemy.spring5.guru.sfgpetclinic.services.maps.OwnerServiceMap;
import udemy.spring5.guru.sfgpetclinic.services.maps.PetServiceMap;
import udemy.spring5.guru.sfgpetclinic.services.maps.VetServiceMap;
import udemy.spring5.guru.sfgpetclinic.services.maps.v2.OwnerServiceMapV2;
import udemy.spring5.guru.sfgpetclinic.services.maps.v2.PetServiceMapV2;
import udemy.spring5.guru.sfgpetclinic.services.maps.v2.VetServiceMapV2;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetService petService;
	
	private final OwnerService ownerServiceV2;
	private final VetService vetServiceV2;
	private final PetService petServiceV2;
	
	public DataLoader() {
		ownerService = new OwnerServiceMap();
		vetService = new VetServiceMap();
		petService = new PetServiceMap();
		
		ownerServiceV2 = (OwnerService) new OwnerServiceMapV2();
		vetServiceV2 = (VetService) new VetServiceMapV2();
		petServiceV2 = (PetService) new PetServiceMapV2();
	}

	
	@Override
	public void run(String... args) throws Exception {
		creerProprietairesEtVeterinaires();
		creerProprietairesEtVeterinaires_MethodePersonnelle();
	}

	private void creerProprietairesEtVeterinaires() {
		
		Owner owner01 = new Owner();
		owner01.setId(1L);
		owner01.setFirstName("Michael");
		owner01.setLastName("Weston");
		
		ownerService.save(owner01);
		
		Owner owner02 = new Owner();
		owner02.setId(2L);
		owner02.setFirstName("Fionna");
		owner02.setLastName("Glenanne");
		
		ownerService.save(owner02);
		
		System.out.println("Loaded Owners...");
		
		Vet vet01 = new Vet();
		vet01.setId(1L);
		vet01.setFirstName("Sam");
		vet01.setLastName("Axe");
		
		vetService.save(vet01);
		
		Vet vet02 = new Vet();
		vet02.setId(2L);
		vet02.setFirstName("Jessie");
		vet02.setLastName("Porter");
		
		vetService.save(vet02);
		
		System.out.println("Loaded Vets...");
	}
	
	private void creerProprietairesEtVeterinaires_MethodePersonnelle() {
		
		Owner owner01 = new Owner();
		owner01.setId(3L);
		owner01.setFirstName("Gerard");
		owner01.setLastName("Bouchard");
		
		ownerServiceV2.save(owner01);
		
		Owner owner02 = new Owner();
		owner02.setId(4L);
		owner02.setFirstName("Annie");
		owner02.setLastName("Cordy");
		
		ownerServiceV2.save(owner02);
		
		System.out.println("Nouveaux Proprietaires Crees");
		
		Vet vet01 = new Vet();
		vet01.setId(3L);
		vet01.setFirstName("Gerard");
		vet01.setLastName("Depardieu");
		
		vetServiceV2.save(vet01);
		
		Vet vet02 = new Vet();
		vet02.setId(4L);
		vet02.setFirstName("Fabrice");
		vet02.setLastName("Luchini");
		
		vetServiceV2.save(vet02);
		
		System.out.println("Nouveaux Veterinaires Crees");
	}
}
