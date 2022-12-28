package ecomm;
 
public class Mobile extends Product {
    private String portalId, productName, productUniqueName, ProductID;
    private int price, quanitityAvailable;

    public Mobile(String portalId, String productName, String productUniqueName, String ProductID, int price, int quanitityAvailable) {
        super();
        this.portalId = portalId;
        this.price = price;
        this.productName = productName;
        this.productUniqueName = productUniqueName;
        this.quanitityAvailable = quanitityAvailable;
        this.ProductID = ProductID;
    }

    // public Globals.Category getCategory(){

    // }
	public String getName(){
        return this.productName;
    }
	public String getProductID(){
        return this.ProductID;
    }
    public String getPortalId(){
        return this.portalId;
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
}




