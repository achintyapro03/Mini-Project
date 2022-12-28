package ecomm;

public class Book extends Product{
    private String portalId, productName, productUniqueName, ProductID;
    private int price, quanitityAvailable;
    public Book(String portalId, String productName, String productUniqueName, String ProductID, int price, int quanitityAvailable) 
    {
        super();
        this.portalId = portalId;
        this.price = price;
        this.productName = productName;
        this.productUniqueName = productUniqueName;
        this.quanitityAvailable = quanitityAvailable;
        this.ProductID = ProductID;
    }
    // public  Globals.Category getCategory()
    // {
    //     return Globals.getCategoryName(Book);
    // }
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
}


