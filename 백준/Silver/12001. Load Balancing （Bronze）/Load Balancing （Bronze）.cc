#include <bits/stdc++.h>
using namespace std;
 
int N, B;
vector<pair<int, int>> pos;
 
int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
 
    cin >> N >> B;
    for(int i = 0; i < N; i++) {
        int x, y;
        cin >> x >> y;
        pos.push_back({x, y});
    }
 
    int ans = 1e9;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            int a = pos[i].first + 1, b = pos[j].second + 1;
            int cnt[4] ={};
            for(int k = 0; k < N; k++) {
                int x = pos[k].first, y = pos[k].second;
                if(x > a && y > b) cnt[0]++;
                else if(x < a && y > b) cnt[1]++;
                else if(x > a && y < b) cnt[2]++;
                else cnt[3]++;
            }
            int M = 0;
            for(int k = 0; k < 4; k++)
                M = max(M, cnt[k]);
            ans = min(ans, M);
        }
    }
 
    cout << ans << '\n';
    return 0;
}