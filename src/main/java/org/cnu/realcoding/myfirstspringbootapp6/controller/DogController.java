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
    public void createDogs(@RequestBody Dog dog){
        dogManagementService.insertDog(dog);
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
