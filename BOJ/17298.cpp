#include <iostream>
#include <cmath>
#include <cstring>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	long long S, E, K, C = 2, A;
	cin >> S >> E;
	A = E - S + 1;
	bool* D = new bool[E - S + 1];
	memset(D, false, sizeof(bool) * (E - S + 1));
	while (C * C <= E) {
		K = S / (C * C);
		if (S % (C * C) != 0) K++;
		while (K * C * C <= E) {
			if (D[K * C * C - S] == false) {
				D[K * C * C - S] = true;
				A--;
			}
			K++;
		}
		C++;
	}
	cout << A;
}