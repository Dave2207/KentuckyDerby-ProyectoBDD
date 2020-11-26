package logic;

import java.util.ArrayList;

public class Derby {
	private ArrayList<Employee> employees;
	private ArrayList<Horse> horses;
	private ArrayList<Jockey> jockeys;
	private ArrayList<Owner> owners;
	private ArrayList<Trainer> trainers;
	private static int genCodEmp = 1;
	private static int genCodJockey = 1;
	private static int genCodOwner = 1;
	private static int genCodTrainer = 1;
	private static Derby derb = null;
	
	private Derby() {
		super();
		this.employees = new ArrayList<Employee>();
		this.horses = new ArrayList<Horse>();
		this.jockeys = new ArrayList<Jockey>();
		this.owners = new ArrayList<Owner>();
		this.trainers = new ArrayList<Trainer>();
	}
	
	public static Derby getInstance() {
		if(derb==null) {
			derb = new Derby();
		}
		return derb;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public ArrayList<Horse> getHorses() {
		return horses;
	}

	public void setHorses(ArrayList<Horse> horses) {
		this.horses = horses;
	}

	public ArrayList<Jockey> getJockeys() {
		return jockeys;
	}

	public void setJockeys(ArrayList<Jockey> jockeys) {
		this.jockeys = jockeys;
	}

	public ArrayList<Owner> getOwners() {
		return owners;
	}

	public void setOwners(ArrayList<Owner> owners) {
		this.owners = owners;
	}

	public ArrayList<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(ArrayList<Trainer> trainers) {
		this.trainers = trainers;
	}
	
	public void registrarEmpleado(Employee employee) {
		employees.add(employee);
	}
	public void eliminarEmpleado(Employee employee) {
		employees.remove(employee);
	}
	public void registrarCaballo(Horse horse) {
		horses.add(horse);
	}
	public void eliminarCaballo(Horse horse) {
		horses.remove(horse);
	}
	public void registrarOwner(Owner owner) {
		owners.add(owner);
		genCodOwner++;
	}
	public void eliminarOwner(Owner owner) {
		owners.remove(owner);
		genCodOwner--;
	}
	public void registrarJockey(Jockey jockey) {
		jockeys.add(jockey);
		genCodJockey++;
	}
	public void eliminarJockey(Jockey jockey) {
		jockeys.remove(jockey);
		genCodJockey--;
	}

	public static int getGenCodJockey() {
		return genCodJockey;
	}

	public static void setGenCodJockey(int genCodJockey) {
		Derby.genCodJockey = genCodJockey;
	}

	public static int getGenCodEmp() {
		return genCodEmp;
	}

	public static void setGenCodEmp(int genCodEmp) {
		Derby.genCodEmp = genCodEmp;
	}

	public static int getGenCodOwner() {
		return genCodOwner;
	}

	public static void setGenCodOwner(int genCodOwner) {
		Derby.genCodOwner = genCodOwner;
	}

	public static int getGenCodTrainer() {
		return genCodTrainer;
	}

	public static void setGenCodTrainer(int genCodTrainer) {
		Derby.genCodTrainer = genCodTrainer;
	}

	public void registrarTrainer(Trainer tra) {
		trainers.add(tra);
		genCodTrainer++;
	}
	
	public void eliminarTrainer(Trainer tra) {
		trainers.remove(tra);
		genCodTrainer--;
	}
}
