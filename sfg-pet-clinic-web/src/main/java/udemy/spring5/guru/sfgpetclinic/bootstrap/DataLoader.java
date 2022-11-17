package udemy.spring5.guru.sfgpetclinic.bootstrap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import udemy.spring5.guru.sfgpetclinic.models.Owner;
import udemy.spring5.guru.sfgpetclinic.models.Pet;
import udemy.spring5.guru.sfgpetclinic.models.PetType;
import udemy.spring5.guru.sfgpetclinic.models.Speciality;
import udemy.spring5.guru.sfgpetclinic.models.Vet;
import udemy.spring5.guru.sfgpetclinic.services.OwnerService;
import udemy.spring5.guru.sfgpetclinic.services.PetService;
import udemy.spring5.guru.sfgpetclinic.services.PetTypeService;
import udemy.spring5.guru.sfgpetclinic.services.SpecialityService;
import udemy.spring5.guru.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetService petService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialityService specialityService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petService = petService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
	}

	@Override
	public void run(String... args) throws Exception {
		if (petService.findAll().size() == 0) {
			creerProprietaires();
			creerVeterinaires();
		}
	}

	private void creerProprietaires() {
		gererProprietaire01();
		gererProprietaire02();
		System.out.println("Loaded Owners...");
	}
	
	private void creerVeterinaires() {
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedSpecialityRadiology = specialityService.save(radiology);
		
		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedSpecialityDentistry = specialityService.save(dentistry);
		
		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSpecialitySurgery = specialityService.save(surgery);
		
		List<Speciality> listeSpecialiteVeterinaire01 = new ArrayList<>();
		listeSpecialiteVeterinaire01.add(savedSpecialityRadiology);
		
		List<Speciality> listeSpecialiteVeterinaire02 = new ArrayList<>();
		listeSpecialiteVeterinaire02.add(savedSpecialityDentistry);
		listeSpecialiteVeterinaire02.add(savedSpecialitySurgery);
		
		gererVeterinaire01(listeSpecialiteVeterinaire01);
		gererVeterinaire02(listeSpecialiteVeterinaire02);
		System.out.println("Loaded Vets...");
	}

	private void gererProprietaire01() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedPetTypeDog = petTypeService.save(dog);
		
		Owner owner01 = new Owner();
		owner01.setFirstName("Michael");
		owner01.setLastName("Westen");
		owner01.setAddress("12 rue Quinquiniart");
		owner01.setCity("Paris");
		owner01.setTelephone("0123456789");
		
		Pet mikePet = new Pet();
		mikePet.setName("Fido");
		mikePet.setBirthDate(LocalDate.now());
		mikePet.setPetType(savedPetTypeDog);
		mikePet.setOwner(owner01);
		
		owner01.getPets().add(mikePet);
		
		ownerService.save(owner01);
	}

	private void gererProprietaire02() {
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedPetTypeCat = petTypeService.save(cat);

		Owner owner02 = new Owner();
		owner02.setFirstName("Fionna");
		owner02.setLastName("Glenanne");
		owner02.setAddress("12 rue Quinquiniart");
		owner02.setCity("Paris");
		owner02.setTelephone("0123456789");
		
		Pet fionaPet = new Pet();
		fionaPet.setName("Felix");
		fionaPet.setBirthDate(LocalDate.now());
		fionaPet.setPetType(savedPetTypeCat);
		fionaPet.setOwner(owner02);
		
		owner02.getPets().add(fionaPet);
		
		ownerService.save(owner02);
	}

	private void gererVeterinaire01(List<Speciality> listeSpecialite) {
		Vet vet01 = new Vet();
		vet01.setFirstName("Sam");
		vet01.setLastName("Axe");
		for (Speciality specialite : listeSpecialite) {
			vet01.getSpecialities().add(specialite);
		}
		vetService.save(vet01);
		
	}

	private void gererVeterinaire02(List<Speciality> listeSpecialite) {
		Vet vet02 = new Vet();
		vet02.setFirstName("Jessie");
		vet02.setLastName("Porter");
		for (Speciality specialite : listeSpecialite) {
			vet02.getSpecialities().add(specialite);
		}
		vetService.save(vet02);
	}
	
}
