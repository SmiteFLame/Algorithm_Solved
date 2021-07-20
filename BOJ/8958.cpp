#include <iostream>
#include <string>
using namespace std;

int main(void) {
    int T;
    string L;
    cin >> T;
    for (int i = 1; i <= T; i++) {
        cin >> L;
        int X = 0, S = 0;
        for (int j = 0; j < L.length(); j++) {
            if (L[j] == 'O') {
                X += 1;
                S += X;
            }
            else {
                X = 0;
            }
        }
        cout << S << endl;
    }
}