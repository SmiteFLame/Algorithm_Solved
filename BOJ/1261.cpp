#include <iostream>
#include <cstring>
#include <climits>
#include <queue>
using namespace std;

int NEWS[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };

int main() {
    ios::sync_with_stdio(false);
    cout.tie(0);
    cin.tie(0);
    int N, M, X, Y;
    string S;

    cin >> M >> N;

    int** map = new int* [N];
    int** des = new int* [N];

    for (int i = 0; i < N; i++) {
        map[i] = new int[M];
        des[i] = new int[M];
        cin >> S;
        for (int j = 0; j < M; j++) {
            map[i][j] = S[j] - '0';
            des[i][j] = INT_MAX;
        }
    }

    des[0][0] = 0;

    queue<pair<int, int>> Q;

    Q.push({ 0,0 });
    while (!Q.empty()) {
        pair<int, int> P = Q.front();
        Q.pop();
        for (int i = 0; i < 4; i++) {
            X = P.first + NEWS[i][0];
            Y = P.second + NEWS[i][1];
            if (X >= 0 && X < N && Y >= 0 && Y < M) {
                if (map[X][Y] == 1 && des[X][Y] > des[P.first][P.second] + 1) {
                    des[X][Y] = des[P.first][P.second] + 1;
                    Q.push({ X,Y });
                }
                else if (map[X][Y] == 0 && des[X][Y] > des[P.first][P.second]) {
                    des[X][Y] = des[P.first][P.second];
                    Q.push({ X,Y });
                }
            }
        }
    }
    cout << des[N - 1][M - 1];
}