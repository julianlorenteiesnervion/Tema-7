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
		
		System.out.print("Introduce la contraseña: ");
		pswd = reader.nextLine();
		
		try (Connection con = DriverManager.getConnection(url, usuario, pswd)) {
			System.out.println("Credenciales correctas.\nConectado a la base de datos.");
			
			anadirCurso(con, "Historia");
			anadirCurso(con, "Biología");
			anadirCurso(con, "Educación Física");
			anadirCurso(con, "Música");
			anadirCurso(con, "Tecnología");
			
		} catch (SQLException e) {
			System.out.println("Error al establecer la conexión con la base de datos: " + e);
		}
		
		reader.close();
		
	}
	
	static private void anadirCurso(Connection con, String curso) {
		Statement sentencia = null;
		
		try {
			sentencia = con.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		String consulta = "INSERT INTO Cursos (nombre, descripcion, año_escolar) VALUES ('" + curso + " 1º', 'Curso de " + curso + " para el primer año', 2025)";
		
		try {
			sentencia.executeUpdate(consulta);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
