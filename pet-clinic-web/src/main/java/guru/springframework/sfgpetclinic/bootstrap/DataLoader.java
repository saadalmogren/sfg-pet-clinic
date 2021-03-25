package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("saad");
        owner1.setLastName("almogren");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("ali");
        owner2.setLastName("moh");

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
