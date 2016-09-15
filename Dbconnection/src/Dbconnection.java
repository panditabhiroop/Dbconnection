import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbconnection {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String connectionnUrl="jdbc:mysql://localhost:3306/sakila";
		String dbUser="root";
		String dbPwd = "Admin";
		Connection conn;
		ResultSet rs;
		String queryString = "SELECT EmpID,LastName,FirstName,Address,City FROM EMPLOYEE";
		
		try {
			conn=DriverManager.getConnection(connectionnUrl,dbUser,dbPwd);
			Statement stmt= conn.createStatement();
			//stmt.executeUpdate("CREATE TABLE EMPLOYEE(EmpID int,LastName varchar(255),FirstName varchar(255),Address varchar(255),City varchar(255))");
			//stmt.executeUpdate("INSERT INTO EMPLOYEE (EmpID,LastName,FirstName,Address,City) VALUES ('1912','Mukherjee','Sourabrata','Kormongala','Bangalore')");
			rs = stmt.executeQuery(queryString);
			System.out.println("============");
			while (rs.next()) {
				System.out.print(rs.getInt("EmpID") + ".\t"
						+ rs.getString("LastName") + ".\t"
						+ rs.getString("FirstName") + ".\t"
						+ rs.getString("Address") + ".\t"
						+ rs.getString("City"));
				System.out.println();
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
