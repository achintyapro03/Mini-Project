package demo;

import ecomm.Globals;

public class Mobile extends MyProduct
{
	// dtat members
	private String productName, ProductID;
	private float price;
	private int quanitityAvailable;
	private Globals.Category category;

	// parameterized constuctor
	public Mobile(String productName, String ProductID, float price, int quanitityAvailable)
	{
		super();
		this.category = Globals.Category.Mobile;
		this.price = price;
		this.productName = productName;
		this.quanitityAvailable = quanitityAvailable;
		this.ProductID = ProductID;
	}

	// getter functions
	public Globals.Category getCategory()
	{
		// Returns the category
		return this.category;
	}

	public String getName()
	{
		// Returns the name
		return productName;
	}

	public String getProductID()
	{
		// Returns the product ID
		return ProductID;
	}

	public float getPrice()
	{
		// Returns the price
		return price;
	}

	public int getQuantity()
	{
		// Returns the quantity
		return quanitityAvailable;
	}

	public void UpdateQuantity(int Quantity)
	{
		// Changes the quantity
		this.quanitityAvailable = Quantity;
	}
}