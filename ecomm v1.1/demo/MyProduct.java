package demo;

import ecomm.Product;
import ecomm.Globals;

// This class is created to include extra function UpdateQuantity
// it inherits from the Product class and is an abstract class

public abstract class MyProduct extends Product
{
	public abstract Globals.Category getCategory();

	public abstract String getName();

	public abstract String getProductID();

	public abstract float getPrice();

	public abstract int getQuantity();

	public abstract void UpdateQuantity(int quantity);
}