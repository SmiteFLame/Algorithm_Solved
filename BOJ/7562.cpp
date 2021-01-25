#include <iostream>
#include <cstring>
#include <queue>
#include <vector>
#include <climits>
using namespace std;

#define MAX 300
int NEWS[8][2] = { {2,1},{-2,1} ,{2,-1} ,{-2,-1} ,{1,2},{-1,2},{1,-2},{-1,-2} };


int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int T, N, test_case, x, y, X, Y;
	cin >> T;
	for (test_case = 1; test_case <= T; test_case++) {
		cin >> N;
		int** map = new int* [N];
		for (int i = 0; i < N; i++) {
			map[i] = new int[N];
			memset(map[i], -1, sizeof(int) * N);
		}
		cin >> x >> y >> X >> Y;

		queue<vector<int>> Q;
		map[X][Y] = INT_MAX;
		map[x][y] = 0;
		Q.push({ x,y });
		while (!Q.empty()) {
			vector<int> V = Q.front();
			Q.pop();
			for (int i = 0; i < 8; i++) {
				int nx = V[0] + NEWS[i][0];
				int ny = V[1] + NEWS[i][1];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && (map[nx][ny] == -1 || map[nx][ny] > map[V[0]][V[1]] + 1) && map[V[0]][V[1]] + 1 < map[X][Y]) {
					map[nx][ny] = map[V[0]][V[1]] + 1;
					Q.push({ nx,ny });
				}
			}
		}
		cout << map[X][Y] << "\n";
	}
}