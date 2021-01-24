#include <iostream>
#include <cstring>
#include <queue>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int N, K, L, X, Y, C = 0;
	int NEWS[4][2] = { {0,1},{1,0},{0,-1},{-1,0} };
	char Z;
	cin >> N >> K;
	int** map = new int* [N];
	queue<pair<int, int>> Q;
	queue<pair<int, char>> QofL;

	for (int i = 0; i < N; i++) {
		map[i] = new int[N];
		memset(map[i], 0, sizeof(int) * N);
	}
	for (int i = 0; i < K; i++) {
		cin >> X >> Y;
		map[X - 1][Y - 1] = 1;
	}
	cin >> L;

	for (int i = 0; i < L; i++) {
		cin >> X >> Z;
		QofL.push(make_pair(X, Z));
	}
	X = 0;
	Y = 0;
	L = 0;

	Q.push(make_pair(X, Y));
	map[X][Y] = 2;
	while (true) {
		C++;
		X += NEWS[L][0];
		Y += NEWS[L][1];

		if (X < 0 || X >= N || Y < 0 || Y >= N || map[X][Y] == 2) break;
		Q.push(make_pair(X, Y));
		if (map[X][Y] != 1) {
			map[Q.front().first][Q.front().second] = 0;
			Q.pop();
		}
		else {
			map[X][Y] = 0;
		}
		map[X][Y] = 2;

		if (!QofL.empty() && QofL.front().first == C) {
			if (QofL.front().second == 'D') {
				L = L == 3 ? 0 : L + 1;
			}
			else {
				L = L == 0 ? 3 : L - 1;
			}
			QofL.pop();
		}
	}
	cout << C;
}