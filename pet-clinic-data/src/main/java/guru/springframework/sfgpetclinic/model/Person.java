package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
public class Person extends BaseEntity {
//    if not specified hibernate by default will do it
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
