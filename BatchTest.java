package co.edureka.jdbc;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;


public class BatchTest 
{

	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","5525");
		Statement st = con.createStatement();
		
		con.setAutoCommit(false);
		try{
		
		st.addBatch("insert into emp values(101,'Mary',123.45)");
		st.addBatch("insert into emp values(102,'Cary',1.45)");
		st.addBatch("insert into emp values(103,'Sunil',13.45)");
		st.addBatch("update emp set sal=111.11");
		
		int[] n=st.executeBatch();
		for (int i =0;i<n.length;i++)
		{
			System.out.println(n[i]);
		}
		con.commit();
		}
		catch (Exception e){
			con.rollback();
		}
	}
}
