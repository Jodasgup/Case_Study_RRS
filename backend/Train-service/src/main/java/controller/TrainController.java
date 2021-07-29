package controller;

import java.util.List;

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

import entity.Train;
import lombok.extern.slf4j.Slf4j;
import service.TrainService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/trains")
@Slf4j
public class TrainController {

	@Autowired
	private TrainService trainService;
	
	final Logger logger = LoggerFactory.getLogger(TrainController.class);
	
	@PostMapping("/")
	public Train saveTrain(@RequestBody Train train) {
		logger.info("Inside saveTrain method of TrainController");
		return trainService.saveTrain(train);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public Train findTrainByTrainId(@PathVariable String id) {
		logger.info("Inside findTrainByTrainId method of TrainController");
		return trainService.findByTrainId(id);
	}

	@GetMapping("/all")
	public List<Train> findAllTrain() {
		logger.info("Inside findAllRoom method of TrainController");
		return trainService.findAllTrain();
	}
	)
	@DeleteMapping("/delete/{id}")
	public String deleteTrain(@PathVariable String id) {
		logger.info("Inside deleteTrain method of TrainController");
		trainService.deleteById(id);
		return "Room deleted with TrainNo : "+id;
	}
	
	@PutMapping("/updateRoom")
	public Train updateTrain(@RequestBody Train updatedTrain) {
		logger.info("Inside updateRoom method of RoomController");
		return trainService.updateTrain(updatedTrain);
	}
}