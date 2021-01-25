#include <iostream>
#include <vector>
#include <queue> 
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int N, M, X, R, answer = 0;
	cin >> N;
	queue<int> Q;
	vector<int>* child = new vector<int>[N];
	for (int i = 0; i < N; i++) {
		cin >> X;
		if (X == -1) Q.push(i);
		else child[X].push_back(i);
	}

	cin >> M;

	while (!Q.empty()) {
		X = Q.front();
		Q.pop();
		if (X == M) continue;
		if (child[X].size() == 0) answer++;
		else if (child[X].size() == 1 && child[X].front() == M) answer++;
		else {
			for (int v : child[X]) {
				Q.push(v);
			}
		}
	}
	cout << answer;
}