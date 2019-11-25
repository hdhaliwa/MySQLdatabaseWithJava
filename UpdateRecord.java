package co.edureka.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class UpdateRecord
{

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","5525");
		Statement st = (Statement) con.createStatement();
		
		
		try
		{
			String sql = "update emp set ename='hero' where empno=102";
			int n = st.executeUpdate(sql);
			System.out.println("Employee saved "+n);
		}
		catch(Exception e){
			System.out.println("exception" +e.getMessage());
		}
		st.close();
		con.close();
		
	}

}
