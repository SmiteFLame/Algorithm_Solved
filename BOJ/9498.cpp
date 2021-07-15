#include <iostream>

using namespace std;

int main(void) {
    int S;
    cin >> S;
    if (S >= 90) cout << "A";
    else if (S >= 80) cout << "B";
    else if (S >= 70) cout << "C";
    else if (S >= 60) cout << "D";
    else cout << "F";
}