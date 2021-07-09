#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

int N, M;
int NEWS[4][2] = { {1, 0}, {-1, 0} , {0, 1} ,{0, -1} };

bool canMove(int X, int Y) {
	return !(X < 0 || Y < 0 || X >= N || Y >= M);
}

int** copyMap(int** nowMap) {
	int** nextMap = new int* [N];
	for (int i = 0; i < N; i++) {
		nextMap[i] = new int[M];
		for (int j = 0; j < M; j++) {
			nextMap[i][j] = nowMap[i][j];
		}
	}
	return nextMap;
}

int main() {
	int answer = 0;
	cin >> N >> M;
	vector<pair<int, int>> V;
	int** map = new int* [N];
	for (int i = 0; i < N; i++) {
		map[i] = new int[M];
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
			if (map[i][j] == 0) continue;
			V.push_back(make_pair(i, j));
		}
	}
	while (++answer) {
		int** newMap = copyMap(map);
		vector<pair<int, int>> nextV;

		for (pair<int, int> now : V) {
			for (int x = 0; x < 4; x++) {
				int nx = now.first + NEWS[x][0];
				int ny = now.second + NEWS[x][1];
				if (!canMove(nx, ny)) continue;
				if (map[nx][ny] != 0) continue;
				newMap[now.first][now.second] -= 1;
			}
			if (newMap[now.first][now.second] <= 0) {
				newMap[now.first][now.second] = 0;
			}
			else {
				nextV.push_back(make_pair(now.first, now.second));
			}
		}
		bool** visited = new bool* [N];

		for (int i = 0; i < N; i++) {
			visited[i] = new bool[M];
			memset(visited[i], false, sizeof(bool) * M);
		}
		if (nextV.size() == 0) {
			answer = 0;
			break;
		}
		int cnt = 1;
		queue<pair<int, int>> Q;
		Q.push(nextV[0]);
		visited[nextV[0].first][nextV[0].second] = true;
		while (!Q.empty()) {
			pair<int, int> now = Q.front();
			Q.pop();
			for (int x = 0; x < 4; x++) {
				int nx = now.first + NEWS[x][0];
				int ny = now.second + NEWS[x][1];
				if (!canMove(nx, ny)) continue;
				if (newMap[nx][ny] == 0) continue;
				if (visited[nx][ny]) continue;
				Q.push(make_pair(nx, ny));
				visited[nx][ny] = true;
				cnt++;
			}
		}
		if (cnt != nextV.size()) {
			break;
		}

		V = nextV;

		map = copyMap(newMap);
	}
	cout << answer;
}