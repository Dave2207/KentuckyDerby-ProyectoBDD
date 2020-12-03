package logic;

import java.util.ArrayList;


public class Derby {
	private ArrayList<Employee> employees;
	private ArrayList<Horse> horses;
	private ArrayList<Jockey> jockeys;
	private ArrayList<Owner> owners;
	private ArrayList<Trainer> trainers;
	private ArrayList<Race> races;
	private ArrayList<RaceEntry> entries;
	private ArrayList<Spectator> spectators;
	private ArrayList<Ticket> tickets;
	private static int genCodEmp = 1;
	private static int genCodJockey = 1;
	private static int genCodOwner = 1;
	private static int genCodTrainer = 1;
	private static int genCodRace = 1;
	private static int genCodRaceEntry = 1;
	private static int genCodSpectator = 1;
	private static int genCodTicket = 1;
	private static Derby derb = null;
	
	private Derby() {
		super();
		this.employees = new ArrayList<Employee>();
		this.horses = new ArrayList<Horse>();
		this.jockeys = new ArrayList<Jockey>();
		this.owners = new ArrayList<Owner>();
		this.trainers = new ArrayList<Trainer>();
		this.races = new ArrayList<Race>();
		this.entries = new ArrayList<RaceEntry>();
		this.spectators = new ArrayList<Spectator>();
		this.tickets = new ArrayList<Ticket>();
	
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

	
	public ArrayList<RaceEntry> getRaceEntrys() {
		return entries;
	}

	public void setRaceEntrys(ArrayList<RaceEntry> entries) {
		this.entries = entries;
	}

	public ArrayList<Spectator> getSpectators() {
		return spectators;
	}

	public void setSpectators(ArrayList<Spectator> spectators) {
		this.spectators = spectators;
	}
	
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
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
		genCodRace++;
	}
	
	public void eliminarRace(Race race) {
		races.remove(race);
		genCodRace--;
		
	}
	
	public void registrarRaceEntry(RaceEntry entry) {
		entries.add(entry);
		genCodRaceEntry++;
	}
	
	public void eliminarRaceEntry(RaceEntry entry) {
		entries.remove(entry);
		genCodRaceEntry--;
		
	}
	
	public void registrarSpectators(Spectator spectator) {
		spectators.add(spectator);
		genCodSpectator++;
	}
	
	public void eliminarSpectators(Spectator spectator) {
		spectators.remove(spectator);
		genCodSpectator--;
		
	}
	
	public void registrarTicket(Ticket ticket) {
		tickets.add(ticket);
	}
	
	public void eliminarTicket(Ticket ticket) {
		tickets.remove(ticket);
		genCodTicket--;
		
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
	
	public static int getGenCodRaceEntry() {
		return genCodRaceEntry;
	}

	public static void setGenCodRaceEntry(int genCodRaceEntry) {
		Derby.genCodRaceEntry = genCodRaceEntry;
	}
	
	public static int getGenCodSpectator() {
		return genCodSpectator;
	}

	public static void setGenCodSpectator(int genCodSpectator) {
		Derby.genCodSpectator = genCodSpectator;
	}

	public static int getGenCodTicket() {
		return genCodTicket;
	}

	public static void setGenCodTicket(int genCodTicket) {
		Derby.genCodTicket = genCodTicket;
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
	
	public RaceEntry FindRaceEntryByID(int id) {
		RaceEntry entry = null;
		boolean found = false;
		int i = 0;
		while(!found && i<entries.size()) {
			if(entries.get(i).getGateNumber() == id) {
				entry = entries.get(i);
				found = true;
			}
			i++;
		}
		return entry;
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
	
	public Spectator FindSpectatorByID(int id) {
		Spectator spectator = null;
		boolean found = false;
		int i = 0;
		while(!found && i<spectators.size()) {
			if(spectators.get(i).getTicketNo() == id) {
				spectator = spectators.get(i);
				found = true;
			}
			i++;
		}
		return spectator;
	}
	
	public Ticket FindTicketByID(int id) {
		Ticket ticket = null;
		boolean found = false;
		int i = 0;
		while(!found && i<tickets.size()) {
			if(tickets.get(i).getCode() == id) {
				ticket = tickets.get(i);
				found = true;
			}
			i++;
		}
		return ticket;
	}
	
}
