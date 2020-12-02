package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabaseConnection {

	public static void main(String[] args) {
		//registrarEmpleadoSQL("David", "Vasquez", 21, "22-7-1999", "M", "LOL", 51000);
		ModificarEmpleadoSQL("Jose", "Cabrera", 54, "1-1-1950", "M", "Manager", 51000, 7);
	}
	///INSERTAR
	public static void registrarEmpleadoSQL(
//			int ID,
			String firstName,
			String lastName,
			int age,
			String birthday,
			String gender,
			String Position,
			int ZIP_Code) {
//		int id = ID;
		String nombre = firstName;
		String apellido = lastName;
		int edad = age;
		String fechaNac = birthday;
		String genero = gender;
		String pos = Position;
		int ZIP = ZIP_Code;
		
		
		Connection con = null;
		
		try {
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			con = DriverManager.getConnection(dbURL, user, pass);
			if(con != null) {
				System.out.println("Conexion establecida");
			}
			
			try (Statement stmt = con.createStatement()){
				String sqlQuery = "INSERT INTO Employee (FirstName,LastName,Age,Birthday,Gender,Position,ZIP_Code)"+" VALUES(?,?,?,?,?,?,?)";
				PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
//				prepStmt.setInt(1, id);
				prepStmt.setString(1, nombre);
				prepStmt.setString(2, apellido);
				prepStmt.setInt(3, edad);
				prepStmt.setString(4, fechaNac);
				prepStmt.setString(5, genero);
				prepStmt.setString(6, pos);
				prepStmt.setInt(7, ZIP);
				prepStmt.executeUpdate();
				prepStmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
//
	public static void registrarCaballoSQL(
			String HorseName,
			String Establo,
			String Gender,
			int Age,
			String Gear,
			int Score,
			int WonRaces,
			String Breed) {
		String nombre = HorseName;
		String establo = Establo;
		String gen = Gender;
		int edad = Age;
		String gear = Gear;
		int score = Score;
		int won_races = WonRaces;
		String breed = Breed;
		
		
		
		Connection con = null;
		
		try {
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			con = DriverManager.getConnection(dbURL, user, pass);
			if(con != null) {
				System.out.println("Conexion establecida");
			}
			
			try (Statement stmt = con.createStatement()){
				String sqlQuery = "INSERT INTO Horse ([horseName],Barn,Gender,Age,Gear,Score,WonRaces,Breed)"+" VALUES(?,?,?,?,?,?,?,?)";
				PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
				prepStmt.setString(1, nombre);
				prepStmt.setString(2, establo);
				prepStmt.setString(3, gen);
				prepStmt.setInt(4, edad);
				prepStmt.setString(5, gear);
				prepStmt.setInt(6, score);
				prepStmt.setInt(7, won_races);
				prepStmt.setString(8, breed);
				prepStmt.executeUpdate();
				prepStmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
//
	public static void registrarJineteSQL(
//			int JockeyID,
			String FirstName,
			String LastName,
			String Gender,
			String StateResidence,
			int WonRaces,
			int YearsOfExp,
			int JockeyWeight) {
//		int id = JockeyID;
		String nombre = FirstName;
		String apellido = LastName;
		String gen = Gender;
		String stateR = StateResidence;
		int wonRaces = WonRaces;
		int years = YearsOfExp;
		int weight = JockeyWeight;
		
		
		
		Connection con = null;
		
		try {
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			con = DriverManager.getConnection(dbURL, user, pass);
			if(con != null) {
				System.out.println("Conexion establecida");
			}
			
			try (Statement stmt = con.createStatement()){
				String sqlQuery = "INSERT INTO Jockey (FirstName,LastName,Gender,StateResidence,WonRaces,YearsOfExperience,Weight_Jockey)"+" VALUES(?,?,?,?,?,?,?)";
				PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
				//prepStmt.setInt(1, id);
				prepStmt.setString(1, nombre);
				prepStmt.setString(2, apellido);
				prepStmt.setString(3, gen);
				prepStmt.setString(4, stateR);
				prepStmt.setInt(5, wonRaces);
				prepStmt.setInt(6, years);
				prepStmt.setInt(7, weight);
				prepStmt.executeUpdate();
				prepStmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
//
	public static void registrarDuenoSQL(
//			int OwnerID,
			String FirstName,
			String LastName,
			String StateResidence) {
		//int id = OwnerID;
		String nombre = FirstName;
		String apellido = LastName;
		String stateR = StateResidence;
		
		Connection con = null;
		
		try {
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			con = DriverManager.getConnection(dbURL, user, pass);
			if(con != null) {
				System.out.println("Conexion establecida");
			}
			
			try (Statement stmt = con.createStatement()){
				String sqlQuery = "INSERT INTO OwnerHorse (FirstName,LastName,StateResidence)"+" VALUES(?,?,?)";
				PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
	//			prepStmt.setInt(1, id);
				prepStmt.setString(1, nombre);
				prepStmt.setString(2, apellido);
				prepStmt.setString(3, stateR);
				prepStmt.executeUpdate();
				prepStmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
//
	public static void registrarEntrenadorSQL(
//			int TrainerID,
			String FirstName,
			String LastName,
			String StateResidence) {
		//int id = TrainerID;
		String nombre = FirstName;
		String apellido = LastName;
		String stateR = StateResidence;
		
		Connection con = null;
		
		try {
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			con = DriverManager.getConnection(dbURL, user, pass);
			if(con != null) {
				System.out.println("Conexion establecida");
			}
			
			try (Statement stmt = con.createStatement()){
				String sqlQuery = "INSERT INTO Trainer (FirstName,LastName,StateResidence)"+" VALUES(?,?,?)";
				PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
				//prepStmt.setInt(1, id);
				prepStmt.setString(1, nombre);
				prepStmt.setString(2, apellido);
				prepStmt.setString(3, stateR);
				prepStmt.executeUpdate();
				prepStmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
//
	public static void registrarCarreraSQL(
//			int RaceID,
			int Distance,
			String RaceType,
			String RaceTime,
			String RaceDate,
			String Weather) {
//		int id = RaceID;
		int distance = Distance;
		String raceType = RaceType;
		String time = RaceTime;
		String date = RaceDate;
		String weather = Weather;
		
		
		Connection con = null;
		
		try {
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			con = DriverManager.getConnection(dbURL, user, pass);
			if(con != null) {
				System.out.println("Conexion establecida");
			}
			
			try (Statement stmt = con.createStatement()){
				String sqlQuery = "INSERT INTO Race (Distance,RaceType,RaceTime,RaceDate,Weather)"+" VALUES(?,?,?,?,?)";
				PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
				//prepStmt.setInt(1, id);
				prepStmt.setInt(1, distance);
				prepStmt.setString(2, raceType);
				prepStmt.setString(3, time);
				prepStmt.setString(4, date);
				prepStmt.setString(5, weather);
				prepStmt.executeUpdate();
				prepStmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
//
	public static void registrarEntradaSQL(
			int GateNumber,
			String JockeyName,
			int Margins,
			int FinishPosition,
			int TimeElapsed,
			int AmountWon,
			String HorseName,
			int MorningLineOdds,
			int FinalOdds) {
		int gateNumber = GateNumber;
		String jockey = JockeyName;
		int margins = Margins;
		int finishPos = FinishPosition; 
		int timeElap = TimeElapsed;
		int amountWon = AmountWon;
		String horse = HorseName;
		int morningLO = MorningLineOdds; 
		int finalOdds = FinalOdds;
		
		
		Connection con = null;
		
		try {
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			con = DriverManager.getConnection(dbURL, user, pass);
			if(con != null) {
				System.out.println("Conexion establecida");
			}
			
			try (Statement stmt = con.createStatement()){
				String sqlQuery = "INSERT INTO RaceEntry ([GateNumber],JockeyName,Margins,FinishPosition,TimeElapsed,AmountWon,HorseName,MorningLineOdds,FinalOdds)"+" VALUES(?,?,?,?,?,?,?,?,?)";
				PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
				prepStmt.setInt(1, gateNumber);
				prepStmt.setString(2, jockey);
				prepStmt.setInt(3, margins);
				prepStmt.setInt(4, finishPos);
				prepStmt.setInt(5, timeElap);
				prepStmt.setInt(6, amountWon);
				prepStmt.setString(7, horse);
				prepStmt.setInt(8, morningLO);
				prepStmt.setInt(9, finalOdds);
				prepStmt.executeUpdate();
				prepStmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}

	public static void registrarEspectadorSQL(
			int TicketNo,
			float BetAmount,
			int AccountNo) {
		int ticket = TicketNo;
		float betAmount = BetAmount;
		int account = AccountNo;
	
		
		Connection con = null;
		
		try {
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			con = DriverManager.getConnection(dbURL, user, pass);
			if(con != null) {
				System.out.println("Conexion establecida");
			}
			
			try (Statement stmt = con.createStatement()){
				String sqlQuery = "INSERT INTO Spectator ([TickectNo],BetAmount,AccountNo)"+" VALUES(?,?,?)";
				PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
				prepStmt.setInt(1, ticket);
				prepStmt.setFloat(2, betAmount);
				prepStmt.setInt(3, account);
				prepStmt.executeUpdate();
				prepStmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}

	public static void registrarTicketSQL(
			int Code,
			String PaymentMode,
			float Price,
			int Race,
			String BetHorse,
			String DateRace,
			String TimeRace,
			String PurchaseDate,
			String PurchaseTime) {
		int code = Code;
		String payment = PaymentMode;
		float price = Price;
		int race = Race; 
		String betHorse = BetHorse;
		String date = DateRace;
		String time = TimeRace;
		String purDate = PurchaseDate; 
		String purTime = PurchaseTime;
		
		
		Connection con = null;
		
		try {
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			con = DriverManager.getConnection(dbURL, user, pass);
			if(con != null) {
				System.out.println("Conexion establecida");
			}
			
			try (Statement stmt = con.createStatement()){
				String sqlQuery = "INSERT INTO Ticket ([Code],PaymentMode,Price,Race,BetHorse,DateRace,TimeRace,PurchaseDate,PurchaseTime)"+" VALUES(?,?,?,?,?,?,?,?,?)";
				PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
				prepStmt.setInt(1, code);
				prepStmt.setString(2, payment);
				prepStmt.setFloat(3, price);
				prepStmt.setInt(4, race);
				prepStmt.setString(5, betHorse);
				prepStmt.setString(6, date);
				prepStmt.setString(7, time);
				prepStmt.setString(8, purDate );
				prepStmt.setString(9, purTime);
				prepStmt.executeUpdate();
				prepStmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	
	///ELIMINAR
	
	public static void EliminarEmpleadoSQL ( int PK_Employee) {
		int empleado = PK_Employee; 
		
		
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			
			String sql = "DELETE FROM Employee WHERE ID =? ";
		
			try (Connection con = DriverManager.getConnection(dbURL, user, pass);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				
				stmt.setInt(1, empleado);
				stmt.executeUpdate();
				
				System.out.println("Eliminado correctamente");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
	}
//
	public static void EliminarCaballoSQL ( String PK_Horse) {
		String caballo = PK_Horse; 
		
		
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			
			String sql = "DELETE FROM Horse WHERE HorseName =? ";
		
			try (Connection con = DriverManager.getConnection(dbURL, user, pass);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				
				stmt.setString(1, caballo);
				stmt.executeUpdate();
				
				System.out.println("Eliminado correctamente");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
	}
//
	public static void EliminarJineteSQL ( int PK_Jockey) {
		int jinete = PK_Jockey; 
		
		
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			
			String sql = "DELETE FROM Jockey WHERE JockeyID =? ";
		
			try (Connection con = DriverManager.getConnection(dbURL, user, pass);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				
				stmt.setInt(1, jinete);
				stmt.executeUpdate();
				
				System.out.println("Eliminado correctamente");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
	}
//
	public static void EliminarDuenoSQL ( int PK_Owner) {
		int dueno = PK_Owner; 
		
		
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			
			String sql = "DELETE FROM OwnerHorse WHERE OwnerID =? ";
		
			try (Connection con = DriverManager.getConnection(dbURL, user, pass);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				
				stmt.setInt(1, dueno);
				stmt.executeUpdate();
				
				System.out.println("Eliminado correctamente");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
	}
//
	public static void EliminarEntrenadorSQL ( int PK_Trainer) {
		int entrenador = PK_Trainer; 
		
		
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			
			String sql = "DELETE FROM Trainer WHERE TrainerID =? ";
		
			try (Connection con = DriverManager.getConnection(dbURL, user, pass);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				
				stmt.setInt(1, entrenador);
				stmt.executeUpdate();
				
				System.out.println("Eliminado correctamente");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
	}
//
	public static void EliminarCarreraSQL ( int PK_Race) {
		int carrera = PK_Race; 
		
		
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			
			String sql = "DELETE FROM Race WHERE RaceID =? ";
		
			try (Connection con = DriverManager.getConnection(dbURL, user, pass);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				
				stmt.setInt(1, carrera);
				stmt.executeUpdate();
				
				System.out.println("Eliminado correctamente");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
	}
//
	public static void EliminarEntradaSQL ( int PK_Entry) {
		int entrada = PK_Entry; 
		
		
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			
			String sql = "DELETE FROM RaceEntry WHERE GateNumber =? ";
		
			try (Connection con = DriverManager.getConnection(dbURL, user, pass);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				
				stmt.setInt(1, entrada);
				stmt.executeUpdate();
				
				System.out.println("Eliminado correctamente");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
	}
//
	public static void EliminarEspectadorSQL ( int PK_Spec) {
		int espectador = PK_Spec; 
		
		
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			
			String sql = "DELETE FROM Spectator WHERE TicketNo =? ";
		
			try (Connection con = DriverManager.getConnection(dbURL, user, pass);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				
				stmt.setInt(1, espectador);
				stmt.executeUpdate();
				
				System.out.println("Eliminado correctamente");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
	}
//
	public static void EliminarTicketSQL ( int PK_Ticket) {
		int ticket = PK_Ticket; 
		
		
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			
			String sql = "DELETE FROM Ticket WHERE Code =? ";
		
			try (Connection con = DriverManager.getConnection(dbURL, user, pass);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				
				stmt.setInt(1, ticket);
				stmt.executeUpdate();
				
				System.out.println("Eliminado correctamente");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
///MODIFICAR
	
	public static void ModificarEmpleadoSQL (
			String firstName,
			String lastName,
			int age,
			String birthday,
			String gender,
			String Position,
			int ZIP_Code,
			int ID) {
		int id = ID;
		String nombre = firstName;
		String apellido = lastName;
		int edad = age;
		String fechaNac = birthday;
		String genero = gender;
		String pos = Position;
		int ZIP = ZIP_Code;
		
		
		Connection con = null;
		
		try {
			String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=ProyectoBDD";
			String user = "DavidV";
			String pass = "2271999";
			con = DriverManager.getConnection(dbURL, user, pass);
			if(con != null) {
				System.out.println("Conexion establecida");
			}

			        try (Statement stmt = con.createStatement()) {
			        	

			            PreparedStatement ps = con.prepareStatement(
			            		"UPDATE Employee SET firstName = ?, lastName = ?,age = ?,"
			            		+ " birthday = ?, gender = ?,Position = ?,ZIP_Code = ? WHERE  ID = ? ");

			            ps.setString(1, nombre);
			            ps.setString(2, apellido);
			            ps.setInt(3, edad);
			            ps.setString(4, fechaNac);
			            ps.setString(5, genero);
			            ps.setString(6, pos);
			            ps.setInt(7, ZIP);
			            ps.setInt(8, id);
			            ps.executeUpdate();
			            ps.close();
			            
			        } catch (SQLException e) {
			          e.printStackTrace();
			        }        

			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    } finally {
			        try {
			            if (con != null && !con.isClosed()) {
			                con.close();
			            }
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    }
				 }
}



	
	
	
	
	
	
	
	

