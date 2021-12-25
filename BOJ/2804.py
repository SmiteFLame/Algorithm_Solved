s1, s2 = map(str, input().split())

for i in range(len(s1)):
    if s1[i] in s2:
        col = i
        row = s2.index(s1[i])
        break
    
for i in range(len(s2)):
    if i == row:
        print(s1)
    else:
        print('.'*col + s2[i] + '.'*(len(s1)-col-1))