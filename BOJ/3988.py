import sys

L = int(sys.stdin.readline())
cake = [0] * (L + 1)
N = int(sys.stdin.readline())
audience = [0] * (N + 1)
M_idx, M_cnt = 0, 0

for i in range(1, N + 1):
    P, K = map(int, sys.stdin.readline().split())
    if K - P - 1 > M_cnt:
        M_idx = i
        M_cnt = K-P-1
    cnt = 0
    for j in range(P, K + 1):
        if not cake[j]:
            cake[j] = 1
            cnt += 1
    audience[i] = cnt

print(M_idx)
print(audience.index(max(audience)))