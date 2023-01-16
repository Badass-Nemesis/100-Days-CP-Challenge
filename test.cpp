#include <bits\stdc++.h>
using namespace std;

int main()
{
    int tt;
    cin >> tt;
    while (tt--)
    {
        int n;
        cin >> n;
        long long int t[n];
        for (long long int i = 0; i < n; i++)
        {
            cin >> t[i];
        }
        sort(t, t + n);
        int ans = t[0] != 0;
        for (long long int i = 0; i < n; i++)
        {
            if (t[i] <= i && (i == n - 1 || t[i + 1] > i + 1))
                ans++;
        }
        cout << ans << endl;
    }
    return 0;
}