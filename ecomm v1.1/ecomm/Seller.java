package ecomm;
import java.util.ArrayList;

public abstract class Seller {

	// id is passed in by the class that instantiates sub-type of seller
	public Seller(String id) {
		myID = id;
	}
	
	// ID of seller. 
	public String getID() { return myID;}
	
	// Platform it is being added to.
	// Should in turn add itself to the Platform (with addSeller)
	public abstract void addPlatform(Platform thePlatform);
	
	// Seller to return listing of Products of specified Category
	public abstract ArrayList<Product> findProducts(Globals.Category whichOne);
	// User wants to buy specified quantity of productID
	// Return true if transaction succeeds, false otherwise. 
	// Transaction fails if incorrect productID or quantity exceeds available inventory
	public abstract boolean buyProduct(String productID, int quantity);
	
	private String myID;
}
