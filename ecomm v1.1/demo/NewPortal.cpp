#include <bits/stdc++.h>
#include <fstream>
using namespace std;

int main()
{

    string command;
    vector<string> lines;
    while (true)
    {
        getline(cin, command);

        if (command == "Check")
        {
            string line;
            ifstream Reader("PlatformToPortal.txt");
            while (getline(Reader, line))
            {
                lines.push_back(line);
                cout << line << endl;
            }
            Reader.close();
            ofstream hout("PlatformToPortal.txt");
            hout.close();
            continue;
        }
        ofstream hout;
        hout.open("PortalToPlatform.txt", ios_base::app);
        command = command + '\n';
        hout << command;
        hout.close();
    }
}
