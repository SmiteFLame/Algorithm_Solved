#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;
int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int N, M;
	string A;
	cin >> N >> M;
	map<string, bool> S;
	vector<string> V;
	for (int i = 0; i < N; i++) {
		cin >> A;
		S[A] = true;
	}
	for (int i = 0; i < M; i++) {
		cin >> A;
		if (S[A]) V.push_back(A);
	}
	sort(V.begin(), V.end());
	cout << V.size() << "\n";
	for (string v : V) {
		cout << v << "\n";
	}
}