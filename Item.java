import java.util.*;

public class Item {
	
	private int itemId;
	private String itemName;
	private double price;
	private static LinkedList<Item> i1= new LinkedList<Item>();
	
	
	
public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Item(int itemId, String itemName, double price) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
	}
	
	public static void addItemToLinkedList(Item item) {
	i1.add(item);
	}
	public static void main(String args[])
    {
		Item myItem1 = new Item(1,"Rice", 10.0);
		i1.add(myItem1);
		Item myItem2 = new Item(2,"Wheat",20.0);
		i1.add(myItem2);
		Item myItem3 = new Item(3,"Sugar",30.0);
		i1.add(myItem3);
		System.out.println(" Size of Linked List = " + i1.size());
		Iterator<Item> iterator = i1.iterator();

		
		i1.forEach((item) -> {
		    System.out.println(item.getItemId() +  "  " + item.getItemName() + "  " + item.getPrice());
		});
		
    }
	
}
	




