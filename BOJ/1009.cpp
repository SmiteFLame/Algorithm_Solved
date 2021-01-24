#include <iostream>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int T, test_case;
	long a, b;
	cin >> T;
	for (test_case = 0; test_case < T; test_case++) {
		cin >> a >> b;
		long X = 1;
		for (int i = 0; i < b; i++) {
			X = (X * a) % 10;
		}
		if (X == 0) X += 10;
		cout << X << "\n";
	}
}