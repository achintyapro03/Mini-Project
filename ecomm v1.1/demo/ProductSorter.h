#ifndef PRODUCTSORTER_H
#define PRODUCTSORTER_H
#include <bits/stdc++.h>
using namespace std;
class ProductSorter
{
private:
    string parameter;

public:
    ProductSorter();
    void setParameter(string); // sets the parameter for sorting
    bool operator()(vector<string>, vector<string>);
};

#endif