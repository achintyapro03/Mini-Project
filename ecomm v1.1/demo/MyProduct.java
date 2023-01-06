package demo;

import ecomm.Product;
import ecomm.Globals;

public abstract class MyProduct extends Product {
	public abstract Globals.Category getCategory();

	public abstract String getName();

	public abstract String getProductID();

	public abstract float getPrice();

	public abstract int getQuantity();

	public abstract void UpdateQuantity(int quantity);
}
