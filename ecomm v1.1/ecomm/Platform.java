package ecomm;


public abstract class Platform {

	
	// Used by Seller to attach to Platform
	public abstract boolean addSeller(Seller aSeller);
	
	// checks the incoming messages (in file PortalToPlatform.txt) 
	//   for unprocessed requests
	// Invokes methods on Sellers as needed and writes out responses 
	//   (into file PlatformToPortal.txt)
	// This could be invoked by main when processing command line or in a timer
	public abstract void processRequests();
	// Should route requests to appropriate seller based on PortalID in the incoming message
	
}
