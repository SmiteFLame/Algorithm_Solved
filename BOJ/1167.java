#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int N, P, T, L;
pair<int, int> X, M = make_pair(0, 0);
vector<pair<int, int>>* V;

void BFS(int S) {
	bool* B = new bool[N];
	memset(B, false, sizeof(bool) * N);
	B[S] = true;
	queue<pair<int, int>> Q;
	Q.push(make_pair(S, 0));
	while (!Q.empty()) {
		X = Q.front();
		Q.pop();
		if (X.second > M.second) M = X;
		for (auto v : V[X.first]) {
			if (B[v.first]) continue;
			B[v.first] = true;
			Q.push(make_pair(v.first, v.second + X.second));
		}
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	cin >> N;
	V = new vector<pair<int, int>>[N];
	for (int i = 0; i < N; i++) {
		cin >> P;
		while (true) {
			cin >> T;
			if (T == -1) break;
			cin >> L;
			V[P - 1].push_back(make_pair(T - 1, L));
		}
	}

	BFS(0);
	BFS(M.first);
	cout << M.second;
}