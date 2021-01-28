#include <iostream>
#include <queue>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int N, M, K, x, y, X, Y;
	cin >> N >> M;
	int** data = new int* [N];
	for (int i = 0; i < N; i++) {
		data[i] = new int[M];
		for (int j = 0; j < M; j++) cin >> data[i][j];
	}

	cin >> K;
	for (int i = 0; i < K; i++) {
		cin >> x >> y >> X >> Y;
		int sum = 0;
		for (int k = x - 1; k < X; k++) {
			for (int l = y - 1; l < Y; l++) {
				sum += data[k][l];
			}
		}
		cout << sum << "\n";
	}
}