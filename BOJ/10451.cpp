#include <iostream>
#include <cstring>

using namespace std;

int main() {
	int T;
	cin >> T;
	for (int t = 0; t < T; t++) {
		int N, cnt = 0;
		cin >> N;
		int* move = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			cin >> move[i];
		}
		bool* check = new bool[N + 1];
		memset(check, false, sizeof(bool) * (N + 1));
		for (int i = 1; i <= N; i++) {
			bool* visited = new bool[N + 1];
			memset(visited, false, sizeof(bool) * (N + 1));
			visited[i] = true;
			int now = move[i];
			while (i != now) {
				if (check[now] || visited[now]) break;
				visited[now] = true;
				now = move[now];
			}
			if (i == now) cnt++;
			check[i] = true;
			delete[] visited;
		}
		delete[] check;
		cout << cnt << "\n";
	}
}