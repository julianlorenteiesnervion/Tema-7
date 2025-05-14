package boletin1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejer3 {

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

			consulta = "DELETE FROM Estudiantes WHERE nombre = 'Julián' AND apellido = 'Lorente'";
			sentencia.executeUpdate(consulta);
			
			consulta = "DELETE FROM Estudiantes WHERE nombre = 'José Manuel' AND apellido = 'Maya'";
			sentencia.executeUpdate(consulta);
			
			consulta = "DELETE FROM Profesores WHERE nombre = 'Elena' AND apellido = 'Rivero'";
			sentencia.executeUpdate(consulta);
			
		} catch (SQLException e) {
			System.out.println("Error al establecer la conexión con la base de datos: " + e);
		}
		
		reader.close();
		
	}

}
