package com.example.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Train;

public interface TrainRepository extends MongoRepository<Train, String> {




}
