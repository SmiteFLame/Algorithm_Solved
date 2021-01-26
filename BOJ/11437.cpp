#include <iostream>
#include <cstring>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int N, M, X, Y;
	cin >> N;
	vector<int>* data = new vector<int>[N + 1];
	int* parent = new int[N + 1];
	int* level = new int[N + 1];
	memset(parent, -1, sizeof(int) * (N + 1));
	memset(level, 0, sizeof(int) * (N + 1));
	for (int i = 1; i < N; i++) {
		cin >> X >> Y;
		data[X].push_back(Y);
		data[Y].push_back(X);
	}

	parent[1] = 0;

	queue<int> Q;
	Q.push(1);

	while (!Q.empty()) {
		X = Q.front();
		Q.pop();
		for (auto v : data[X]) {
			if (parent[v] != -1) continue;
			parent[v] = X;
			Q.push(v);
		}
	}
	for (int i = 1; i <= N; i++) {
		X = i;
		while (X != 0) {
			if (level[X] != 0) {
				level[i] += level[X];
				break;
			}
			level[i]++;
			X = parent[X];
		}

	}

	cin >> M;
	for (int t = 0; t < M; t++) {
		cin >> X >> Y;
		if (level[X] < level[Y]) {
			swap(X, Y);
		}
		int end = level[X] - level[Y];
		for (int i = 0; i < end; i++) {
			X = parent[X];
		}

		while (X != Y) {
			X = parent[X];
			Y = parent[Y];
		}
		cout << X << "\n";
	}
}