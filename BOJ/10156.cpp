#include <iostream>

using namespace std;

int main() {
	int K, N, M;
	cin >> K >> N >> M;
	int answer = K * N - M;
	answer = answer < 0 ? 0 : answer;
	cout << answer;
}