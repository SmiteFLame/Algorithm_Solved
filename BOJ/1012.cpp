#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

int X[4][2] = { {1,0},{-1,0} ,{0,1} ,{0,-1} };

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int T, i, j, A, B, N, M, C, x, S;
	cin >> T;
	for (int t = 0; t < T; t++) {
		S = 0;
		cin >> N >> M >> C;
		bool** D = new bool* [N];
		for (i = 0; i < N; i++) {
			D[i] = new bool[M];
			memset(D[i], false, sizeof(bool) * M);
		}
		for (i = 0; i < C; i++) {
			cin >> A >> B;
			D[A][B] = true;
		}
		for (i = 0; i < N; i++) {
			for (j = 0; j < M; j++) {
				if (D[i][j]) {
					S++;
					queue<pair<int, int>> Q;
					Q.push(make_pair(i, j));
					D[i][j] = false;
					while (!Q.empty()) {
						pair<int, int> P = Q.front();
						for (x = 0; x < 4; x++) {
							if (P.first + X[x][0] >= 0 && P.second + X[x][1] >= 0 && P.first + X[x][0] < N && P.second + X[x][1] < M && D[P.first + X[x][0]][P.second + X[x][1]]) {
								D[P.first + X[x][0]][P.second + X[x][1]] = false;
								Q.push(make_pair(P.first + X[x][0], P.second + X[x][1]));
							}
						}
						Q.pop();
					}
				}
			}
		}
		cout << S << endl;
	}
}