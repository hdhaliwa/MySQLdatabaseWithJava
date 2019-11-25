package co.edureka.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class InsertRecord1
{

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","5525");
		Statement st = (Statement) con.createStatement();
		
		String s = "Y";
		Scanner sc = new Scanner(System.in);
		while(s.equalsIgnoreCase("Y"))
		{
			
		
		try
		{
			System.out.println("Enter employee details");
			int eno = sc.nextInt();
			String name = sc.next();
			float sal = sc.nextFloat();
			String sql = "insert into emp values("+eno+",'"+name+"',"+sal+")";
			int n = st.executeUpdate(sql);
			System.out.println("Employee saved "+n);
			
		}
		catch(Exception e){
			System.out.println("exception" +e.getMessage());
			
		}
		System.out.println("Do you want to continue (Y/N)");
		s=sc.next();
		}
		st.close();
		con.close();
		
	}

}
