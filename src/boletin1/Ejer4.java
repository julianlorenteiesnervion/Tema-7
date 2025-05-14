package boletin1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejer4 {

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

			consulta = "INSERT INTO Cursos (nombre, descripcion, año_escolar) VALUES ('Historia 1º', 'Curso de Historia para el primer año', 2025)";
			sentencia.executeUpdate(consulta);
			
			consulta = "INSERT INTO Cursos (nombre, descripcion, año_escolar) VALUES ('Biología 1º', 'Curso de Biología para el primer año', 2025)";
			sentencia.executeUpdate(consulta);
			
			consulta = "INSERT INTO Cursos (nombre, descripcion, año_escolar) VALUES ('Educación Física 1º', 'Curso de Educación Física para el primer año', 2025)";
			sentencia.executeUpdate(consulta);
			
			consulta = "INSERT INTO Cursos (nombre, descripcion, año_escolar) VALUES ('Música 1º', 'Curso de Música para el primer año', 2025)";
			sentencia.executeUpdate(consulta);
			
			consulta = "INSERT INTO Cursos (nombre, descripcion, año_escolar) VALUES ('Tecnología 1º', 'Curso de Tecnología para el primer año', 2025)";
			sentencia.executeUpdate(consulta);
			
		} catch (SQLException e) {
			System.out.println("Error al establecer la conexión con la base de datos: " + e);
		}
		
		reader.close();
		
	}

}
