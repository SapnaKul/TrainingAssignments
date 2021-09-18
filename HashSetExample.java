import java.util.*;
public class HashSetExample {
	
	
	private  String empId;
	private  String empName;
	private  String empDept;
	
	
	 public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
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


	public HashSetExample(String empId, String empName, String empDept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDept = empDept;
	}


	public static void main(String args[]){  
	   
	    HashSet<String> set =new HashSet<String>(); 
	    
	           set.add("One");    
	           set.add("Two");    
	           set.add("Three");   
	           set.add("Four");  
	           set.add("Five");  
	           Iterator<String> i=set.iterator();  
	           while(i.hasNext())  
	           {  
	        
	           System.out.println(i.next());  
	           }  
	 }  
	}  
