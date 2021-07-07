#include <iostream>
#include <climits>
#include <cstring>

using namespace std;

bool* visited;
int N;
int answer = INT_MAX;
int** map;

void DFS(int start, int now, int sum, int cnt) {
	if (cnt == N && start == now) {
		answer = sum < answer ? sum : answer;
		return;
	}

	if (sum > answer) {
		return;
	}

	for (int i = 0; i < N; i++) {
		if (visited[i]) continue;
		if (map[now][i] == 0) continue;
		visited[i] = true;
		DFS(start, i, sum + map[now][i], cnt + 1);
		visited[i] = false;
	}
}

int main() {
	cin >> N;

	map = new int* [N];
	for (int i = 0; i < N; i++) {
		map[i] = new int[N];
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
		}
	}

	for (int i = 0; i < N; i++) {
		visited = new bool[N];
		memset(visited, false, sizeof(bool) * N);
		DFS(i, i, 0, 0);
	}

	cout << answer;
}