package demo.Sellers;
import ecomm.Seller;
import ecomm.Product;
import ecomm.Globals.Category;
import ecomm.Platform;
import java.util.ArrayList;
import demo.Mobile;
import demo.Book;

public class Seller1 extends Seller {

	// id is passed in by the class that instantiates sub-type of seller
    private String myID;
    private ArrayList <Product> products;
    private Platform platform;

	public Seller1(String id) {
        super(id);
        this.products = new ArrayList<Product>();
		this.myID = id;
        products.add(new Mobile("Nokia","NokiaOP","123",30,10));
        products.add(new Book("Game of Thrones","GOT","1093",6456,78));
        products.add(new Mobile("Apple","iphone100","987",5000,20));
        products.add(new Mobile("Samsung","SammySO","490",280,110));
        products.add(new Book("SasthaGOT","SasthaGOTOP","4218",430,210));
	}
	
	// ID of seller. 
	public String getID() { return this.myID;}
	
	// Platform it is being added to.
	// Should in turn add itself to the Platform (with addSeller)
	public void addPlatform(Platform thePlatform){
        this.platform = thePlatform;
    }
	
	// Seller to return listing of Products of specified Category
	public ArrayList<Product> findProducts(Category whichOne){
        ArrayList <Product> searchResult = new ArrayList<Product>();
        for(Product x : products)
        {
            if(x.getCategory() == whichOne)
            {
                searchResult.add(x);
            }
        }
        return searchResult;
    }
	// User wants to buy specified quantity of productID
	// Return true if transaction succeeds, false otherwise. 
	// Transaction fails if incorrect productID or quantity exceeds available inventory
	public boolean buyProduct(String productID, int quantity){
        boolean flag = false;
        System.out.println(quantity);
        for(Product x : products){
            if(x.getProductID().equals(productID))
            {
                System.out.println(x.getQuantity());
                if(x.getQuantity() >= quantity) {
                    flag = true;
                    x.UpdateQuantity(x.getQuantity() - quantity);
                }
                else flag = false;
                break;
            }
        }
        return flag;
    }
}
