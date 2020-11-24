package logic;

public class Race {
	private int raceID;
	private int distance;
	private String raceType;
	private String raceDate;
	private String raceTime;
	private String weather;
	
	public Race(int raceID, int distance, String raceType, String raceDate, String raceTime, String weather) {
		super();
		this.raceID = raceID;
		this.distance = distance;
		this.raceType = raceType;
		this.raceDate = raceDate;
		this.raceTime = raceTime;
		this.weather = weather;
	}

	public int getRaceID() {
		return raceID;
	}

	public void setRaceID(int raceID) {
		this.raceID = raceID;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getRaceType() {
		return raceType;
	}

	public void setRaceType(String raceType) {
		this.raceType = raceType;
	}

	public String getRaceDate() {
		return raceDate;
	}

	public void setRaceDate(String raceDate) {
		this.raceDate = raceDate;
	}

	public String getRaceTime() {
		return raceTime;
	}

	public void setRaceTime(String raceTime) {
		this.raceTime = raceTime;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}
}
