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


    public void insertDog(Dog dog) {    //값 입력
        Dog fdog=dogRepository.findDogByAllInf(dog.getName(),dog.getOwnerName(),dog.getOwnerPhoneNumber());
        if (fdog==null) dogRepository.insertDog(dog);
        else {
            if (fdog.getName().equals(dog.getName()) &&
                    fdog.getName().equals(dog.getName()) &&
                    fdog.getName().equals(dog.getName())) {
                throw new ExistingDogException();
            }
            else{
                dogRepository.insertDog(dog);
            }
        }
    }
    public List<Dog> getAllDogs() { //개 전체 조회
        List<Dog> dog = dogRepository.findAllDog();
        if (dog.isEmpty()) throw new DogNotFoundException();
        return dog;
    }

    public List<Dog> getDogByName(String name) {    //개이름으로 조회
        List<Dog> dog = dogRepository.findDogByName(name);
        if (dog.isEmpty()) throw new DogNotFoundException();
        return dog;
    }

    public List<Dog> getDogByOwnerName(String ownerName) {  //주인이름으로 조회
        List<Dog> dog = dogRepository.findDogByOwnerName(ownerName);
        if (dog.isEmpty()) throw new DogNotFoundException();
        return dog;
    }

    public List<Dog> getDogByOwnerPhoneNumber(String ownerPhoneNumber) {    //폰번호로 조회
        List<Dog> dog = dogRepository.findDogByOwnerPhoneNumber(ownerPhoneNumber);
        if (dog.isEmpty()) throw new DogNotFoundException();
        return dog;
    }

    public Dog getDogByAllInf(String name, String ownerName, String ownerPhoneNumber) { //모든 정보로 조회
        Dog dog = dogRepository.findDogByAllInf(name,ownerName,ownerPhoneNumber);
        if (dog==null) throw new DogNotFoundException();
        return dog;
    }

    public void AddMedicalRecords(String name, String ownerName, String ownerPhoneNumber, String newRecords) {
    Dog dog = dogRepository.findDogByAllInf(name,ownerName,ownerPhoneNumber);
    if(dog==null) throw new DogNotFoundException();
    dogRepository.AddRecords(name,ownerName,ownerPhoneNumber,newRecords);
}

    public void patchDogByKind(String name, String ownerName, String ownerPhoneNumber, String ChangeKind) { //강아지의 종을 바꿈
        Dog dog = dogRepository.findDogByAllInf(name,ownerName,ownerPhoneNumber);
        if(dog==null) throw new DogNotFoundException();
        dogRepository.PatchDogByKind(name,ownerName,ownerPhoneNumber,ChangeKind);
    }

    // 강아지 정보를 통째로 덮어쓰는 메소드
    public void putDogAllInfo(String name, String ownerName, String ownerPhoneNumber, Dog newDog){
        Dog dog = dogRepository.updateDogAllInfo(name, ownerName, ownerPhoneNumber, newDog);
        if(dog == null){
            throw new DogNotFoundException();
        }
    }

}