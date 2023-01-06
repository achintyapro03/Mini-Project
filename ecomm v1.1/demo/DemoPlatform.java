package demo;

import ecomm.Globals.Category;
import ecomm.*;
import java.util.*;
import java.io.*;

public class DemoPlatform extends Platform {

	private ArrayList<Seller> seller_list = new ArrayList<Seller>();

	@Override
	public boolean addSeller(Seller aSeller) {
		this.seller_list.add(aSeller);
		return false;
	}

	public void writeToFile(ArrayList<String> lines, String file, boolean cond) {

		try {
			FileWriter myWriter = new FileWriter(file, cond);
			for (String line : lines)
				myWriter.write(line + '\n');

			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void process(String line) {
		String[] params = line.split(" ");
		ArrayList<String> lines = new ArrayList<String>();

		if (params[2].equals("Start")) {
			lines.add((params[0] + " " + params[1] + " ") + "Mobile Book");
		} else if (params[2].equals("List")) {
			ArrayList<Product> ListOfProducts = new ArrayList<>();
			for (Seller seller : seller_list) {
				ArrayList<Product> SellerProducts = new ArrayList<>();
				Category category = Category.Mobile;
				if (params[3].equals("Mobile")) {
					category = Category.Mobile;
				} else if (params[3].equals("Book")) {
					category = Category.Book;
				}
				SellerProducts = seller.findProducts(category);
				for (Product y : SellerProducts) {
					ListOfProducts.add(y);
				}
			}

			for (Product y : ListOfProducts) {
				lines.add((params[0] + " " + params[1] + " ")
						+ (y.getName() + " " + y.getProductID() + " " + y.getPrice() + " " + y.getQuantity()));
			}
		} else if (params[2].equals("Buy")) {
			Boolean flag = false;
			for (Seller seller : seller_list) {
				if (seller.buyProduct(params[3], Integer.parseInt(params[4]))) {
					flag = true;
					break;
				}
			}
			if (flag)
				lines.add((params[0] + " " + params[1] + " ") + "Success");
			else
				lines.add((params[0] + " " + params[1] + " ") + "Failure");
		}
		writeToFile(lines, "demo/PlatformToPortal.txt", true);

		writeToFile(new ArrayList<String>(), "demo/PortalToPlatform.txt", false);
	}

	@Override
	public void processRequests() {
		try {
			File file = new File("demo/PortalToPlatform.txt");
			Scanner Reader = new Scanner(file);
			while (Reader.hasNextLine()) {
				String line = Reader.nextLine();
				process(line);
			}
			Reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
