#include <iostream>
#include <string>
using namespace std;


int main() {
	string* map = new string[5];
	int max = 0;
	for (int i = 0; i < 5; i++) {
		cin >> map[i];
		max = map[i].length() > max ? map[i].length() : max;
	}

	for (int i = 0; i < max; i++) {
		for (int j = 0; j < 5; j++) {
			if (map[j].length() > i) {
				cout << map[j][i];
			}
		}
	}
}