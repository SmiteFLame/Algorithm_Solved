import math
import sys
import heapq

def PrintResult(res):
    print(distance[end])
    print(len(res))
    print(*res)

def trace(start, end):
    res = [end]
    lastTrace[start] = 0
    while lastTrace[end]:
        res.append(lastTrace[end])
        end = lastTrace[end]
    return PrintResult(res[::-1])

def dijkstra(start):
    distance[start] = 0
    q = []
    heapq.heappush(q, (0, start))
    while q:
        dist, now = heapq.heappop(q) 
        if distance[now] < dist:
            continue
        for nextCity, nextDist in graph[now]:
            cost = dist + nextDist
            if cost < distance[nextCity]:
                distance[nextCity] = cost
                lastTrace[nextCity] = now
                heapq.heappush(q, (cost, nextCity))
    return trace(start, end)

if __name__ == "__main__":
    I = sys.stdin.readline
    n, m = int(I()), int(I())
    graph = [[] for _ in range(n + 1)]
    for _ in range(m):
        a, b, c = map(int, I().split())
        graph[a].append((b, c))
    start, end = map(int, I().split())
    INF = math.inf
    distance = [INF] * (n + 1)
    lastTrace = [None] * (n + 1)
    dijkstra(start)