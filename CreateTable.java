package co.edureka.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CreateTable
{

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","Guruji123");
		Statement st = (Statement) con.createStatement();
		
		
		try
		{
			String sql = "create table emp(empno int(5) primary key,ename varchar(20),sal float(10,2));";
			st.execute(sql);
			System.out.println("Db table created");
		}
		catch(Exception e){
			System.out.println("exception" +e.getMessage());
		}
		st.close();
		con.close();
		
	}

}
