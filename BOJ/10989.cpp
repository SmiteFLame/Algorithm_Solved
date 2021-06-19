#include <iostream>
#include <cstring>
using namespace std;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int N, T, i, j;
	cin >> N;
	int* D = new int[10001];
	memset(D, 0, sizeof(D) * 10001);
	for (i = 0; i < N; i++) {
		cin >> T;
		D[T]++;
	}
	for (i = 0; i <= 10000; i++) {
		for (j = 0; j < D[i]; j++) {
			cout << i << "\n";
		}
	}
}