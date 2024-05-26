import sys
N = int(sys.stdin.readline())
A = list(map(int,sys.stdin.readline().split()))
B = list(map(int,sys.stdin.readline().split()))

A.sort(key=lambda x: x*(-1))
B.sort()
s = 0
for cycle in range(N):
    s += A[cycle] * B[cycle]
print(s)
