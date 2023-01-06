#include <bits/stdc++.h>
#include "demo/DemoPortal.h"

using namespace std;

int main()
{
	string command;
	DemoPortal *demo = new DemoPortal(); // portal object created
 
	while (true)
	{
		cin >> command; // command input is taken and process funtion called
		demo->processUserCommand(command);
	}
}
