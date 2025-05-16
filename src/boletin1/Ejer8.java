package boletin1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejer8 {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);

		String url = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String pswd;
		
		String consulta;
		int id;
		
		System.out.print("Introduce la contraseña: ");
		pswd = reader.nextLine();
		
		try (Connection con = DriverManager.getConnection(url, usuario, pswd)) {
			System.out.println("Credenciales correctas.\nConectado a la base de datos.");
			
			System.out.print("Introduce la ID del estudiante a eliminar: ");
			id = reader.nextInt();
			
			Statement sentencia = con.createStatement();
			
			consulta = "DELETE FROM Estudiantes WHERE id_estudiante = " + id;
			
			sentencia.executeUpdate(consulta);
			
		} catch (SQLException e) {
			System.out.println("Error al establecer la conexión con la base de datos: " + e);
		}
		
		reader.close();

	}

}
