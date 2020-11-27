package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabaseConnection {

	public static void main(String[] args) {
		
	}
	
	public static void registrarEmpleadoSQL(
			int ID,
			String firstName,
			String lastName,
			int age,
			String birthday,
			String gender,
			String Position,
			int ZIP_Code) {
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
			String dbURL = "jdbc:sqlserver://localhost";
			String user = "DavidV";
			String pass = "2271999";
			con = DriverManager.getConnection(dbURL, user, pass);
			if(con != null) {
				System.out.println("Conexion establecida");
			}
			
			try (Statement stmt = con.createStatement()){
				String sqlQuery = "INSERT INTO Employee ([ID],FirstName,LastName,Age,Birthday,Gender,Position,ZIP_Code)"+" VALUES(?,?,?,?,?,?,?,?)";
				PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
				prepStmt.setInt(1, id);
				prepStmt.setString(2, nombre);
				prepStmt.setString(3, apellido);
				prepStmt.setInt(4, edad);
				prepStmt.setString(5, fechaNac);
				prepStmt.setString(6, genero);
				prepStmt.setString(7, pos);
				prepStmt.setInt(8, ZIP);
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
}
