#include <iostream>
#include <cstring>
#include <queue>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N, M;
	cin >> N >> M;
	int** map = new int* [N];
	int** maxMap = new int* [N];
	for (int i = 0; i < N; i++) {
		map[i] = new int[M];
		maxMap[i] = new int[M];
		memset(maxMap[i], -1, sizeof(int) * M);
		for (int j = 0; j < M; j++) cin >> map[i][j];
	}
	maxMap[0][0] = map[0][0];
	queue<vector<int>> Q;
	Q.push({ 0,0 });
	while (!Q.empty()) {
		vector<int> V = Q.front();
		Q.pop();
		if (V[0] + 1 < N && maxMap[V[0] + 1][V[1]] < maxMap[V[0]][V[1]] + map[V[0] + 1][V[1]]) {
			maxMap[V[0] + 1][V[1]] = maxMap[V[0]][V[1]] + map[V[0] + 1][V[1]];
			Q.push({ V[0] + 1 ,V[1] });
		}
		if (V[1] + 1 < M && maxMap[V[0]][V[1] + 1] < maxMap[V[0]][V[1]] + map[V[0]][V[1] + 1]) {
			maxMap[V[0]][V[1] + 1] = maxMap[V[0]][V[1]] + map[V[0]][V[1] + 1];
			Q.push({ V[0] ,V[1] + 1 });
		}
	}
	cout << maxMap[N - 1][M - 1];
}