package org.cnu.realcoding.myfirstspringbootapp6.Service;

import lombok.Getter;
import org.cnu.realcoding.myfirstspringbootapp6.domain.Dog;
import org.cnu.realcoding.myfirstspringbootapp6.exception.DogNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogManagementService {

    @Getter
    private List<Dog> dogs=new ArrayList<>();

    public void insertDog(Dog dog) {//이미 존재할 경우 특정에러 리턴
        for(Dog dog1 : dogs){
            if(dog1.getName().equals(dog.getName()) || dog1.getOwnerName().equals(dog.getOwnerName()) || dog1.getOwnerPhoneNumber().equals(dog.getOwnerPhoneNumber())){
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
