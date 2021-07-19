#include <iostream>
using namespace std;

int main(void) {
	int N;
	cin >> N;
	for (int i = 0; i < N; i++) {
		int C = 0;
		bool B = false;
		string S;
		cin >> S;
		for (auto s : S) {
			if (s == '(') C++;
			else C--;
			if (C < 0) {
				B = true;
				break;
			}
		}
		if (B || C > 0) cout << "NO" << endl;
		else cout << "YES" << endl;
	}
}