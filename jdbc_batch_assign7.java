 package co.edureka.jdbc;
import java.sql.*;
/*
 * 
 * 
 *   in mysql execute START TRANSACTION; for rollback operaton.
 * 
 * 
 */

public class jdbc_batch_assign7
{
 public static void main(String args[])throws Exception
{
 	Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Driver loaded...");
   
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","5525");
	 System.out.println("Connected to the database");

Statement stmt=con.createStatement();
con.setAutoCommit(false);
stmt.addBatch("update student1 set name='John Dijakstra' where name='John mathew'");
stmt.addBatch("insert into student1 values(4,'Asha','MS',99)");
try
{
    stmt.executeBatch();    
    System.out.println("batch executed");
    con.commit();
}
catch(Exception e)
{
    try
    {
        con.rollback();
        System.out.println("batch cancelled");
        e.printStackTrace();
    }
    catch(Exception e1)
    {
        System.out.println(e1);
    }
     con.close();   
    }
}
        
}
