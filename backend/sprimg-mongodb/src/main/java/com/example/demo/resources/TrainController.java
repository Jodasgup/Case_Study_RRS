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

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/trains")
public class TrainController {
	
	@Autowired
	private TrainRepository trainrepository;

	@PostMapping("/addTrain")
	public String saveTrain(@RequestBody Train trainid) {
	trainrepository.save(trainid);
	return "Added train with id :  " + trainid.getTrainid();
    }
	
	@GetMapping("{trainid}")
	public Optional<Train> getTrain(@PathVariable String trainid){
		return trainrepository.findById(trainid);
	}
		
	@DeleteMapping("/delete/{trainid}")
	public String deleteTrain (@PathVariable String trainid) {
		trainrepository.deleteById(trainid);
		return "Train deleted with id : "+trainid;
    }
	@PutMapping("/update/{trainid}")
	public Train updateTrain(@PathVariable("trainid") String trainid,@RequestBody Train t ) {
		t.setTrainid(trainid);
		trainrepository.save(t);
		return t;
		
}
	
	
	
}

