package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Train;
import lombok.extern.slf4j.Slf4j;
import repository.TrainRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Slf4j
public class TrainService {

	@Autowired
	private TrainRepository trainRepository;
	
	final Logger logger = LoggerFactory.getLogger(TrainService.class);

	public Train saveRoom(Train room) {
		logger.info("Inside saveRoom of RoomService");
		return trainRepository.save(room);
	}

	public Train findByRoomNo(String id) {
		logger.info("Inside findByRoomNo of RoomService");
		return trainRepository.findById(id).orElse(null);
	}

	public List<Train> findAllRoom() {
		logger.info("Inside findAllRoom of RoomService");
		return trainRepository.findAll();
	}

	public void deleteById(String id) {
		logger.info("Inside deleteById of RoomService");
		trainRepository.deleteById(id);
		
	}

	public Train updateRoom(Train updatedRoom) {
		logger.info("Inside updateRoom of RoomService");
		Train room = trainRepository.findById(updatedRoom.getRoomId()).orElse(null);
		room.setRoomName(updatedRoom.getRoomName());
		room.setRoomNo(updatedRoom.getRoomNo());
		room.setRoomFloor(updatedRoom.getRoomFloor());
		room.setCheckIn(updatedRoom.getCheckIn());
		room.setCheckOut(updatedRoom.getCheckOut());
		room.setStatus(updatedRoom.getStatus());
		room.setPrice(updatedRoom.getPrice());
		
		trainRepository.save(room);
		return room;
	}
	
	
}