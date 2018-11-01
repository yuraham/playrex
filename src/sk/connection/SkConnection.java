package sk.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SkConnection {
	Connection con;
	
	String url = "jdbc:mysql://localhost:3306/my_site";
	String user = "jsp_user";
	String pass ="qwer1234";
	
	public Connection openConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeConnection() {
		try {
			if(con != null) {
				con.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			con = null;
			
		}
	}
			

}
