#include <iostream>
#include <algorithm>
#include <climits>
#include <cmath>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int N = 0;
	cin >> N;
	long long* data = new long long[N];
	for (int i = 0; i < N; i++) cin >> data[i];

	sort(data, data + N);

	long long left = 0, right = N - 1, max = LLONG_MAX;
	long long a1, a2;
	while (left < right) {
		long long sum = data[left] + data[right];
		if (abs(sum) < abs(max)) {
			a1 = left;
			a2 = right;
			max = sum;
		}
		if (sum > 0) right--;
		else left++;
	}
	cout << data[a1] << " " << data[a2];
}