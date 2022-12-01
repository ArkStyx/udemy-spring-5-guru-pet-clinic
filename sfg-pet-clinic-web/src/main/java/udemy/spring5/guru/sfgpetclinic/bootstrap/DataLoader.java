package udemy.spring5.guru.sfgpetclinic.bootstrap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import udemy.spring5.guru.sfgpetclinic.models.Owner;
import udemy.spring5.guru.sfgpetclinic.models.Pet;
import udemy.spring5.guru.sfgpetclinic.models.PetType;
import udemy.spring5.guru.sfgpetclinic.models.Speciality;
import udemy.spring5.guru.sfgpetclinic.models.Vet;
import udemy.spring5.guru.sfgpetclinic.models.Visit;
import udemy.spring5.guru.sfgpetclinic.services.OwnerService;
import udemy.spring5.guru.sfgpetclinic.services.PetService;
import udemy.spring5.guru.sfgpetclinic.services.PetTypeService;
import udemy.spring5.guru.sfgpetclinic.services.SpecialityService;
import udemy.spring5.guru.sfgpetclinic.services.VetService;
import udemy.spring5.guru.sfgpetclinic.services.VisitService;

@AllArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetService petService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;
	
	@Override
	public void run(String... args) throws Exception {
		if (petService.findAll().size() == 0) {
			creerProprietaires();
			creerVeterinaires();
			creerVisites();
		}
	}

	private void creerProprietaires() {
		gererProprietaire01();
		gererProprietaire02();
		System.out.println("Loaded Owners...");
	}
	
	private void creerVeterinaires() {
		Speciality specialiteRadiologie = sauvegarderEtRecupererSpecialite("Radiology");
		Speciality specialiteDentiste = sauvegarderEtRecupererSpecialite("Dentistry");
		Speciality specialiteChirurgie = sauvegarderEtRecupererSpecialite("Surgery");

		List<Speciality> listeSpecialiteVeterinaire01 = new ArrayList<>();
		listeSpecialiteVeterinaire01.add(specialiteRadiologie);
		
		List<Speciality> listeSpecialiteVeterinaire02 = new ArrayList<>();
		listeSpecialiteVeterinaire02.add(specialiteDentiste);
		listeSpecialiteVeterinaire02.add(specialiteChirurgie);
		
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
	
	private Speciality sauvegarderEtRecupererSpecialite(String nomSpecialite) {
		Speciality specialite = new Speciality();
		specialite.setDescription(nomSpecialite);
		return specialityService.save(specialite);
	}
	
	private void creerVisites() {
		Pet fido = petService.findById(1L);
		
		Visit visitFido = new Visit();
		visitFido.setPet(fido);
		visitFido.setDate(LocalDate.of(2022, 12, 15));
		visitFido.setDescription("Visite Fido");
		
		visitService.save(visitFido);
		
		Pet felix = petService.findById(2L);
		
		Visit visitFelix = new Visit();
		visitFelix.setPet(felix);
		visitFelix.setDate(LocalDate.of(2022, 12, 15));
		visitFelix.setDescription("Visite Felix");
		
		visitService.save(visitFelix);
		
		System.out.println("Loaded Visits...");
	}
	
}
