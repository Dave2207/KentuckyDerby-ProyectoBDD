package logic;

public class Employee {
	
	private int ID;
	private String FirstName; 
	private String LastName; 
	private int Age; 
	private String Birthday; 
	private String Gender; 
	private String Position; 
	private int ZIP_code;
	
	public Employee(int iD, String firstName, String lastName, int age, String birthday, String gender, String position,
			int zIP_code) {
		super();
		ID = iD;
		FirstName = firstName;
		LastName = lastName;
		Age = age;
		Birthday = birthday;
		Gender = gender;
		Position = position;
		ZIP_code = zIP_code;
	}
	// ***Setters & Getters***
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public int getZIP_code() {
		return ZIP_code;
	}
	public void setZIP_code(int zIP_code) {
		ZIP_code = zIP_code;
	}
	
}
