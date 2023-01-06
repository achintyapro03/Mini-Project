package demo;

import ecomm.Globals;

public class Mobile extends MyProduct {
    private String productName, ProductID;
    private float price;
    private int quanitityAvailable;
    private Globals.Category category;

    public Mobile(String productName, String ProductID, float price, int quanitityAvailable) {
        super();
        this.category = Globals.Category.Mobile;
        // this.portalId = portalId;
        this.price = price;
        this.productName = productName;
        this.quanitityAvailable = quanitityAvailable;
        this.ProductID = ProductID;
    }

    public Globals.Category getCategory() {
        return this.category;
    }

    public String getName() {
        return this.productName;
    }

    public String getProductID() {
        return this.ProductID;
    }

    public float getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quanitityAvailable;
    }

    public void UpdateQuantity(int Quantity) {
        this.quanitityAvailable = Quantity;
    }
}
