package boletin1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejer6 {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);

		String url = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String pswd;
		
		// Datos del estudiante
		String nombre = "Ana";
		String apellido = "González";
		String curso = "Matemáticas 1º";
		
		String consulta;
		
		System.out.print("Introduce la contraseña: ");
		pswd = reader.nextLine();
		
		try (Connection con = DriverManager.getConnection(url, usuario, pswd)) {
			System.out.println("Credenciales correctas.\nConectado a la base de datos.");
			
			Statement sentencia = con.createStatement();

			consulta = "UPDATE Calificaciones\r\n"
					+ "INNER JOIN Estudiantes ON Calificaciones.id_estudiante = Estudiantes.id_estudiante\r\n"
					+ "INNER JOIN Cursos ON Calificaciones.id_curso = Cursos.id_curso\r\n"
					+ "SET Calificaciones.nota = Calificaciones.nota + 1\r\n"
					+ "WHERE Estudiantes.nombre = '" + nombre + "' AND Estudiantes.apellido = '" + apellido + "' AND Cursos.nombre = '" + curso + "'";
			sentencia.executeUpdate(consulta);
			
		} catch (SQLException e) {
			System.out.println("Error al establecer la conexión con la base de datos: " + e);
		}
		
		reader.close();
		
	}

}
