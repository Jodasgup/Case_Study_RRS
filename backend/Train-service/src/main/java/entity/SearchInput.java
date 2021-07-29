package entity;


import org.springframework.data.annotation.Id;

public class SearchInput {

	@Id
	private String id;
	private String startStation;
	private String endStation;
	private String date;
	
	public SearchInput() {
		
	}
	
	public SearchInput(String id, String startStation, String endStation, String date) {
		super();
		this.id = id;
		this.startStation = startStation;
		this.endStation = endStation;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getEndStation() {
		return endStation;
	}

	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
