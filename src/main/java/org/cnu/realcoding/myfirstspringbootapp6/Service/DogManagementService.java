package org.cnu.realcoding.myfirstspringbootapp6.Service;

import lombok.Getter;
import org.cnu.realcoding.myfirstspringbootapp6.domain.Dog;
import org.cnu.realcoding.myfirstspringbootapp6.exception.DogNotFoundException;
import org.cnu.realcoding.myfirstspringbootapp6.exception.ExistingDogException;
import org.cnu.realcoding.myfirstspringbootapp6.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogManagementService {

    @Autowired
    private DogRepository dogRepository;

    //@Getter
    //private List<Dog> dogs=new ArrayList<>();

    public void insertDog(Dog dog) {
        if (dogRepository.findDog(dog.getName()).getName().equals(dog.getName()))
            throw new DogNotFoundException();
        dogRepository.insertDog(dog);
    }
    public List<Dog> getAllDogs() {
        List<Dog> dog = dogRepository.findAllDog();
        if (dog==null) throw new DogNotFoundException();
        return dog;
    }

    public Dog getDogByName(String name) {
        /*for (Dog dog : dogs) {
            if (dog.getName().equals(name)) {
                return dog;
            }
        }*/
        Dog dog = dogRepository.findDog(name);
        if (dog==null) throw new DogNotFoundException();
        return dog;
    }
/*
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

    // 강아지 정보를 통째로 덮어쓰는 메소드
    public void putDogAllInfo(String name, Dog newDog){
        Dog originalDog = getDogByName(name);    // name의 이름을 가진 강아지 찾아서 originalDog에 저장
        newDog.setMedicalRecords(originalDog.getMedicalRecords());  // 이전 정보의 진료기록 보존
        dogs.remove(originalDog);    // 원래 정보 삭제
        dogs.add(newDog);   // 변경된 정보 리스트에 추가
    }

    // 진료기록 추가 메소드
    public void patchDogMedicalRecords(String name, String newRecord){
        Dog dog = getDogByName(name);   // name으로 강아지 찾아서 dog에 저장
        dog.getMedicalRecords().add(newRecord); // dog의 진료기록 리스트에 새로운 진료기록 추가

    }*/


}