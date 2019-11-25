package co.edureka.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class PreparedTest
{

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","5525");
		
		PreparedStatement pst = con.prepareStatement("select * from emp where empno between ? and ?");
		pst.setInt(1,101);
		pst.setInt(2,103);
	//	ResultSet rs = pst executeQuery();
		pst.execute();
		ResultSet rs = pst.getResultSet();
		while(rs.next())
		{
			System.out.println(rs.getRow()+": "+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble("sal"));
			
			
		}
		System.out.println();
		Thread.sleep(4000);
		
		pst.clearParameters();
		
		pst.setInt(1,101);
		pst.setInt(2,104);
	
		pst.execute();
		rs = pst.getResultSet();
		while(rs.next())
		{
			System.out.println(rs.getRow()+": "+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble("sal"));
			
			
		}
		System.out.println();
		Thread.sleep(4000);

	}

}
