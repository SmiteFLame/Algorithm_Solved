#include <iostream>
#include <vector>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	long long N, A;
	vector<int> V0;
	vector<int> V1;
	V0.push_back(1);
	V0.push_back(0);
	V1.push_back(0);
	V1.push_back(1);
	cin >> N;
	for (int t = 0; t < N; t++) {
		cin >> A;
		for (int i = V0.size() - 1; i < A; i++) {
			V0.push_back(V0[V0.size() - 1] + V0[V0.size() - 2]);
			V1.push_back(V1[V1.size() - 1] + V1[V1.size() - 2]);
		}
		cout << V0[A] << " " << V1[A] << endl;
	}
}