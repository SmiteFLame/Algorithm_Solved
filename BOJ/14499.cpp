#include <iostream>
#include <cstring>
using namespace std;


// 기존 위치 처럼 1,2,3,4,5,6 으로 가정
// 1이 바닥으로 생각
int D[6] = { 0, 0, 0, 0, 0, 0 };

void move(int R) {
	if (R == 1) {
		int temp = D[0];
		D[0] = D[2];
		D[2] = D[5];
		D[5] = D[3];
		D[3] = temp;
	}
	else if (R == 2) {
		int temp = D[0];
		D[0] = D[3];
		D[3] = D[5];
		D[5] = D[2];
		D[2] = temp;
	}
	else if (R == 3) {
		int temp = D[0];
		D[0] = D[4];
		D[4] = D[5];
		D[5] = D[1];
		D[1] = temp;
	}
	else {
		int temp = D[0];
		D[0] = D[1];
		D[1] = D[5];
		D[5] = D[4];
		D[4] = temp;
	}
}

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int NEWS[4][2] = { {0,1},{0,-1},{-1,0},{1,0} };
	int N, M, X, Y, K, L;
	cin >> N >> M >> X >> Y >> K;
	int** map = new int* [N];
	for (int i = 0; i < N; i++) {
		map[i] = new int[M];
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
		}
	}
	for (int i = 0; i < K; i++) {
		cin >> L;
		if (X + NEWS[L - 1][0] >= 0 && X + NEWS[L - 1][0] < N && Y + NEWS[L - 1][1] >= 0 && Y + NEWS[L - 1][1] < M) {

			X += NEWS[L - 1][0];
			Y += NEWS[L - 1][1];
			move(L);
			if (map[X][Y] == 0) map[X][Y] = D[0];
			else {
				D[0] = map[X][Y];
				map[X][Y] = 0;
			}
			cout << D[5] << "\n";
		}
	}
}