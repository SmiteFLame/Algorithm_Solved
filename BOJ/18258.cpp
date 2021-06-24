#include <iostream>
#include <queue>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, T;
	string S;
	cin >> N;
	queue<int> Q;
	for (int i = 0; i < N; i++) {
		cin >> S;
		if (S == "push") {
			cin >> T;
			Q.push(T);
		}
		else if (S == "pop") {
			if (Q.empty()) cout << -1 << "\n";
			else {
				cout << Q.front() << "\n";
				Q.pop();
			}
		}
		else if (S == "size") cout << Q.size() << "\n";

		else if (S == "empty") {
			if (Q.empty()) cout << 1 << "\n";
			else cout << 0 << "\n";
		}
		else if (S == "front") {
			if (Q.empty()) cout << -1 << "\n";
			else cout << Q.front() << "\n";
		}
		else if (S == "back") {
			if (Q.empty()) cout << -1 << "\n";
			else cout << Q.back() << "\n";
		}
	}
}