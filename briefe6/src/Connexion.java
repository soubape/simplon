import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
	public static final String DRIVER_CLASS = "org.postgresql.Driver"; 
	public static final String URL = "jdbc:postgresql://localhost/db_briefe6";
	public static final String USER = "postgres";
	public static final String PASSWORD = "nawan";
	private static Connection connexion;
	public Connexion() {
		
		try {
			Class.forName(DRIVER_CLASS);
			connexion = DriverManager.getConnection(URL,USER,PASSWORD);
		}
		catch(Exception e){
			System.out.println("Impossible d'etablir la connexion");;
		}
	}
		public static Connection getConnection() {
			return connexion;
			}
	
	}

		
	
	

		
