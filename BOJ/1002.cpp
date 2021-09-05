#include <iostream>
#include <cmath>
using namespace std;

int main(void) {
	int T, x1, y1, r1, x2, y2, r2, i;
	double D;
	cin >> T;
	for (i = 1; i <= T; i++) {
		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
		D = sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

		if (x1 == x2 && y1 == y2) {
			if (r1 == r2) cout << -1 << endl;
			else cout << 0 << endl;
		}
		else if (D + r2 < r1 || D + r1 < r2) cout << 0 << endl;
		else if (D + r2 == r1 || D + r1 == r2) cout << 1 << endl;
		else if (D == r1 + r2) cout << 1 << endl;
		else if (D < r1 + r2) cout << 2 << endl;
		else cout << 0 << endl;
	}
}