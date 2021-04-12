package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
public class Person extends BaseEntity {

    Person(Long id, String firstName, String lastName){
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    if not specified hibernate by default will do it
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public Person() {
        super();
    }
}
