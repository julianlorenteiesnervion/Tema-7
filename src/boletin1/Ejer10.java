package boletin1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejer10 {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);

		String url = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String pswd;
		
		int curso;
		
		System.out.print("Introduce la contraseña: ");
		pswd = reader.nextLine();
		
		try (Connection con = DriverManager.getConnection(url, usuario, pswd)) {
			System.out.println("Credenciales correctas.\nConectado a la base de datos.");
			
			PreparedStatement ps = con.prepareStatement("SELECT E.nombre, E.fecha_nacimiento FROM Estudiantes AS E "
					+ "INNER JOIN Matriculas AS M ON E.id_estudiante = M.id_estudiante "
					+ "INNER JOIN Cursos AS C ON M.id_curso = C.id_curso "
					+ "WHERE C.id_curso = ?");
			
			System.out.print("ID del curso: ");
			curso = reader.nextInt();
			
			ps.setInt(1, curso);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("nombre") + "\t| " + rs.getString("fecha_nacimiento"));
			}
			
		} catch (SQLException e) {
			System.out.println("Error al establecer la conexión con la base de datos: " + e);
		}
		
		reader.close();
		
	}

}
