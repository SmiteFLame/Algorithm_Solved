#include <stdio.h>
#include <stdlib.h>
#include <algorithm>
#include <math.h>
#include <iostream>
#include <queue>
#include <string>

using namespace std;

int N, M;
char arr[11][11];
int NEWS[4][2] = { {-1,0},{0,-1},{1,0},{0,1} };
bool visit[11][11][11][11] = { false };
int red_x, red_y, blue_x, blue_y;

int BFS() {
	queue <pair<pair<int, int>, pair<int, int>>> que;
	que.push(make_pair(make_pair(red_x, red_y), make_pair(blue_x, blue_y)));
	int result = 0;

	while (!que.empty()) {
		int size = que.size();
		while (size--) {
			int nowRX = que.front().first.first;
			int nowRY = que.front().first.second;
			int nowBX = que.front().second.first;
			int nowBY = que.front().second.second;

			que.pop();
			if (arr[nowRX][nowRY] == 'O' && arr[nowRX][nowRY] != arr[nowBX][nowBY]) {
				return result;
			}

			for (int i = 0; i < 4; i++) {
				int red_nx = nowRX, nextRY = nowRY, nextBX = nowBX, nextBY = nowBY;
				while (arr[red_nx + NEWS[i][0]][nextRY + NEWS[i][1]] != '#' && arr[red_nx][nextRY] != 'O') {
					red_nx += NEWS[i][0];
					nextRY += NEWS[i][1];
				}
				while (arr[nextBX + NEWS[i][0]][nextBY + NEWS[i][1]] != '#' && arr[nextBX][nextBY] != 'O') {
					nextBX += NEWS[i][0];
					nextBY += NEWS[i][1];
				}
				if (red_nx == nextBX && nextRY == nextBY) {
					if (arr[red_nx][nextBY] == 'O') continue;
					if (abs(red_nx - nowRX) + abs(nextRY - nowRY) < abs(nextBX - nowBX) + abs(nextBY - nowBY)) {
						nextBX -= NEWS[i][0];
						nextBY -= NEWS[i][1];
					}
					else {
						red_nx -= NEWS[i][0];
						nextRY -= NEWS[i][1];
					}
				}
				if (visit[red_nx][nextRY][nextBX][nextBY]) continue;
				que.push(make_pair(make_pair(red_nx, nextRY), make_pair(nextBX, nextBY)));
				visit[red_nx][nextRY][nextBX][nextBY] = true;
			}
		}
		if (result == 10) return -1;
		result++;
	}
	return -1;
}

void init() {
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];
			if (arr[i][j] == 'R') {
				red_x = i; red_y = j;
			}
			else if (arr[i][j] == 'B') {
				blue_x = i; blue_y = j;
			}
		}
	}
	visit[red_x][red_y][blue_x][blue_y] = true;

	cout << BFS();
	return 0;
}