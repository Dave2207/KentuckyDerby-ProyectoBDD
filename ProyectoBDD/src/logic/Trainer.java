package logic;

public class Trainer {
	
	private int TrainerID;
	private String FirstName; 
	private String LastName;
	private String StateResidence;
	
public Trainer(int trainerID, String firstName, String lastName, String stateResidence) {
		super();
		TrainerID = trainerID;
		FirstName = firstName;
		LastName = lastName;
		StateResidence = stateResidence;
	}
	//	*** Getters & Setters****
	public int getTrainerID() {
		return TrainerID;
	}
	public void setTrainerID(int trainerID) {
		TrainerID = trainerID;
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
	public String getStateResidence() {
		return StateResidence;
	}
	public void setStateResidence(String stateResidence) {
		StateResidence = stateResidence;
	}
	
}
