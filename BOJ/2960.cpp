#include <iostream>
#include <cstring>

using namespace std;

int main() {
	int N, K;
	cin >> N >> K;

	bool* check = new bool[N + 1];
	memset(check, false, sizeof(bool) * (N + 1));

	for (int i = 2; i <= N; i++) {
		for (int j = i; j <= N; j += i) {
			if (check[j]) continue;
			check[j] = true;
			K--;
			if (K == 0) {
				cout << j << endl;
				return 0;
			}
		}
	}
}