#include <iostream>

using namespace std;

int main(void) {
    int X;
    cin >> X;
    if (X < 100) cout << X;
    else {
        int S = 99;
        for (int i = 100; i <= X; i++) {
            if ((i / 10) % 10 - i % 10 == i / 100 - (i / 10) % 10) {
                S++;
            }
        }
        cout << S;
    }
}