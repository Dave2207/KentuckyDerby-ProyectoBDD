package logic;

import java.util.ArrayList;

public class Derby {
	private ArrayList<Employee> employees;
	private ArrayList<Horse> horses;
	private ArrayList<Jockey> jockeys;
	private ArrayList<Owner> owners;
	private ArrayList<Trainer> trainers;
	private ArrayList<Race> races;
	private static int genCodEmp = 1;
	private static int genCodJockey = 1;
	private static int genCodOwner = 1;
	private static int genCodTrainer = 1;
	private static int genCodRace = 1;
	private static Derby derb = null;
	
	private Derby() {
		super();
		this.employees = new ArrayList<Employee>();
		this.horses = new ArrayList<Horse>();
		this.jockeys = new ArrayList<Jockey>();
		this.owners = new ArrayList<Owner>();
		this.trainers = new ArrayList<Trainer>();
		this.races = new ArrayList<Race>();
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
	
	public ArrayList<Race> getRaces() {
		return races;
	}

	public void setRaces(ArrayList<Race> races) {
		this.races = races;
	}
	
	public void registrarEmpleado(Employee employee) {
		employees.add(employee);
		genCodEmp++;
	}
	public void eliminarEmpleado(Employee employee) {
		employees.remove(employee);
		genCodEmp--;
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
	
	public void registrarRace(Race race) {
		races.add(race);
	}
	
	public void eliminarRace(Race race) {
		races.remove(race);
		genCodRace--;
		
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
	
	public static int getGenCodRace() {
		return genCodRace;
	}

	public static void setGenCodRace(int genCodRace) {
		Derby.genCodRace = genCodRace;
	}
	

	public void registrarTrainer(Trainer tra) {
		trainers.add(tra);
		genCodTrainer++;
	}
	
	public void eliminarTrainer(Trainer tra) {
		trainers.remove(tra);
		genCodTrainer--;
	}
	
	public Employee FindEmpByID(int id) {
		Employee emp = null;
		boolean found = false;
		int i = 0;
		while(!found && i<employees.size()) {
			if(employees.get(i).getID() == id) {
				emp = employees.get(i);
				found = true;
			}
			i++;
		}
		return emp;
	}
	public Owner FindOwnerByID(int id) {
		Owner own = null;
		boolean found = false;
		int i = 0;
		while(!found && i<owners.size()) {
			if(owners.get(i).getOwnerID() == id) {
				own = owners.get(i);
				found = true;
			}
			i++;
		}
		return own;
	}
	public Trainer FindTrainerByID(int id) {
		Trainer trainer = null;
		boolean found = false;
		int i = 0;
		while(!found && i<trainers.size()) {
			if(trainers.get(i).getTrainerID() == id) {
				trainer = trainers.get(i);
				found = true;
			}
			i++;
		}
		return trainer;
	}
	
	public Race FindRaceByID(int id) {
		Race race = null;
		boolean found = false;
		int i = 0;
		while(!found && i<races.size()) {
			if(races.get(i).getRaceID() == id) {
				race = races.get(i);
				found = true;
			}
			i++;
		}
		return race;
	}
	
	public Horse FindHorseByName(String name) {
		Horse horse = null;
		boolean found = false;
		int i = 0;
		while(!found && i<horses.size()) {
			if(horses.get(i).getHorseName().equalsIgnoreCase(name)) {
				horse = horses.get(i);
				found = true;
			}
			i++;
		}
		return horse;
	}
	
	public Jockey FindJockeyByID(int id) {
		Jockey jockey = null;
		boolean found = false;
		int i = 0;
		while(!found && i<jockeys.size()) {
			if(jockeys.get(i).getJockeyID() == id) {
				jockey = jockeys.get(i);
				found = true;
			}
			i++;
		}
		return jockey;
	}
}
