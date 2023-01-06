#include <bits/stdc++.h>
#include <fstream>
#include "ProductSorter.h"
using namespace std;

vector<string> split(string str)
{
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

void sorter(vector<string> lines, string order)
{
    vector<vector<string>> params;
    for (auto x : lines)
        params.push_back(split(x));
    ProductSorter ProSorter = ProductSorter();
    ProSorter.setParameter(order);
    sort(params.begin(), params.end(), ProSorter);

    for (auto x : params)
    {
        for (auto y : x)
        {
            cout << y << " ";
        }
        cout << endl;
    }
}

int main()
{

    string command;
    vector<string> lines;

    vector<string> sortParam;

    string instruction = "";
    srand((unsigned)time(NULL));
    int portalID = rand();
    int requestID = rand();

    unordered_map<string, string> sortOrder; // maps requestID to parameter of sorting
    map<string, vector<string>> output;

    while (true)
    {
        // getline(cin, command);
        cin >> command;

        if (command == "Check")
        {
            string line;
            ifstream Reader("PlatformToPortal.txt");
            while (getline(Reader, line))
            {
                lines.push_back(line);
                // cout << line << endl;
            }
            vector<string> stringDiffPortal;
            for (string x : lines)
            {
                vector<string> params = split(x);
                if (params[0] == to_string(portalID))
                    output[params[1]].push_back(x);
                else
                {
                    stringDiffPortal.push_back(x);
                }
            }

            for (auto x : output)
            {
                if (sortOrder[x.first] != "")
                {
                    sorter(x.second, sortOrder[x.first]);
                }
                else
                {
                    cout << x.second[0] << endl;
                }
            }

            Reader.close();
            ofstream hout("PlatformToPortal.txt"); // Opening the file in write mode
            for (auto line : stringDiffPortal)
                hout << (line + '\n');
            hout.close(); // Closing the file

            lines.clear();
            output.clear();
            continue;
        }
        else if (command == "List")
        {
            string category, order;
            cin >> category >> order;

            instruction = to_string(portalID) + " " + to_string(requestID) + " List " + category;
            sortOrder[to_string(requestID)] = order;
        }
        else if (command == "Start")
        {
            instruction = to_string(portalID) + " " + to_string(requestID) + " Start ";
        }
        else if (command == "Buy")
        {
            string productID;
            int numItems;
            cin >> productID >> numItems;
            instruction = to_string(portalID) + " " + to_string(requestID) + " Buy " + productID + " " + to_string(numItems);
        }
        ofstream hout;
        hout.open("PortalToPlatform.txt", ios_base::app);
        instruction = instruction + '\n';
        hout << instruction;
        hout.close();
        requestID++;
    }
}
