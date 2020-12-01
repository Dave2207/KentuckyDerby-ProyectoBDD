package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabaseConnection {

	public static void main(String[] args) {
		registrarEmpleadoSQL("David", "Vasquez", 21, "22-7-1999", "M", "LOL", 51000);
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
			int JockeyID,
			String FirstName,
			String LastName,
			String Gender,
			String StateResidence,
			int WonRaces,
			int YearsOfExp,
			int JockeyWeight) {
		int id = JockeyID;
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
				String sqlQuery = "INSERT INTO Jockey ([JockeyID],FirstName,LastName,Gender,StateResidence,WonRaces,YearsOfExperience,Weight_Jockey)"+" VALUES(?,?,?,?,?,?,?,?)";
				PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
				prepStmt.setInt(1, id);
				prepStmt.setString(2, nombre);
				prepStmt.setString(3, apellido);
				prepStmt.setString(4, gen);
				prepStmt.setString(5, stateR);
				prepStmt.setInt(6, wonRaces);
				prepStmt.setInt(7, years);
				prepStmt.setInt(8, weight);
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
			int OwnerID,
			String FirstName,
			String LastName,
			String StateResidence) {
		int id = OwnerID;
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
				String sqlQuery = "INSERT INTO Owner ([OwnerID],FirstName,LastName,StateResidence)"+" VALUES(?,?,?,?)";
				PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
				prepStmt.setInt(1, id);
				prepStmt.setString(2, nombre);
				prepStmt.setString(3, apellido);
				prepStmt.setString(4, stateR);
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
			int TrainerID,
			String FirstName,
			String LastName,
			String StateResidence) {
		int id = TrainerID;
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
				String sqlQuery = "INSERT INTO Trainer ([TrainerID],FirstName,LastName,StateResidence)"+" VALUES(?,?,?,?)";
				PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
				prepStmt.setInt(1, id);
				prepStmt.setString(2, nombre);
				prepStmt.setString(3, apellido);
				prepStmt.setString(4, stateR);
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
			
			String sql = "DELETE FROM Jockey WHERE ID =? ";
		
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
}
