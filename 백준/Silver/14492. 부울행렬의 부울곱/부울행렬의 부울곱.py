import sys
N = int(sys.stdin.readline())
A = []
B = []
C = [[0 for c1 in range(N)] for c2 in range(N)]

for check in range(N):
    line = list(map(int, sys.stdin.readline().split()))
    A.append(line)
for check in range(N):
    line = list(map(int, sys.stdin.readline().split()))
    B.append(line)
num = 0
for cycle1 in range(N):
    for cycle2 in range(N):
        result = 0
        for check in range(N):
             result += A[cycle1][check] * B[check][cycle2]
        C[cycle1][cycle2] = result
        if result >0:
            num += 1
print(num)