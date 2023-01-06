import demo.DemoPlatform;
import ecomm.Platform;
import ecomm.Seller;
import demo.Sellers.*;

import java.util.*;

public class PlatformMain
{
	public static void main(String[] args)
	{
		Platform pf = new DemoPlatform();	// Instance of DemoPlatform
		
		Seller s1 = new Seller1("Achintya");	// First seller
		Seller s2 = new Seller2("Adithya");	// Second seller
		Seller s3 = new Seller3("Shrey");	// Third seller
		// Adding Platform pf to 3 sellers
		s1.addPlatform(pf);
		s2.addPlatform(pf);
		s3.addPlatform(pf);
		// Adding 3 sellers to platform pf
		pf.addSeller(s1);
		pf.addSeller(s2);
		pf.addSeller(s3);

		Scanner sc = new Scanner(System.in);

		String command;	// User command

		while (true)
		{
			command = sc.next();
			if (command.equals("Check"))	// Platform has to process requests from the user
				pf.processRequests();
			else if (command.equals("End"))
				break;
		}

		sc.close();
	}
}