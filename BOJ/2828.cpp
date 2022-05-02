#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main() {

    int n, m;
    cin >> n >> m;
    int j;
    cin >> j;

    int cnt = 0;

    int bucket[2] = { 1, m };

    for (int i = 0; i < j; i++) {
        int x;
        cin >> x;

        while (x < bucket[0] || x > bucket[1]) {
            if (x > bucket[1]) {
                bucket[0]++;
                bucket[1]++;
                cnt++;
            }
            else if (x < bucket[0]) {
                bucket[0]--;
                bucket[1]--;
                cnt++;
            }
        }
    }

    cout << cnt;
}