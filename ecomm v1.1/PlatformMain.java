import demo.DemoPlatform;
import ecomm.Platform;
import ecomm.Seller;
import demo.Sellers.*;

import java.util.*;

public class PlatformMain {

	public static void main(String[] args) {

		Platform pf = new DemoPlatform();  // replace with appropriate derived class
		
		// create a number of sellers (of different sub-types of Seller)
		// Assign a name (sellerID) to each of them.
		
		// replace each of the XYZ below with the derived class name of one of the
		// team members.
		
		
		Seller s1 = new Seller1("Seller1_ID"); 
		s1.addPlatform(pf);

		// Seller s2 = new SellerXYZ("Seller2");
		// s1.addPlatform(pf);
		
		// Seller s3 = new SellerXYZ2("Seller3");
		// s1.addPlatform(pf);
 		
		pf.addSeller(s1);
		// pf.addSeller(s2);
		// pf.addSeller(s3);
		
		/*
		// keep reading from System.in
		// If "Check" typed in
		// invoke 
			pf.processRequests();
		*/

		Scanner sc = new Scanner(System.in);

		String command;

		while(true){
			command = sc.next();
			if(command.equals("Check")) pf.processRequests();
		}	
		// sc.close();
	}

}
