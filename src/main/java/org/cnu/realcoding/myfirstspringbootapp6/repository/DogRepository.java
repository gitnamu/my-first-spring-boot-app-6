package org.cnu.realcoding.myfirstspringbootapp6.repository;
import com.mongodb.client.result.UpdateResult;
import org.cnu.realcoding.myfirstspringbootapp6.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DogRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Dog findDogByAllInf(String name,String ownerName,String ownerPhoneNumber) {
        return mongoTemplate.findOne(Query.query(Criteria.where("name").is(name).and("ownerName").is(ownerName).and("ownerPhoneNumber").is(ownerPhoneNumber)),
                Dog.class
        );
    }

    public void insertDog(Dog dog) {
        mongoTemplate.insert(dog);
    }

    public List<Dog> findAllDog() {
        return mongoTemplate.findAll(Dog.class);
    }

    public List<Dog> findDogByName(String name) {
        return mongoTemplate.find(Query.query(Criteria.where("name").is(name)),
                Dog.class
        );

    }
    public List<Dog> findDogByOwnerName(String ownerName) {
        return mongoTemplate.find(Query.query(Criteria.where("ownerName").is(ownerName)),
                Dog.class
        );
    }

    public List<Dog> findDogByOwnerPhoneNumber(String ownerPhoneNumber) {
        return mongoTemplate.find(Query.query(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber)),
                Dog.class
        );
    }


    public UpdateResult patchDogMedicalRecords(String name, String ownerName, String ownerPhoneNumber, String medicalRecords) {
        /* <String> record = mongoTemplate.findOne(Query.query(Criteria.where("name").is(name).and("ownerName").is(ownerName).and("ownerPhoneNumber").is(ownerPhoneNumber)),
                Dog.class
        ).getMedicalRecords();
        record.add(medicalRecords);*/
        Update update = new Update();
        update.push("medicalRecords",medicalRecords);
        return mongoTemplate.updateFirst(Query.query(Criteria.where("name").is(name).and("ownerName").is(ownerName).and("ownerPhoneNumber").is(ownerPhoneNumber)),
                update, Dog.class);
    }
}

