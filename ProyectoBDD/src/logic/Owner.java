package logic;

public class Owner {
	
	private int OwnerID;
	private String FirstName; 
	private String LastName; 
	private String StateResidence;
	
	public Owner(int ownerID, String firstName, String lastName, String stateResidence) {
		super();
		OwnerID = ownerID;
		FirstName = firstName;
		LastName = lastName;
		StateResidence = stateResidence;
	}
	// ***Setters & Getters***
	public int getOwnerID() {
		return OwnerID;
	}
	public void setOwnerID(int ownerID) {
		OwnerID = ownerID;
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
