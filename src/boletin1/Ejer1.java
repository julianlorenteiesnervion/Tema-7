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
			
			Sta
			
		} catch (SQLException e) {
			System.out.println("Error al establecer la conexión con la base de datos: " + e);
		}
		
		reader.close();
		
	}

}
