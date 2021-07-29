package com.example.demo.resources;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.*;
import com.example.demo.repository.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/search")
public class UserController {
	
	@Autowired
	private TrainRepository trainrepository;

    @GetMapping("/findAllTrains")
    public List<Train> getTrains(){
	return trainrepository.findAll();
	
}
    @GetMapping("/findAllTrains/{trainid}")
    public Optional<Train> getTrains(@PathVariable String trainid){
	return trainrepository.findById(trainid);
}
	
}