#include <iostream>
using namespace std;
int main()
{
    int t;
    int cnt = 0;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;
        int rowc[n][n] = {0};
        int columnc[n][n] = {0};
        // its time to take the input 2d matrix
        char mx[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                cin >> mx[i][j];
            }
        }
        // its time to precompute
        for (int i = 0; i < n; i++)
        {
            for (int j = n - 1; j >= 0; j--)
            {
                rowc[i][j] = 0;
                if (j == n - 1)
                {
                    if (mx[i][j] == '.')
                        rowc[i][j] == 1;
                }
                else
                {
                    if (mx[i][j] == '#')
                    {
                        if (mx[i][j + 1] == '.')
                            rowc[i][j] == 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                cout << rowc[i][j] << " ";
            }
            cout << "\n";
        }
        for (int j = 0; j < n; j++)
        {
            for (int i = n - 1; i >= 0; i--)
            {
                if (i == n - 1)
                {
                    if (mx[i][j] == '.')
                        columnc[i][j] == 1;
                }
                else
                {
                    if (mx[i][j] == '#')
                    {
                        if (mx[i + 1][j] == '.')
                            columnc[i][j] == 1;
                    }
                }
            }
        }
        // now that the precomputation is done we are going to check if to the corresponding values of i and j in rowc and columnc if both are 1
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (rowc[i][j] & columnc[i][j])
                    cnt++;
            }
        }
        cout << cnt << "\n";
    }
}