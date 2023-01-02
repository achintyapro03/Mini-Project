package ecomm;

public class Globals {

	// Currently only 2 categories of products
	public enum Category {
		Mobile,
		Book
	}
	
	// String names of the above to used for writing/reading to message files or user interface
	public String getCategoryName(Category c) {
		switch(c) {
		case Mobile: 
			return "Mobile";
		case Book:
			return "Book";
		default:
			return "Error";
		}
	}

	public static String toPlatform = "PortalToPlatform.txt";
	public static String fromPlatform = "PlatformToPortal.txt";
		
}
