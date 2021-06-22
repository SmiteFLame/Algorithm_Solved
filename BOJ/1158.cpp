#include <iostream>
#include <string>
#include <cstring>

using namespace std;

int main(void) {
    int* D = new int[26];
    memset(D, 0, sizeof(int) * 26);

    string S;
    cin >> S;
    for (auto s : S) (int(s) >= 97) ? (D[int(s) - 97]++) : (D[int(s) - 65]++);

    int M = 0, K;
    bool B = false;

    for (int i = 0; i < 26; i++) {
        if (D[i] > M) {
            M = D[i];
            K = i;
            B = false;
        }
        else if (D[i] == M) B = true;
    }
    if (B) cout << '?';
    else cout << char(K + 65);
}