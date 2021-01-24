#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	string S;
	cin >> S;
	for (auto s : S) {
		if (s >= 'A' && s <= 'Z') {
			cout << s;
		}
	}
}