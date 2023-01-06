#ifndef DEMOPORTAL_H
#define DEMOPORTAL_H
#include <bits/stdc++.h>
using namespace std;

class DemoPortal
{
	private:
		// used to store the instruction and is under process
		string instruction;

	// stroes the portalOD of the portalID and the requestID under precess
	int portalID, requestID;

	unordered_map<string, string> sortOrder;	// maps requestID to parameter of sorting
	map<string, vector < string>> output;	// maps requestID to the vector of lines of string

	public:
		// constructor
		DemoPortal();

	void processUserCommand(string);	// calledto process command

	void checkResponse();

	vector<string> split(string);	// splits the word based on spaces

	// a sorter function that takes in vector of strings and sort order and calls cpp sort on it with a comparator
	void sorter(vector < string>, string);
};


#endif