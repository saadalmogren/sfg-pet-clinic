package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("saad");
        owner1.setLastName("almogren");
        owner1.setAddress("Riyadh");
        owner1.setCity("Riyadh");
        owner1.setTelephone("9999999");
        Pet saadsPet = new Pet();
        saadsPet.setPetType(saveDogPetType);
        saadsPet.setOwner(owner1);
        saadsPet.setBirthDate(LocalDate.now());
        saadsPet.setName("Max");
        owner1.getPets().add(saadsPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("ali");
        owner2.setLastName("moh");
        owner2.setAddress("Riyadh");
        owner2.setCity("Riyadh");
        owner2.setTelephone("9999999");
        Pet alisPet = new Pet();
        alisPet.setPetType(saveCatPetType);
        alisPet.setOwner(owner2);
        alisPet.setBirthDate(LocalDate.now());
        alisPet.setName("Saddah");
        owner2.getPets().add(alisPet);
        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("testVet");
        vet1.setLastName("testVet");

        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("testVet2");
        vet2.setLastName("testVet2");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
