package repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import entity.Train;



public interface TrainRepository extends MongoRepository<Train, String>{


}