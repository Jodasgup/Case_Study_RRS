package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;
import com.example.demo.service.TrainService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;



@SpringBootTest
@RunWith(SpringRunner.class)
class TrainApplicationTests {
	
	@Autowired
	private TrainService trainService;
	
	@MockBean
	private TrainRepository trainrepository;

	@Test
	public void getTrainTest() {
		when(trainrepository.findAll()).thenReturn(Stream
				.of(new Train("12","Howrah local","Bandel","Howrah"), new Train("12","Jagannath Express","Howrah","Puri")).collect(Collectors.toList()));
		assertEquals(2,trainService.getContact().size());
	}
		@Test
		public void saveTrainTest() {
			Train train = new Train("877","Sonarpur Local","Sealdah","Sonarpur");
			when(trainrepository.save(train)).thenReturn(train);
			assertEquals(train, trainService.addTrain(train));
		
		}
		@Test
		public void deleteUserTest() {
			Train train = new Train("12","Howrah local","Bandel","Howrah");
			trainService.deleteTrain(train);
			verify(trainrepository, times(1)).delete(train);
		}


}