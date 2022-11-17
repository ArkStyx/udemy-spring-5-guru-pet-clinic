package udemy.spring5.guru.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import udemy.spring5.guru.sfgpetclinic.models.Owner;
import udemy.spring5.guru.sfgpetclinic.models.Pet;
import udemy.spring5.guru.sfgpetclinic.models.PetType;
import udemy.spring5.guru.sfgpetclinic.models.Vet;
import udemy.spring5.guru.sfgpetclinic.services.OwnerService;
import udemy.spring5.guru.sfgpetclinic.services.PetService;
import udemy.spring5.guru.sfgpetclinic.services.PetTypeService;
import udemy.spring5.guru.sfgpetclinic.services.VetService;

@Component
public class DataLoaderV2 implements CommandLineRunner {

	private final OwnerService ownerServiceV2;
	private final VetService vetServiceV2;
	private final PetService petServiceV2;
	private final PetTypeService petTypeServiceV2;
	
	public DataLoaderV2(OwnerService ownerServiceV2, VetService vetServiceV2, PetService petServiceV2, PetTypeService petTypeServiceV2) {
		this.ownerServiceV2 = (OwnerService) ownerServiceV2;
		this.vetServiceV2 = (VetService) vetServiceV2;
		this.petServiceV2 = (PetService) petServiceV2;
		this.petTypeServiceV2 = (PetTypeService) petTypeServiceV2;
	}
	
	@Override
	public void run(String... args) throws Exception {
		creerProprietairesEtVeterinaires_MethodePersonnelle();
	}
	
	private void creerProprietairesEtVeterinaires_MethodePersonnelle() {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedPetTypeDog = petTypeServiceV2.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedPetTypeCat = petTypeServiceV2.save(cat);
		
		Owner owner01 = new Owner();
		owner01.setFirstName("Gerard");
		owner01.setLastName("Bouchard");
		owner01.setAddress("12 rue Quinquiniart");
		owner01.setCity("Paris");
		owner01.setTelephone("0123456789");
		
		Pet mikePet = new Pet();
		mikePet.setName("Fido");
		mikePet.setBirthDate(LocalDate.now());
		mikePet.setPetType(savedPetTypeDog);
		mikePet.setOwner(owner01);
		
		owner01.getPets().add(mikePet);
		
		ownerServiceV2.save(owner01);
		
		Owner owner02 = new Owner();
		owner02.setFirstName("Annie");
		owner02.setLastName("Cordy");
		owner02.setAddress("12 rue Quinquiniart");
		owner02.setCity("Paris");
		owner02.setTelephone("0123456789");
		
		Pet fionaPet = new Pet();
		fionaPet.setName("Felix");
		fionaPet.setBirthDate(LocalDate.now());
		fionaPet.setPetType(savedPetTypeCat);
		fionaPet.setOwner(owner02);
		
		owner02.getPets().add(fionaPet);
		
		
		ownerServiceV2.save(owner02);
		
		System.out.println("Nouveaux Proprietaires Crees");
		
		Vet vet01 = new Vet();
		vet01.setFirstName("Gerard");
		vet01.setLastName("Depardieu");
		
		vetServiceV2.save(vet01);
		
		Vet vet02 = new Vet();
		vet02.setFirstName("Fabrice");
		vet02.setLastName("Luchini");
		
		vetServiceV2.save(vet02);
		
		System.out.println("Nouveaux Veterinaires Crees");
	}
}
