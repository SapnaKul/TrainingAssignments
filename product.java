import java.util.*;


public class product {

	private int pId;
	private String pName;
	private double price;
	
	private static HashSet<product> hs = new HashSet<product>();

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public product(int pId, String pName, double price) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.price = price;
	}

	

	public static void addproductHashset(product product) {
		hs.add(product);
		}
		public static void main(String args[])
	    {
			product myProduct1 = new product(1,"Table", 1000.0);
			hs.add(myProduct1);
			product myProduct2 = new product(2,"chair",750.0);
			hs.add(myProduct2);
			product myProduct3 = new product(3,"whiteboard",500.0);
			hs.add(myProduct3);
			System.out.println(" Size of HashSet  = " + hs.size());
			Iterator<product> iterator = hs.iterator();

			
			hs.forEach((product) -> {
			    System.out.println(product.getpId() +  "  " + product.getpName() + "  " + product.getPrice());
			    //System.out.println("HashSet elements : " + hs);
			});
	    }
}

