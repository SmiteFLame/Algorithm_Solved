#include <iostream>
#include <climits>
#include <algorithm>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	int N, M, A = INT_MAX;
	char C;
	cin >> N >> M;
	bool** B = new bool*[N];
	for (int i = 0; i < N; i++) {
		B[i] = new bool[M];
		for (int j = 0; j < M; j++) {
			cin >> C;
			B[i][j] = C == 'W' ? true : false;
		}
	}
	for (int i = 8; i <= N; i++) {
		for (int j = 8; j <= M; j++) {
			int C = 0;
			for (int k = i - 8; k < i; k++) {
				for (int l = j - 8; l < j; l++) {
					C += ((k + l) % 2 == 0) ? (B[k][l] ? 1 : 0) : (B[k][l] ? 0 : 1);
				}
			}
			A = min(A, min(C, 64 - C));
		}
	}
	cout << A;
}