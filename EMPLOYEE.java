package co.edureka.jdbc;

public class EMPLOYEE {

	int eid;
	String title;
	String email;
	int salary;
	String address;
	
	EMPLOYEE(){}
	
	
	public EMPLOYEE(int eid, String title, String email, int salary, String address) {
		super();
		this.eid = eid;
		this.title = title;
		this.email = email;
		this.salary = salary;
		this.address = address;
	}


	@Override
	public String toString() {
		return "EMPLOYEE [eid=" + eid + ", title=" + title + ", email=" + email + ", salary=" + salary + ", address="
				+ address + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
