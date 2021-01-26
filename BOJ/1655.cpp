#include <iostream>
#include <queue>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N, T, X, Y;
	cin >> N;
	priority_queue<int, vector<int>, greater<int>> min_Q;
	priority_queue<int, vector<int>, less<int>> max_Q;

	for (int i = 0; i < N; i++) {
		cin >> T;
		if (i % 2 == 0) max_Q.push(T);
		else min_Q.push(T);

		if (!max_Q.empty() && !min_Q.empty() && !(max_Q.top() <= min_Q.top()))
		{
			X = max_Q.top();
			Y = min_Q.top();

			max_Q.pop();
			min_Q.pop();

			max_Q.push(Y);
			min_Q.push(X);
		}
		cout << max_Q.top() << "\n";
	}
}