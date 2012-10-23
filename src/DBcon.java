
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DBcon {
	
	Connection con;
	
	public DBcon()
	{
		
		 con = null;
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
			ResultSet rs = st.executeQuery("select * from test2");
			
			while (rs.next())
			{
				System.out.println(rs.getString(1) + rs.getString(2));
			}
			rs.close();
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
	}
	

	void querydb(String s)
	{
		//to run simple querys like insert into , update etc that dosen't return tuples
		try
		{
			    Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from test2");
				rs.close();
				st.close();
		}
		catch (SQLException e)
		{
			System.out.println("sql connection problem");
		}
	}
	
	ResultSet getdb(String s)
	{
		//to get tuples from tables, so return result set
		ResultSet rs = null;
		try
		{
			    Statement st = con.createStatement();
			    rs = st.executeQuery("select * from test2");
				st.close();
		}
		catch (SQLException e)
		{
			System.out.println("sql connection problem");
		}
		return rs;
	}
}