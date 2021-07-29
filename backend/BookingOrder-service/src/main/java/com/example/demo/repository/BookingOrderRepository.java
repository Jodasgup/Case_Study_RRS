package com.example.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.BookingOrder;

public interface BookingOrderRepository extends MongoRepository<BookingOrder, String> {

	

}
