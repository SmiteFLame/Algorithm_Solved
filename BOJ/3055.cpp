#include <iostream>
#include <climits>
#include <queue>
#include <tuple>

using namespace std;

int NEWS[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };

int main() {
    ios::sync_with_stdio(false);
    cout.tie(0);
    cin.tie(0);

    int N, M, minute = -1, X, Y;
    cin >> N >> M;
    string S;

    int** map = new int* [N];

    queue< pair<int, int>> water;
    queue <tuple<int, int, int>> Q;
    pair<int, int> A;

    // 물 -1, 돌 -2, 지나온 칸 값들, .

    for (int i = 0; i < N; i++) {
        map[i] = new int[M];
        cin >> S;
        for (int j = 0; j < M; j++) {
            map[i][j] = INT_MAX;

            if (S[j] == 'X') map[i][j] = -2;
            else if (S[j] == 'S') {
                Q.push({ i, j, 0 });
                map[i][j] = 0;
            }
            else if (S[j] == 'D') A = { i, j };
            else if (S[j] == '*') {
                map[i][j] = -1;
                water.push({ i,j });
            }
        }
    }
    while (!Q.empty()) {
        tuple<int, int, int> T = Q.front();
        Q.pop();

        if (get<2>(T) != minute) {
            minute = get<2>(T);
            queue<pair<int, int>> newWater;
            while (!water.empty()) {
                pair<int, int> P = water.front();
                water.pop();
                for (int i = 0; i < 4; i++) {
                    X = P.first + NEWS[i][0];
                    Y = P.second + NEWS[i][1];
                    if (X >= 0 && X < N && Y >= 0 && Y < M && map[X][Y] >= 0 && !(A.first == X && A.second == Y)) {
                        map[X][Y] = -1;
                        newWater.push({ X,Y });
                    }
                }

            }
            water = newWater;
        }


        for (int i = 0; i < 4; i++) {
            X = get<0>(T) + NEWS[i][0];
            Y = get<1>(T) + NEWS[i][1];
            if (X >= 0 && X < N && Y >= 0 && Y < M && map[X][Y] > get<2>(T) + 1) {
                map[X][Y] = get<2>(T) + 1;
                Q.push({ X,Y, get<2>(T) + 1 });
            }
        }
    }
    if (map[A.first][A.second] != INT_MAX) cout << map[A.first][A.second];
    else cout << "KAKTUS";
}