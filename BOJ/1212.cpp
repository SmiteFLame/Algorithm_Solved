#include <iostream>
#include <string>
using namespace std;

int main() {
	string S;
	string answer;
	cin >> S;
	for (int i = 0, end = S.length(); i < end; i++) {
		switch (S[i])
		{
		case '0':
			answer += "000";
			break;
		case '1':
			answer += "001";
			break;
		case '2':
			answer += "010";
			break;
		case '3':
			answer += "011";
			break;
		case '4':
			answer += "100";
			break;
		case '5':
			answer += "101";
			break;
		case '6':
			answer += "110";
			break;
		case '7':
			answer += "111";
			break;
		default:
			break;
		}
	}
	while (answer[0] == '0') {
		answer.erase(0, 1);
	}
	if (answer == "") {
		answer = "0";
	}
	cout << answer;
}