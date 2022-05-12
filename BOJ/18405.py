from collections import deque
import sys
input = sys.stdin.readline

N,K = map(int, input().split())
graph = []
data = [] 
for i in range(N):
    graph.append(list(map(int, input().split())))
    for j in range(N):
        if graph[i][j] !=0:
            data.append((graph[i][j],0,i,j))

data.sort()

q = deque(data)

target_s, target_x, target_y = map(int, input().split())

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

while q:
    virus, s, x, y = q.popleft()
    if s == target_s:
        break
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx and nx < N and 0 <=ny  and ny < N:
            if graph[nx][ny] == 0:
                graph[nx][ny] = virus
                q.append((virus, s+1, nx,ny))

print(graph[target_x -1][target_y -1])