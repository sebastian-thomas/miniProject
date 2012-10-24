
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBcon {
	
	
	
	public ResultSet dbquery(String s)
	{
		
		Connection con = null;
		ResultSet rs = null;
		try {
			String driverName = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driverName);
			//select ora_database_name from dual;
			//con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "seb","password" );
			
			String serverName = "127.0.0.1";
		    String portNumber = "1521";
		    String sid = "XE";
		    String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
		    String username = "seb";
		    String password = "password";
		    con = DriverManager.getConnection(url, username, password);
		    
		    Statement st = con.createStatement();
			rs = st.executeQuery(s);
			st.close();
			
			//con.close();
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("class not found");
		}
		catch (SQLException e)
		{
			System.out.println("sql connection problem");
		}
		return rs;
	}
	

}