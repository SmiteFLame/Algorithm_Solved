#include <iostream>
#include <cstring>
using namespace std;

bool** B;
int N, A = 0;

void DFS(int C) {
	if (C == N) {
		A++;
		return;
	}

	for (int i = 0; i < N; i++) {
		bool T = false;

		for (int j = 0; j < C; j++) T = B[j][i] ? true : T;
		if (T) continue;

		for (int j = 1; j <= C; j++) {
			if (i - j >= 0) T = B[C - j][i - j] ? B[C - j][i - j] : T;
			if (i + j < N) T = B[C - j][i + j] ? B[C - j][i + j] : T;
		}
		if (T) continue;
		B[C][i] = true;
		DFS(C + 1);
		B[C][i] = false;
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	cin >> N;
	B = new bool* [N];
	for (int i = 0; i < N; i++) {
		B[i] = new bool[N];
		memset(B[i], false, sizeof(bool) * N);
	}
	DFS(0);
	cout << A;
}