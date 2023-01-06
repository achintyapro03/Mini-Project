package ecomm;

public abstract class Product {

	// common queries to get category, unique name, price, and number available
	public abstract Globals.Category getCategory();
	public abstract String getName();
	public abstract String getProductID();
	public abstract float getPrice();
	public abstract int getQuantity();
	// public abstract void UpdateQuantity(int quantity);
}


