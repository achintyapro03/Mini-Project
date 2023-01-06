package demo;

import ecomm.Globals;

public class Book extends MyProduct
{
	// Book parameters
	private String productName, ProductID;
	private float price;
	private int quanitityAvailable;
	private Globals.Category category;

	// parametarized constructor
	public Book(String productName, String ProductID, float price, int quanitityAvailable)
	{
		super();
		this.category = Globals.Category.Book;
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