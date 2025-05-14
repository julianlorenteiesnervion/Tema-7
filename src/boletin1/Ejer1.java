package boletin1;

import java.sql.*;
import java.util.*;

public class Ejer1 {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);

		String url = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String pswd;
		
		String consulta;
		
		System.out.print("Introduce la contraseña: ");
		pswd = reader.nextLine();
		
		try (Connection con = DriverManager.getConnection(url, usuario, pswd)) {
			System.out.println("Credenciales correctas.\nConectado a la base de datos.");
			
			Statement sentencia = con.createStatement();
			
			consulta = "INSERT INTO Estudiantes (nombre, apellido, fecha_nacimiento, email, telefono) VALUES ('Julián', 'Lorente', '2006-11-14', 'julian.lorente@iesnervion.es', '654321987')";
			sentencia.executeUpdate(consulta);
			
			consulta = "INSERT INTO Estudiantes (nombre, apellido, fecha_nacimiento, email, telefono) VALUES ('José Manuel', 'Maya', '2005-09-15', 'jm.maya@iesnervion.es', '732144988')";
			sentencia.executeUpdate(consulta);
			
		} catch (SQLException e) {
			System.out.println("Error al establecer la conexión con la base de datos: " + e);
		}
		
		reader.close();
		
	}

}
