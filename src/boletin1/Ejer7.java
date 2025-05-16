package boletin1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejer7 {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);

		String url = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String pswd;
		
		String consulta;
		
		String nombre;
		String apellido;
		String fecha_nacimiento;
		String email;
		String telefono;
		
		System.out.print("Introduce la contraseña: ");
		pswd = reader.nextLine();
		
		try (Connection con = DriverManager.getConnection(url, usuario, pswd)) {
			System.out.println("Credenciales correctas.\nConectado a la base de datos.");
			
			// Preguntas al usuario
			System.out.print("Nombre: ");
			nombre = reader.nextLine();
			
			System.out.print("Apellido: ");
			apellido = reader.nextLine();
			
			System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
			fecha_nacimiento = reader.nextLine();
			
			System.out.print("Email: ");
			email = reader.nextLine();
			
			System.out.print("Teléfono: ");
			telefono = reader.nextLine();
			
			// Insercción
			consulta = "INSERT INTO Estudiantes (nombre, apellido, fecha_nacimiento, email, telefono) VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement sentencia = con.prepareStatement(consulta);
			sentencia.setString(1, nombre);
			sentencia.setString(2, apellido);
			sentencia.setString(3, fecha_nacimiento);
			sentencia.setString(4, email);
			sentencia.setString(5, telefono);
			
			System.out.println("Filas afectadas: " + sentencia.executeUpdate());
			
		} catch (SQLException e) {
			System.out.println("Error al establecer la conexión con la base de datos: " + e);
		}
		
		reader.close();
		
	}

}
