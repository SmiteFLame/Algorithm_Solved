#include <iostream>
#include <cstring>
#define M 10001
using namespace std;

int main(void) {
	int T, N, i, j;
	bool* D = new bool[M];
	memset(D, false, sizeof(bool) * M);

	D[0] = D[1] = true;

	for (i = 2; i < M; i++) {
		if (D[i] == false) {
			for (j = i * 2; j < M; j += i) {
				D[j] = true;
			}
		}
	}

	cin >> T;
	for (i = 1; i <= T; i++) {
		cin >> N;
		for (j = N / 2; j < N; j++) {
			if (D[j] || D[N - j]) continue;
			cout << N - j << " " << j << endl;
			break;
		}
	}
}