package demo;

import ecomm.Globals;

public class Book extends MyProduct {
    private String productName, ProductID;
    private float price;
    private int quanitityAvailable;
    private Globals.Category category;

    public Book(String productName, String ProductID, float price, int quanitityAvailable) {
        super();
        this.category = Globals.Category.Book;
        this.price = price;
        this.productName = productName;
        this.quanitityAvailable = quanitityAvailable;
        this.ProductID = ProductID;
    }

    public Globals.Category getCategory() {
        return this.category;
    }

    public String getName() {
        return productName;
    }

    public String getProductID() {
        return ProductID;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quanitityAvailable;
    }

    public void UpdateQuantity(int Quantity) {
        this.quanitityAvailable = Quantity;
    }

}
