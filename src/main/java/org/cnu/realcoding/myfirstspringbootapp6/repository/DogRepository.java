package org.cnu.realcoding.myfirstspringbootapp6.repository;
import org.cnu.realcoding.myfirstspringbootapp6.domain.Dog;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DogRepository {
    private MongoTemplate mongoTemplate;

    public Dog findDog(String name) {
        return mongoTemplate.findOne(Query.query(Criteria.where("name").is(name)),
                Dog.class
        );
    }

    public void insertDog(Dog dog) {
        mongoTemplate.insert(dog);
    }

    public List<Dog> findAllDog() {
        return mongoTemplate.findAll(Dog.class);
    }
}

