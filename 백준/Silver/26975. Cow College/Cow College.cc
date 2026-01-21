#include <iostream>
#include <algorithm>
using namespace std;
typedef long long ll;

int N;
ll A[100000];
ll ans, anstuit;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	for (int i = 0; i < N; i++) cin >> A[i];
	sort(A, A + N, greater());

	for (int i = 0; i < N; i++) {
		ll val = A[i] * (i + 1);
		if (val >= ans) ans = val, anstuit = A[i];
	}

	cout << ans << ' ' << anstuit;
}