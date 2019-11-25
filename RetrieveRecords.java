package co.edureka.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class RetrieveRecords
{

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","5525");
		Statement st = (Statement) con.createStatement();
		
		
		try
		{
			String sql = "select * from emp";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getRow()+": "+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble("sal"));
				Thread.sleep(2000);
				
			}
			rs.close();
		}
		
		catch(Exception e){
			System.out.println("exception" +e.getMessage());
		}
		
		st.close();
		con.close();
		
	}

}
