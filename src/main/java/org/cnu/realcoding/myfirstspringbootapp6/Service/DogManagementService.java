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
    private List<Dog> dogs;
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
            else throw new ExistingDogException();
        }
        //dogRepository.insertDog(dog);
    }
    public List<Dog> getAllDogs() {
        return dogRepository.findAllDog();
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