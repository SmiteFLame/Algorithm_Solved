#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;


int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int N, A, B, M, X, Y, answer = 0;
	cin >> N >> A >> B >> M;
	int* parent = new int[N + 1];
	memset(parent, 0, sizeof(int) * (N + 1));
	for (int i = 0; i < M; i++) {
		cin >> X >> Y;
		parent[Y] = X;
	}

	// �ڽ� ���� ���ϱ�
	int levelA = 0, levelB = 0;
	X = A, Y = B;
	while (X != 0) {
		levelA++;
		X = parent[X];
	}
	while (Y != 0) {
		levelB++;
		Y = parent[Y];
	}

	// ������ ū ���� A�� ������ ����
	if (levelB > levelA) {
		swap(A, B);
		swap(levelA, levelB);
	}

	// A�� B ���� ���� �������� ����
	for (int i = levelB; i < levelA; i++) {
		A = parent[A];
		answer++;
	}

	while (A != B) {
		A = parent[A];
		B = parent[B];
		answer += 2;
	}

	if (answer == 0 || A == 0) cout << -1;
	else cout << answer;
}