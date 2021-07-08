#include <iostream>
#include <string>
using namespace std;


int main() {
	string S;
	cin >> S;
	for (int i = 0, end = S.length(); i < end / 2; i++) {
		if (S[i] == S[end - i - 1]) continue;
		cout << 0;
		return 0;
	}
	cout << 1;
	return 0;
}