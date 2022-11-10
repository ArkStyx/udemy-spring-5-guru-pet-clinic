package udemy.spring5.guru.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import udemy.spring5.guru.sfgpetclinic.models.Owner;
import udemy.spring5.guru.sfgpetclinic.models.Vet;
import udemy.spring5.guru.sfgpetclinic.services.OwnerService;
import udemy.spring5.guru.sfgpetclinic.services.PetService;
import udemy.spring5.guru.sfgpetclinic.services.VetService;

@Component
public class DataLoaderV2 implements CommandLineRunner {

	private final OwnerService ownerServiceV2;
	private final VetService vetServiceV2;
	private final PetService petServiceV2;
	
	public DataLoaderV2(OwnerService ownerServiceV2, VetService vetServiceV2, PetService petServiceV2) {
		this.ownerServiceV2 = (OwnerService) ownerServiceV2;
		this.vetServiceV2 = (VetService) vetServiceV2;
		this.petServiceV2 = (PetService) petServiceV2;
	}

	@Override
	public void run(String... args) throws Exception {
		creerProprietairesEtVeterinaires_MethodePersonnelle();
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
