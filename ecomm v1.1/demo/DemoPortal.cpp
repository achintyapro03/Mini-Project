#include "DemoPortal.h"
#include "ProductSorter.h"
#include <bits/stdc++.h>
using namespace std;

DemoPortal::DemoPortal()
{
	//constructor
	this->instruction = "";
	srand((unsigned) time(NULL));
	this->portalID = rand();
	this->requestID = rand();
}

void DemoPortal::processUserCommand(string command)
{
	//checkResponse is called and return to main
	if (command == "Check")
	{
		this->checkResponse();
		return;
	}

	//if List, then category and order input taken
	//appropriate instruction is generated and unordered_map that records the sort order is updated
	else if (command == "List")
	{
		string category, order;
		cin >> category >> order;

		this->instruction = to_string(this->portalID) + " " + to_string(this->requestID) + " List " + category;
		sortOrder[to_string(this->requestID)] = order;
	}

	//appropriate instruction is generated
	else if (command == "Start")
		this->instruction = to_string(this->portalID) + " " + to_string(this->requestID) + " Start ";

	//inputs taken and appropriate instruction is generated
	else if (command == "Buy")
	{
		string productID;
		int numItems;
		cin >> productID >> numItems;
		this->instruction = to_string(this->portalID) + " " + to_string(this->requestID) + " Buy " + productID + " " + to_string(numItems);
	}

	//file is opened in append mode and instruction is pasted
	ofstream hout;
	hout.open("PortalToPlatform.txt", ios_base::app);
	this->instruction = this->instruction + '\n';
	hout << this->instruction;
	hout.close();
	this->requestID++;
}

void DemoPortal::checkResponse()
{
	vector<string> lines;
	string line;

	//read from file
	ifstream Reader("PlatformToPortal.txt");
	while (getline(Reader, line))
		lines.push_back(line);
	Reader.close();

	//used to store the lines corresponding to a differnet portal
	vector<string> stringDiffPortal;
	for (string x: lines)
	{
		vector<string> params = split(x);
		if (params[0] == to_string(this->portalID))
			output[params[1]].push_back(x);
		//ignore if for different portal
		else
			stringDiffPortal.push_back(x);
	}

	//scans through the map
	for (auto x: output)
	{
		//if instruction is list, then valu corresponding to that sort order in the map is not empty
		//sorter function is called
		if (sortOrder[x.first] != "")
			sorter(x.second, sortOrder[x.first]);
		else
			cout << x.second[0] << endl;
	}

	ofstream hout("PlatformToPortal.txt");	// Opening the file in write mode
	for (auto line: stringDiffPortal)
		hout << (line + '\n');	//instruciton to differnet portals are pasted back

	hout.close();	// Closing the file

	lines.clear();
	output.clear();
	return;
}

vector<string> DemoPortal::split(string str)
{
	//split string at spaces
	str = str + " ";
	vector<string> words;
	string word = "";
	for (int i = 0; i < str.size(); i++)
	{
		if (str[i] == ' ')
		{
			words.push_back(word);
			word = "";
		}
		else
			word = word + str[i];
	}

	return words;
}

void DemoPortal::sorter(vector<string> lines, string order)
{
	//ecah string is split into words
	vector<vector < string>> params;
	for (auto x: lines)
		params.push_back(split(x));
	ProductSorter ProSorter = ProductSorter();	//comparator
	ProSorter.setParameter(order);
	sort(params.begin(), params.end(), ProSorter);

	//formatted output
	for (auto x: params)
	{
		for (auto y: x)
			cout << y << " ";
		cout << endl;
	}
}