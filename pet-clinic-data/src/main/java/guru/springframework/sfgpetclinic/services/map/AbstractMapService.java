package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

// T must be BaseEntity or Extends it. ID must be Long or extends it
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }
    T findById(ID id){
        return map.get(id);
    }
    T save(T object){
        if(object != null) {
//            to assign an id to the object
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }else{
            throw new RuntimeException("Object can not be null");
        }
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
//        remove entry from the set if entry equals object
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
    private Long getNextId(){
        Long nextId = null;
//        if the map is empty assign the id 1 if not get the largest id and increment it by 1
        try{
            nextId = Collections.max(map.keySet()) +1;
        }catch (NoSuchElementException e){
            nextId = 1L;
        }

        return nextId;
    }
}
