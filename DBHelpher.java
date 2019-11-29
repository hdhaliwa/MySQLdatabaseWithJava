package co.edureka.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import co.edureka.model.EMPLOYEE;

public class DBHelpher {
//ALL DBOperations done here like CRUD
	//DAO Data Access Object design pattern
	
	Connection con;
	
	public DBHelpher(){
		try{
			//1.loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		    System.out.println(">>Driver loaded");
			
		}catch(Exception e){
			System.out.println(">> exception is "+e);
		}
	}
	
	public void CreateConnection(){
		try{
		String url = "jdbc:mysql://localhost/edureka";
		String user = "root";
		String password = "Guruji123";
		con = DriverManager.getConnection(url,user,password);
		System.out.println(">> connection established");
	}
		catch(Exception e){
			System.out.println(">>exception is "+e);
		}
	}
	
	public void insertEmployee(EMPLOYEE emp){
		try{
			//3. Write SQL Statement
			String sql = "insert into EMPLOYEE values (null, '"+emp.title+"', '"+emp.email+"', '"+emp.salary+"' , '"+emp.address+"')";
			System.out.println(">>sql statement written" );
			
			//4. execute SQL statement
			Statement stmt = con.createStatement();
			int i =  stmt.executeUpdate(sql); //execute sql
			if(i>0){
				System.out.println("Sql statement executed");
				
			}
			else{
				System.out.println("Sql statement failed");
			}
			
		}catch(Exception e){
			System.out.println(">> some exception "+e);
		}
		
	}
	public void closeConnection(){
		try{
			//5. connection close
			con.close();
			System.out.println("connection closed");
		}catch(Exception e){
			System.out.println(">> some exception "+e);
		}
	}
}
