import sys
N, M = map(int, sys.stdin.readline().split())
A = list()
for cA in range(N):
    A.append(list(map(int, sys.stdin.readline().split())))

J, K = map(int, sys.stdin.readline().split())
B = list()
for cB in range(J):
    B.append(list(map(int, sys.stdin.readline().split())))

result = [[0 for x in range(K)] for y in range(N)]

for c1 in range(N):
    for c2 in range(K):
        for c3 in range(M):
            result[c1][c2] += A[c1][c3] * B[c3][c2]
        print(result[c1][c2], end=' ')
    print()