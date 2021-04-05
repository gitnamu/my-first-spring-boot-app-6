package org.cnu.realcoding.controller;

import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.service.DogManagementService;
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
    public void createDogs(@RequestBody Dog dog){
        dogManagementService.insertDog(dog);
    }
    //add
    public void getDogByOwnerName(@RequestBody Dog ownerName){
        dogManagementService.getDogbyOwnerName(ownerName);
    }
    //add
    public void getDogByOwnerPhoneNumber(@RequestBody Dog ownerPhoneNumber){
        dogManagementService.getDogbyOwnerPhoneNumber(ownerPhoneNumber);
    }
    //add
    public void getDogByAllinf(@RequestBody Dog name, Dog ownerName, Dog ownerPhoneNumber){
        dogManagementService.getDogbyAllinf(name,ownerName,ownerPhoneNumber);
    }
    //add
    public void modifyKind(@RequestBody Dog kind){
        dogManagementService.modifyKind(kind);
    }
    //add
    public void addRecord(@RequestBody Dog record){
        dogManagementService.addRecord(record);
    }
    //add
    public void modifyAll(@RequestBody Dog dog){

    }


    @GetMapping("/dogs")
    public List<Dog> getAllDogs(){
        return dogManagementService.getDogs();
    }

    //localhost:8080/dogs/[name]
    @GetMapping("/dogs/{name}")
    public void getDogByName(@PathVariable String name) {
        dogManagementService.getDogByname(name);
    }
}
