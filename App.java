package co.edureka.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class App {



	public static void main(String[] args) {
			//employee object construction
			EMPLOYEE e1 = new EMPLOYEE(1,"John","john@example.com",45000,"Orange Street");
			//view object data
			System.out.println(e1);
		try {
			//1.load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(">>Driver loaded");
			//2.connection 
			String url = "jdbc:mysql://localhost/edureka";
			String user = "root";
			String password = "Guruji123";
			try {
				Connection con = DriverManager.getConnection(url,user,password);
				System.out.println(">> connection established");
				
				//3. Write SQL Statement
				String sql = "insert into EMPLOYEE values (null, '"+e1.title+"', '"+e1.email+"', '"+e1.salary+"' , '"+e1.address+"')";
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
				
				//5. connection close
				con.close();
				System.out.println("connection closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
