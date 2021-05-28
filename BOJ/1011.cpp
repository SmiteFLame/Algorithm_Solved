#include <iostream>
#include <cstring>
using namespace std;

int main(void) {
	int A, B, T;
	cin >> T;
	for (int i = 1; i <= T; i++) {
		cin >> A >> B;
		B -= A;
		int N = 1;
		while (B > N) B -= (N++ * 2);
		N--;
		if (B <= 0) cout << N * 2 << endl;
		else cout << N * 2 + 1 << endl;
	}
}