#include <iostream>
#include <string>
using namespace std;

int** map;
int W = 0, B = 0;

void DFS(int X, int Y, int N) {
	int cnt = 0;
	for (int i = X; i < X + N; i++) {
		for (int j = Y; j < Y + N; j++) {
			if (map[i][j] == 1) {
				cnt++;
			}
		}
	}
	if (cnt == 0) W++;
	else if (cnt == N * N) B++;
	else {
		DFS(X, Y, N / 2);
		DFS(X, Y + N / 2, N / 2);
		DFS(X + N / 2, Y, N / 2);
		DFS(X + N / 2, Y + N / 2, N / 2);
	}
}
int main() {
	int N;
	cin >> N;
	map = new int* [N];
	for (int i = 0; i < N; i++) {
		map[i] = new int[N];
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
		}
	}
	DFS(0, 0, N);
	cout << W << endl << B;

}