package demo;

import ecomm.Globals.Category;
import ecomm.*;
import java.util.*;
import java.io.*;

// DemoPlatform inherits from Platform
public class DemoPlatform extends Platform
{
	private ArrayList<Seller> seller_list = new ArrayList<Seller> ();	// List of the sellers

	@Override
	public boolean addSeller(Seller aSeller)
	{
		// Adds aSeller to seller_list
		this.seller_list.add(aSeller);
		return false;
	}

	public void writeToFile(ArrayList<String> lines, String file, boolean cond)
	{
		// Exception handling to avoid file not found error
		try
		{
			FileWriter myWriter = new FileWriter(file, cond);	// Object of FileWriter
			for (String line: lines)
				myWriter.write(line + '\n');	// Writes each element of lines to file

			myWriter.close();
		}

		catch (IOException e)
		{
			e.printStackTrace();	// Prints the error
		}
	}

	public void process(String line)
	{
		// Splits individual line in the output file into words
		String[] params = line.split(" ");
		ArrayList<String> lines = new ArrayList<String> ();

		if (params[2].equals("Start"))
		{
			// Start adding parameters to lines
			String thisL = params[0] + " " + params[1] + " ";
			Globals thisG = new Globals();

			// Iterates through the enum to display the categories
			for (Globals.Category cat: Globals.Category.values())
			{
				thisL += thisG.getCategoryName(cat);
				thisL += " ";
			}

			lines.add(thisL);
		}
		else if (params[2].equals("List"))
		{
			// Stores the list of products across all sellers
			ArrayList<Product> ListOfProducts = new ArrayList < > ();

			// Iterates through the seller list
			for (Seller seller: seller_list)
			{
				ArrayList<Product> SellerProducts = new ArrayList < > ();
				Category category = Category.Mobile;
				if (params[3].equals("Mobile"))
					category = Category.Mobile;
				else if (params[3].equals("Book"))
					category = Category.Book;

				//stores the products corresponding to particular seller and category
				SellerProducts = seller.findProducts(category);
				for (Product y: SellerProducts)
					ListOfProducts.add(y);
			}

			for (Product y: ListOfProducts)
			{
			 	// iterates through product list appending finl output to line array
				lines.add((params[0] + " " + params[1] + " ") +
					(y.getName() + " " + y.getProductID() + " " + y.getPrice() + " " + y.getQuantity()));
			}
		}
		else if (params[2].equals("Buy"))
		{
			Boolean flag = false;

			//scans through seller list looking for the item with given product id and quantity
			for (Seller seller: seller_list)
			{
			 	//if found with sufficient quantity then success
				if (seller.buyProduct(params[3], Integer.parseInt(params[4])))
				{
					flag = true;
					break;
				}
			}

			//formatted output
			if (flag)
				lines.add((params[0] + " " + params[1] + " ") + "Success");
			else
				lines.add((params[0] + " " + params[1] + " ") + "Failure");
		}

		//functions called to append the lines array to file
		writeToFile(lines, "demo/"+Globals.fromPlatform, true);

		//function called to clear the PortalToPlatform file
		writeToFile(new ArrayList<String> (), "demo/"+Globals.toPlatform, false);
	}

	@Override
	public void processRequests()
	{
		// Exception handling to avoid file not found error
		try
		{
			File file = new File("demo/"+Globals.toPlatform);
			Scanner Reader = new Scanner(file);
			while (Reader.hasNextLine())
			{
			 	//scans line by line thorugh the PortalToPLatform and calls function
				String line = Reader.nextLine();
				process(line);
			}

			Reader.close();
		}

		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}