#include <iostream>
#include <algorithm>
using namespace std;


int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int N;
	cin >> N;
	int* D = new int[N];
	int* M = new int[N];
	for (int i = 0; i < N; i++) cin >> D[i];
	M[0] = D[0];
	M[1] = max(D[0] + D[1], D[1]);
	M[2] = max(D[0] + D[2], D[1] + D[2]);
	for (int i = 3; i < N; i++) M[i] = max(M[i - 2] + D[i], M[i - 3] + D[i - 1] + D[i]);
	cout << M[N - 1];
}