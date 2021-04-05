package org.cnu.realcoding.service;

import lombok.Getter;
import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exception.DogNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogManagementService {

    @Getter
    private List<Dog> dogs=new ArrayList<>();

    public void insertDog(Dog dog) {
        for(Dog dog1 : dogs){
            if(dogs.equals(dog.getName()) && dogs.equals(dog.getOwnerName()) && dogs.equals(dog.getOwnerPhoneNumber())){
                //XXX http status return
            }else{
                dogs.add(dog);
            }
        }
    }


    public Dog getDogByname(String name) {
        for (Dog dog : dogs) {
            if (dog.getName().equals(name)) {
                return dog;
            }
        }
        throw new DogNotFoundException();
    }
    //add
    public Dog getDogbyOwnerName(Dog ownerName){
        for(Dog dog : dogs) {
            if(dog.getOwnerName().equals(ownerName)) {
                return dog;
            }
        }
        throw new DogNotFoundException();
    }
    //add
    public Dog getDogbyOwnerPhoneNumber(Dog ownerPhoneNumber) {
        for(Dog dog : dogs){
            if(dog.getOwnerPhoneNumber().equals(ownerPhoneNumber)) {
                return dog;
            }
        }
        throw new DogNotFoundException();
    }
    //add
    public Dog getDogbyAllinf(Dog name, Dog ownerName, Dog ownerPhoneNumber) {
        for(Dog dog : dogs){
            if(dog.getName().equals(name) && dog.getOwnerName().equals(ownerName) && dog.getOwnerPhoneNumber().equals(ownerPhoneNumber)){
                return dog;
            }
        }
        throw new DogNotFoundException();
    }
    //add
    public void modifyKind(Dog kind) {
    }
    //add
    public void addRecord(Dog record) {
    }

}
