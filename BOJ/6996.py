import sys

read = lambda: sys.stdin.readline().rstrip()

T = int(read())

for _ in range(T):
    A, B = map(str, read().split())

    X = sorted(list(A))
    Y = sorted(list(B))

    if X == Y:
        print('{} & {} are anagrams.'.format(A, B))
    else:
        print('{} & {} are NOT anagrams.'.format(A, B))