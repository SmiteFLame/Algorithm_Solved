#include <iostream>

using namespace std;

int main(void) {
	int x, y, w, h;
	cin >> x >> y >> w >> h;
	int m1 = (x < w - x) ? x : w - x;
	int m2 = (y < h - y) ? y : h - y;
	int m3 = (m1 < m2) ? m1 : m2;
	cout << m3;
}