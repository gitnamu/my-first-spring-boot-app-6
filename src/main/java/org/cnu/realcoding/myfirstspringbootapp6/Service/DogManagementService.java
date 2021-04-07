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

    public void insertDog(Dog dog) {

        //dogs.add(dog);
        int token = 0;              //리스트안에 중복값이 없다면 토큰 0 있으면 1
        if (dogs.size()==0) {       //리스트가 비어있으면 바로 추가
            dogs.add(dog);
        } else {
            for (Dog dog1 : dogs) { //중복값있는지 체크
                if (dog1.getName().equals(dog.getName()) && dog1.getOwnerName().equals(dog.getOwnerName()) && dog1.getOwnerPhoneNumber().equals(dog.getOwnerPhoneNumber())) {
                    //XXX http status return
                    token=1;
                    break;
                }
            }
            if (token==0) dogs.add(dog);    //중복값 없으니 추가

        }
    }

    public List<Dog> getDogByname(String name) {
        List<Dog> getdogs=new ArrayList<>();
        for (Dog dog : dogs) {
            if (dog.getName().equals(name)) {
                getdogs.add(dog);
            }
        }
        if (getdogs.size()==0) throw new DogNotFoundException();
        return getdogs;
    }
    public List<Dog> getDogByOwnerName(String ownerName){
        List<Dog> getdogs=new ArrayList<>();
        for(Dog dog : dogs) {
            if(dog.getOwnerName().equals(ownerName)) {
                getdogs.add(dog);
            }
        }
        if (getdogs.size()==0) throw new DogNotFoundException();
        return getdogs;
    }
    public List<Dog> getDogByOwnerPhoneNumber(String ownerPhoneNumber) {
        List<Dog> getdogs=new ArrayList<>();
        for(Dog dog : dogs){
            if(dog.getOwnerPhoneNumber().equals(ownerPhoneNumber)) {
                getdogs.add(dog);
            }
        }
        if (getdogs.size()==0) throw new DogNotFoundException();
        return getdogs;
    }
    public Dog getDogByAllInf(String name, String ownerName, String ownerPhoneNumber) {
        for(Dog dog : dogs){
            if(dog.getName().equals(name) && dog.getOwnerName().equals(ownerName) && dog.getOwnerPhoneNumber().equals(ownerPhoneNumber)){
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
