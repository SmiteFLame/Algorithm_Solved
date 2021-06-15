#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

int main(void) {
	int N, i, j, A, B;
	vector<pair<int, int>> V;
	cin >> N;
	int* D = new int[N];
	memset(D, 0, sizeof(int) * N);
	for (i = 0; i < N; i++) {
		cin >> A >> B;
		V.push_back(make_pair(A, B));
	}
	for (i = 0; i < N; i++) {
		for (j = 0; j < N; j++) {
			if (V[i].first < V[j].first && V[i].second < V[j].second) {
				D[i]++;
			}
		}
	}
	for (i = 0; i < N; i++) cout << D[i] + 1 << " ";

}