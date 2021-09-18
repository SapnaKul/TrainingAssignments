import java.util.TreeMap;
import java.util.*;

public class Employee {
 
	private int empid;
	private String empName;
	private String empDept;
	
	
	public int getEmpid() {
		return empid;
	}


	public void setEmpid(int empid) {
		this.empid = empid;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpDept() {
		return empDept;
	}


	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}


	public Employee(int empid, String empName, String empDept) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.empDept = empDept;
	}


	public static void main(String[] args) {
		
		TreeMap<Integer, Employee> tmap = new TreeMap<Integer, Employee>();
	             
	      
	      tmap.put(1, new Employee(1,"Smith","Accounts"));
	      tmap.put(23, new Employee(23,"John","Legal"));
	      tmap.put(70, new Employee(70,"Diya","Service"));
	      tmap.put(4, new Employee(4,"David","Manufacturing"));
	      tmap.put(2, new Employee(2,"Deena","Logistics"));

	      
	      for (Map.Entry<Integer, Employee> e : tmap.entrySet())
	            System.out.println(e.getKey()
	                               + " "
	                               + e.getValue().getEmpid() + " " + e.getValue().getEmpName() + " "+ e.getValue().getEmpDept());
	      }

	

	
		
	}

	   
	
	


