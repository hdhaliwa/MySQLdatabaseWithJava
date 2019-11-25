package co.edureka.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class jdbc_assign7
{

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","5525");
		
		 System.out.println("Connected to the database");
		  	
	      Statement st=con.createStatement();

	     System.out.println("Before creating the table...");
	      st.execute("CREATE TABLE `student1` (`id` INT(11) NULL DEFAULT NULL,`name` VARCHAR(25) NULL DEFAULT NULL,	`class` VARCHAR(25) NULL DEFAULT NULL,	`marks` INT(11) NULL DEFAULT NULL)");
	      System.out.println("table created");
	       
	               
	      st.executeUpdate("insert into student1 values(2, 'John','M.Tech', 98)");
	       System.out.println("  row inserted");
	       
	       st.executeUpdate("insert into student1 values(3, 'Sayanora','B.Tech', 96)");
	       System.out.println("  row inserted");

	      
	      
	      st.executeUpdate("update student1 set name='John mathew' where name='John'");
	      System.out.println("row updated");
	       
	      
	      st.executeUpdate("delete from student1 where name='Sayanora'");
	      System.out.println("row deleted");
	      
	      con.close();
	      System.out.println("Connection closed...");
	      
	  }    
	}


		