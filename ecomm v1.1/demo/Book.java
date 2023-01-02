package demo;

import ecomm.Globals;
import ecomm.Product;

public class Book extends Product{
    private String productName, productUniqueName, ProductID;
    private int price, quanitityAvailable;
    private Globals.Category category;

    public Book(String productName, String productUniqueName, String ProductID, int price, int quanitityAvailable) 
    {
        super();
        this.category = Globals.Category.Book;
        this.price = price;
        this.productName = productName;
        this.productUniqueName = productUniqueName;
        this.quanitityAvailable = quanitityAvailable;
        this.ProductID = ProductID;
    }
    public Globals.Category getCategory(){
        return this.category;
    }
	public String getName()
    {
        return productName;
    }
	public  String getProductID()
    {
        return ProductID;
    }
	public  float getPrice()
    {
        return price;
    }
	public  int getQuantity()
    {
        return quanitityAvailable;
    }

    public void UpdateQuantity(int Quantity)
    {
        this.quanitityAvailable = Quantity;
    }
    public String toString()
    {
        return this.productName + " "+this.productUniqueName+" "+this.price+" "+this.quanitityAvailable;
    }
}


