package connection;
import java.sql.*;
import javax.swing.*;

public class DbConnection {
  Connection conn = null;
  
  public static Connection dbConnector()
  {
	  try 
	  {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Ritik123456");
		return conn;
	  }
	  catch (Exception e) 
	  {
		JOptionPane.showMessageDialog(null,e);
		return null;
	  }
  }
}
