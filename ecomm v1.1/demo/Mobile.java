package demo;

import ecomm.Product;
import ecomm.Globals;

public class Mobile extends Product {
    private String  productName, productUniqueName, ProductID;
    private int price, quanitityAvailable;
    private Globals.Category category;
    
    public Mobile(String productName, String productUniqueName, String ProductID, int price, int quanitityAvailable) {
        super();
        this.category = Globals.Category.Mobile;
        // this.portalId = portalId;
        this.price = price;
        this.productName = productName;
        this.productUniqueName = productUniqueName;
        this.quanitityAvailable = quanitityAvailable;
        this.ProductID = ProductID;
    }

    public Globals.Category getCategory(){
        return this.category;
    }
	public String getName(){
        return this.productName;
    }
	public String getProductID(){
        return this.ProductID;
    }
	public float getPrice(){
        return this.price;
    }
	public int getQuantity(){
        return this.quanitityAvailable;
    }
    public String productUniqueName(){
        return this.productUniqueName;
    }

    public String toString()
    {
        return this.productName + " "+this.productUniqueName+" "+this.price+" "+this.quanitityAvailable;
    }

    public void UpdateQuantity(int Quantity)
    {
        this.quanitityAvailable = Quantity;
    }
}




