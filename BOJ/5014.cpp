#include <iostream>
#include <cstring>
#include <queue>
using namespace std;


int main() {
	int F, S, G, U, D;
	cin >> F >> S >> G >> U >> D;

	int* count = new int[F + 1];
	memset(count, -1, sizeof(int) * (F + 1));

	queue<int> Q;
	Q.push(S);
	count[S] = 0;

	if (S == G) {
		cout << 0;
		return 0;
	}

	while (!Q.empty()) {
		int now = Q.front();
		Q.pop();

		if (now + U <= F) {
			if (now + U == G) {
				cout << count[now] + 1;
				return 0;
			}
			if (count[now + U] == -1) {
				count[now + U] = count[now] + 1;
				Q.push(now + U);
			}
		}
		if (now - D > 0) {
			if (now - D == G) {
				cout << count[now] + 1;
				return 0;
			}
			if (count[now - D] == -1) {
				count[now - D] = count[now] + 1;
				Q.push(now - D);
			}
		}
	}

	cout << "use the stairs";
}