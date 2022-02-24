from sys import stdin

def permu(idx,ans,position):
    global cnt,check

    if ans.count('Y') > 3:
        return
    if idx == 7:
        if ans.count('S') >= 4:
            position_check(position[0],position)
            if sum(sum(check,[])) == 7:
                cnt += 1
            check = [[0] * 5 for _ in range(5)]
        return
    for i in range(25):
        if visit[i] == 0:
            visit[i] = 1
            permu(idx+1,ans+arr[i],position +[i])
            for j in range(i+1,25):
                visit[j] = 0

def position_check(s,position):
    r = s // 5
    c = s % 5
    check[r][c] = 1
    for j in range(4):
        nr = r + dr[j]
        nc = c + dc[j]
        if 0<=nr<5 and 0<=nc<5:
            next = nr*5 + nc
            if check[nr][nc] == 0 and next in position:
                check[nr][nc] = 1
                position_check(next,position)


arr = []
cnt = 0
for _ in range(5):
    arr += list(map(str,stdin.readline().strip()))
visit = [0 for _ in range(25)]
check=[[0]*5 for _ in range(5)]
dr =[-1,1,0,0]
dc = [0,0,-1,1]
permu(0,'',[])
print(cnt)