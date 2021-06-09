#include <iostream>
#include <algorithm>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	int N;
	cin >> N;
	int* D = new int[N];
	for (int i = 0; i < N; i++) cin >> D[i];
	sort(D, D + N);
	if (N % 2 == 1) cout << D[N / 2] * D[N / 2];
	else cout << D[0] * D[N - 1];
}