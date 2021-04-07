package org.cnu.realcoding.myfirstspringbootapp6.repository;
import org.cnu.realcoding.myfirstspringbootapp6.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

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

    public Dog updateDogAllInfo(String name, String ownerName, String ownerPhoneNumber, Dog dog){
        Update update = new Update();   // 업데이트 할 객체 생성
        update.set("name",dog.getName());
        update.set("kind", dog.getKind());
        update.set("ownerName", dog.getOwnerName());
        update.set("ownerPhoneNumber", dog.getOwnerPhoneNumber());
        //조건식 만족하면 업데이트 아니면 null 반환
        return mongoTemplate.findAndModify(Query.query(Criteria.where("name").is(name)
                        .and("ownerName").is(ownerName)
                        .and("ownerPhoneNumber").is(ownerPhoneNumber)
                        .and("medicalRecords").is(dog.getMedicalRecords())),    // 진료기록 수정시 null 반환
                update, Dog.class);
    }
}

