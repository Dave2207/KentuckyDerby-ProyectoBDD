package logic;

public class Jockey {
	
	private int JockeyID;
	private String FirstName; 
	private String LastName; 
	private String Gender; 
	private String StateResidence; 
	private int WonRaces; 
	private int YearsOfExp;
	private int JockeyWeight;
	
	public Jockey(int jockeyID, String firstName, String lastName, String gender, String stateResidence, int wonRaces,
			int yearsOfExp, int jockeyWeight) {
		super();
		JockeyID = jockeyID;
		FirstName = firstName;
		LastName = lastName;
		Gender = gender;
		StateResidence = stateResidence;
		WonRaces = wonRaces;
		YearsOfExp = yearsOfExp;
		JockeyWeight = jockeyWeight;
	}
	// ***Setters & Getters***
	public int getJockeyID() {
		return JockeyID;
	}
	public void setJockeyID(int jockeyID) {
		JockeyID = jockeyID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getStateResidence() {
		return StateResidence;
	}
	public void setStateResidence(String stateResidence) {
		StateResidence = stateResidence;
	}
	public int getWonRaces() {
		return WonRaces;
	}
	public void setWonRaces(int wonRaces) {
		WonRaces = wonRaces;
	}
	public int getYearsOfExp() {
		return YearsOfExp;
	}
	public void setYearsOfExp(int yearsOfExp) {
		YearsOfExp = yearsOfExp;
	}
	public int getJockeyWeight() {
		return JockeyWeight;
	}
	public void setJockeyWeight(int jockeyWeight) {
		JockeyWeight = jockeyWeight;
	} 
	
	
}
