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
    private List<Dog> dogs = new ArrayList<>();

    public void insertDog(Dog dog) {
        //dogs.add(dog);
        int token = 0;              //리스트안에 중복값이 없다면 토큰 0 있으면 1
        if (dogs.size() == 0) {       //리스트가 비어있으면 바로 추가
            dogs.add(dog);
        } else {
            for (Dog dog1 : dogs) { //중복값있는지 체크
                if (dog1.getName().equals(dog.getName()) && dog1.getOwnerName().equals(dog.getOwnerName()) && dog1.getOwnerPhoneNumber().equals(dog.getOwnerPhoneNumber())) {
                    //XXX http status return
                    token = 1;
                    break;
                }
            }
            if (token == 0) dogs.add(dog);    //중복값 없으니 추가
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

    public Dog getDogByOwnerName(String ownerName) {
        for (Dog dog : dogs) {
            if (dog.getOwnerName().equals(ownerName)) {
                return dog;
            }
        }
        throw new DogNotFoundException();
    }

    public Dog getDogByOwnerPhoneNumber(String ownerPhoneNumber) {
        for (Dog dog : dogs) {
            if (dog.getOwnerPhoneNumber().equals(ownerPhoneNumber)) {
                return dog;
            }
        }
        throw new DogNotFoundException();
    }

    public Dog getDogByAllInf(String name, String ownerName, String ownerPhoneNumber) {
        for (Dog dog : dogs) {
            if (dog.getName().equals(name) && dog.getOwnerName().equals(ownerName) && dog.getOwnerPhoneNumber().equals(ownerPhoneNumber)) {
                return dog;
            }
        }
        throw new DogNotFoundException();
    }

    public Dog patchDogByKind(String name, String ownerName, String ownerPhoneNumber, String ChangeKind) {
        for (Dog dog : dogs) {
            if (dog.getName().equals(name) && dog.getOwnerName().equals(ownerName) && dog.getOwnerPhoneNumber().equals(ownerPhoneNumber)) {
                dog.setKind(ChangeKind);
                return dog;
            }
        }
        throw new DogNotFoundException();
    }
}