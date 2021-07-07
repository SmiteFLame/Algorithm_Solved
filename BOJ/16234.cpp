#include <iostream>
#include <vector>
#include <queue>
#include <list>
#include <cmath>

using namespace std;

int N, L, R;
int NEWS[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };

bool canMove(int X, int Y) {
	return !(X < 0 || Y < 0 || X >= N || Y >= N);
}

int main() {
	cin >> N >> L >> R;

	// 데이터 입력
	int** data = new int* [N];
	for (int i = 0; i < N; i++) {
		data[i] = new int[N];
		for (int j = 0; j < N; j++) {
			cin >> data[i][j];
		}
	}

	int answer = 0;

	while (true) {
		// 1. 같은 지역들 묶기
		list<list<pair<int, int>>> nextlevel;
		bool** visited = new bool* [N];
		for (int i = 0; i < N; i++) {
			visited[i] = new bool[N];
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) continue;
				queue<pair<int, int>> Q;
				list<pair<int, int>> level;

				level.push_back(make_pair(i, j));
				Q.push(make_pair(i, j));
				visited[i][j] = true;

				while (!Q.empty()) {
					int X = Q.front().first;
					int Y = Q.front().second;
					Q.pop();
					for (int x = 0; x < 4; x++) {
						int nx = X + NEWS[x][0];
						int ny = Y + NEWS[x][1];
						if (!canMove(nx, ny) || visited[nx][ny]) continue;
						if (abs(data[X][Y] - data[nx][ny]) < L || abs(data[X][Y] - data[nx][ny]) > R) continue;
						visited[nx][ny] = true;
						level.push_back(make_pair(nx, ny));
						Q.push(make_pair(nx, ny));
					}
				}

				nextlevel.push_back(level);
			}
		}
		if (nextlevel.size() == N * N) break;

		answer++;

		for (auto level : nextlevel) {
			int sum = 0;
			for (auto person : level) {
				sum += data[person.first][person.second];
			}
			sum /= level.size();
			for (auto person : level) {
				data[person.first][person.second] = sum;
			}
		}

	}

	cout << answer;
}