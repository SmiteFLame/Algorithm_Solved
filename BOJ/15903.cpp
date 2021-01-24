#include <iostream>
#include <algorithm>
using namespace std;
int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int N, M;
	long long S = 0;
	cin >> N >> M;
	long long* data = new long long[N];
	for (int i = 0; i < N; i++) cin >> data[i];
	for (int i = 0; i < M; i++) {
		sort(data, data + N);
		data[0] += data[1];
		data[1] = data[0];
	}
	for (int i = 0; i < N; i++) {
		S += data[i];
	}
	cout << S;
}