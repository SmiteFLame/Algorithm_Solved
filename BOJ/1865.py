import sys
T = int(sys.stdin.readline())
def solve_bf(bf, graph, N, M):
    bf[1] = 0
    for it in range(N):
        for v in range(1, N+1):
            for nv, nw in graph[v]:
                if bf[nv] > bf[v] + nw:
                    bf[nv] = bf[v] + nw
                    if it == N-1:
                        print("YES")
                        return
    print("NO")
    return

for _ in range(T):
    N, M, W = map(int, sys.stdin.readline().split())
    graph = [[] for _ in range(N+1)]
    bf = [1e9] * (N+1)
    for _ in range(M):
        s, e, t = map(int, sys.stdin.readline().split())
        graph[s].append([e, t])
        graph[e].append([s, t])
    for _ in range(W):
        s, e, t = map(int, sys.stdin.readline().split())
        graph[s].append([e, -t])
    solve_bf(bf, graph, N, M)