package org.cnu.realcoding.myfirstspringbootapp6.controller;

import org.cnu.realcoding.myfirstspringbootapp6.domain.Dog;
import org.cnu.realcoding.myfirstspringbootapp6.Service.DogManagementService;
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
    public List<Dog> getDogByName(@PathVariable String name) {
        return dogManagementService.getDogByname(name);
    }

    @GetMapping("/dogs/ownerName/{OwnerName}")
    public List<Dog> getDogByOwnerName(@PathVariable String OwnerName) {
        return dogManagementService.getDogByOwnerName(OwnerName);
    }

    @GetMapping("/dogs/OwnerPhoneNumber/{OwnerPhoneNumber}")
    public List<Dog> getDogByOwnerPhoneNumber(@PathVariable String OwnerPhoneNumber) {
        return dogManagementService.getDogByOwnerPhoneNumber(OwnerPhoneNumber);
    }

    @GetMapping("/dogs/AllInf/{name},{OwnerName},{OwnerPhoneNumber}")
    public Dog getDogByAllInf(@PathVariable String name, String OwnerName, String OwnerPhoneNumber) {
        return dogManagementService.getDogByAllInf(name, OwnerName, OwnerPhoneNumber);
    }
}
