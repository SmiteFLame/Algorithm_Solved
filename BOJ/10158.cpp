#include <iostream>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	int N, M, X, Y, K;
	cin >> N >> M >> X >> Y >> K;

	X += K;
	Y += K;

	X %= (2 * N);
	Y %= (2 * M);

	if (X > N)
		X = 2 * N - X;
	if (Y > M)
		Y = 2 * M - Y;
	cout << X << " " << Y;
}