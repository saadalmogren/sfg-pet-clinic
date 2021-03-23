package guru.springframework.sfgpetclinic.services;

import java.util.Set;
//to make the other services inherit the crud operations to remove duplicate methods
public interface CrudService<T, ID> {
    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
