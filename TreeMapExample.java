import java.util.TreeMap;
import java.util.*;

public class TreeMapExample {
 
	private int empid;
	private String empName;
	
	
	public static void main(String[] args) {
		
		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
	             
	      
	      tmap.put(1, "Smith");
	      tmap.put(23, "John");
	      tmap.put(70, "Diya");
	      tmap.put(4, "David");
	      tmap.put(2, "Deena");

	      
	      for (Map.Entry<Integer, String> e : tmap.entrySet())
	            System.out.println(e.getKey()
	                               + " "
	                               + e.getValue());
	      }

	

	
		
	}

	   
	
	


