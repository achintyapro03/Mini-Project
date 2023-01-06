package demo.Sellers;

import ecomm.Seller;
import demo.MyProduct;
import ecomm.Product;
import ecomm.Globals.Category;
import ecomm.Platform;
import java.util.ArrayList;
import demo.Mobile;
import demo.Book;

public class Seller2 extends Seller {

    // id is passed in by the class that instantiates sub-type of seller
    private String myID;
    private ArrayList<MyProduct> products;
    private Platform platform;

    public Seller2(String id) {
        super(id);
        this.products = new ArrayList<MyProduct>();
        this.myID = id;
        products.add(new Mobile("Karbonn", "Karbonn_Note_55", 5999.99f, 10));
        products.add(new Book("Harry_Potter", "HP125", 2000.50f, 53));
        products.add(new Mobile("Apple", "iphone_9_x", 70000.99f, 20));
        products.add(new Mobile("OnePlus", "OnePlus10", 23000.00f, 80));
        products.add(new Book("Alchemist", "Alch1234", 500.5f, 15));
    }

    // ID of seller.
    public String getID() {
        return this.myID;
    }

    // Platform it is being added to.
    // Should in turn add itself to the Platform (with addSeller)
    public void addPlatform(Platform thePlatform) {
        this.platform = thePlatform;
    }

    public ArrayList<Product> findProducts(Category whichOne) {
        ArrayList<Product> searchResult = new ArrayList<Product>();
        for (MyProduct x : products) {
            if (x.getCategory() == whichOne) {
                searchResult.add(x);
            }
        }
        return searchResult;
    }

    // Seller to return listing of Products of specified Category
    // User wants to buy specified quantity of productID
    // Return true if transaction succeeds, false otherwise.
    // Transaction fails if incorrect productID or quantity exceeds available
    // inventory
    public boolean buyProduct(String productID, int quantity) {
        boolean flag = false;
        // System.out.println(quantity);
        for (MyProduct x : products) {
            if (x.getProductID().equals(productID)) {
                // System.out.println(x.getQuantity());
                if (x.getQuantity() >= quantity) {
                    flag = true;
                    x.UpdateQuantity(x.getQuantity() - quantity);
                } else
                    flag = false;
                break;
            }
        }
        return flag;
    }
}
