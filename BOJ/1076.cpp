#include <iostream>
#include <string>
using namespace std;

string color[10] = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white" };

int getV(string X) {
	for (int i = 0; i < 10; i++) {
		if (X == color[i]) {
			return i;
		}
	}
	return -1;
}

long long getP(string X) {
	long long t = 1;
	for (int i = 0; i < 10; i++, t *= 10) {
		if (X == color[i]) {
			return t;
		}
	}
	return -1;
}


int main() {
	string A, B, C;
	cin >> A >> B >> C;
	cout << (getV(A) * 10 + getV(B)) * getP(C);
}