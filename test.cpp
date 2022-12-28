#include <bits/stdc++.h>
using namespace std;
void printGraph(vector<vector<int>> graph[], int n)
{

    for (int i = 1; i <= n; i++)
    {

        for (auto it : graph[i])
        {

            cout << "source"
                 << "->" << i << "neighbour" << it[0] << "and weight" << it[1];
        }
        cout << endl;
    }
}
int main()
{
    int n;
    int m;

    vector<vector<int>> graph[n + 1];
    for (int i = 1; i < m; i++)
    {
        int u, v, wt;
        cin >> u >> v >> wt;
        vector<int> t1;
        vector<int> t2;
        t1.push_back(u);
        t1.push_back(wt);
        graph[v].push_back(t1);
        t2.push_back(v);
        t2.push_back(wt);
        graph[u].push_back(t2);
    }
    //   cout<<"work";
    printGraph(graph, n);
}