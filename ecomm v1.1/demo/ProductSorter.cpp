#include <bits/stdc++.h>
using namespace std;
#include "ProductSorter.h"

ProductSorter::ProductSorter() {};

void ProductSorter::setParameter(string parameter)
{
	this->parameter = parameter;
}

bool ProductSorter::operator()(vector<string> v1, vector<string> v2)
{
	if (parameter == "Price")	// To sort by product price
		return stof(v1[4]) < stof(v2[4]);

	else if (parameter == "Name")	// To sort by product name
		return v1[2] < v2[2];

	return false;
}