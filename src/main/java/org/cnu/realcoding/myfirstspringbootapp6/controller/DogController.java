package org.cnu.realcoding.myfirstspringbootapp6.controller;

import org.cnu.realcoding.myfirstspringbootapp6.Service.DogManagementService;
import org.cnu.realcoding.myfirstspringbootapp6.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {

    @Autowired
    private DogManagementService dogManagementService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/dogs")
    public void createDogs(@RequestBody Dog dog){   //신규 방문 강아지 등록
        dogManagementService.insertDog(dog);
    }

    @GetMapping("/dogs")
    public List<Dog> getAllDogs(){
        return dogManagementService.getDogs();
    }


    //localhost:8080/dogs/[name]
    @GetMapping("/dogs/name/{name}")
    public Dog getDogByName(@PathVariable String name) { return dogManagementService.getDogByName(name); }

    @GetMapping("/dogs/ownerName/{OwnerName}")
    public Dog getDogByOwnerName(@PathVariable String OwnerName) { return dogManagementService.getDogByOwnerName(OwnerName); }

    @GetMapping("/dogs/OwnerPhoneNumber/{OwnerPhoneNumber}")
    public Dog getDogByOwnerPhoneNumber(@PathVariable String OwnerPhoneNumber) { return dogManagementService.getDogByOwnerPhoneNumber(OwnerPhoneNumber); }

    @GetMapping("/dogs/AllInf/{name},{OwnerName},{OwnerPhoneNumber}")
    public Dog getDogByAllInf(@PathVariable String name, String OwnerName, String OwnerPhoneNumber) { return dogManagementService.getDogByAllInf(name, OwnerName, OwnerPhoneNumber); }

    @PatchMapping("/dogs/AllInf/{name},{OwnerName},{OwnerPhoneNumber},{Kind}")
    public Dog patchDogbyKind(@PathVariable String name, String OwnerName, String OwnerPhoneNumber, String ChangeKind, @RequestBody Dog patchDog) { return dogManagementService.patchDogByKind(name, OwnerName, OwnerPhoneNumber, ChangeKind); }

    @PutMapping("/dogs/updateAll/{name},{newName},{newOwnerName},{newOwnerPhoneNumber},{newKind}")
    public void putDogAllInfo(@PathVariable String name, @RequestBody Dog dog) {
        dogManagementService.putDogAllInfo(name, dog);
    }

    @PatchMapping("/dogs/medicalRecord/{name},{medicalRecord}")
    public void patchDogMedicalRecords(@PathVariable String name, String medicalRecord) {
        dogManagementService.patchDogMedicalRecords(name, medicalRecord);
    }
}