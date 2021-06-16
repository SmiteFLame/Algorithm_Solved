#include <iostream>
#include <cmath>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	int N, X, Y, A, S = 0;
	cin >> N >> Y >> X;

	A = pow(2, N - 1);

	while (A > 0) {
		if (X >= A && Y >= A) {
			S += (A * A) * 3;
			X -= A;
			Y -= A;
		}
		else if (Y >= A) {
			S += (A * A) * 2;
			Y -= A;
		}
		else if (X >= A) {
			S += (A * A);
			X -= A;
		}
		A /= 2;
	}
	cout << S;
}