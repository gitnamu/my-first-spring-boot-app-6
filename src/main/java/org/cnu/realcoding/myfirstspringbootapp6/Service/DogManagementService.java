package org.cnu.realcoding.myfirstspringbootapp6.Service;

import com.mongodb.client.result.UpdateResult;
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

    public void patchDogMedicalRecords(String name, String ownerName, String ownerPhoneNumber, String newRecord){
        //if (dogRepository.patchDogMedicalRecords(name,ownerName,ownerPhoneNumber,newRecord)==null)
       //     throw new DogNotFoundException();
        UpdateResult up=dogRepository.patchDogMedicalRecords(name,ownerName,ownerPhoneNumber,newRecord);
        if (up.getUpsertedId() == null)
            throw new DogNotFoundException();
    }
/*
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