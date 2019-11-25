package co.edureka.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class ProcedureCall {

	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","5525");
		
		CallableStatement cst = con.prepareCall("{call addnum(?,?,?)}");
		cst.setInt(1,89);
		cst.setInt(2,37);
		cst.registerOutParameter(3,Types.INTEGER);
		cst.execute();
		System.out.println("Sum = "+cst.getInt(3));
		cst.close();
		con.close();
		
		
		
	}

}
