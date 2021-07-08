#include <iostream>
using namespace std;


int main() {
	int N, K, M;
	cin >> N >> K >> M;
	K--, M--;
	int answer = 0;
	while (true) {
		if (K == M) break;
		K = K >> 1;
		M = M >> 1;
		answer++;
	}
	cout << answer;
}