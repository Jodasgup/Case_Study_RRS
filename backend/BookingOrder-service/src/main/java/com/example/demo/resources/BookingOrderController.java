package com.example.demo.resources;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookingOrder;
import com.example.demo.repository.BookingOrderRepository;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/orders")
public class BookingOrderController {
	
	@Autowired
	private BookingOrderRepository bookrepository;

	@PostMapping("/addOrder")
	public String saveBook(@RequestBody BookingOrder book) {
	bookrepository.save(book);
	return "Booked ticket with id :  " + book.getId();
    }
	@GetMapping("/{id}")
	public Optional<BookingOrder> getBook(@PathVariable String id){
		return bookrepository.findById(id);
	}
	@PutMapping("/update/{id}")
	public BookingOrder updateOrder(@PathVariable("id") String id,@RequestBody BookingOrder order ) {
		order.setId(id);
		bookrepository.save(order);
		return order;
	}
		
	 @DeleteMapping("/del/{id}")
	 public String deleteOrder (@PathVariable String id) {
	  bookrepository.deleteById(id);
		return "Order deleted with id : "+id;
		}
	}

