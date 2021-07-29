package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.SearchInput;
import entity.Train;
import lombok.extern.slf4j.Slf4j;
import repository.TrainRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/search")
@Slf4j
public class SearchController {

	@Autowired
	private TrainRepository trainRepository;
	
	final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@PostMapping("/room")
	public List<Train> searchRoom(@RequestBody SearchInput searchInput){
		logger.info("Inside searchRoom method of SearchController");
		List<Train> searchedRoom=new ArrayList<>();
		
		for(Train train : trainRepository.findAll()) {

			if((train.getSource().equals(searchInput.getStartStation()) && train.getStatus().equals("vacant")) || 
					(train.getSource().isEmpty() && train.getStatus().equals("vacant"))) {
				searchedTrain.add(train);
			}
		}
		
		return searchedTrain;
	}
}