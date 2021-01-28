#include <iostream>
#include <string>
#include <list>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cout.tie(0);
    cin.tie(0);

    int N;
    string S;
    cin >> S;
    cin >> N;
    list<char> C(S.begin(), S.end());
    auto now = C.end();

    while (N--) {
        char tmp;
        cin >> tmp;

        if (tmp == 'L') {
            if (now != C.begin()) {
                now--;
            }
        }
        else if (tmp == 'D') {
            if (now != C.end()) {
                now++;
            }
        }
        else if (tmp == 'B') {
            if (now != C.begin()) {
                now = C.erase(--now);
            }
        }
        else if (tmp == 'P') {
            char c;
            cin >> c;
            C.insert(now, c);
        }
    }
    for (auto i : C) {
        cout << i;
    }
    return 0;
}