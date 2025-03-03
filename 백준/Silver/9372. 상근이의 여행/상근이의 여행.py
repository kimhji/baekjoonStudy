import sys

T = int(sys.stdin.readline().strip())
for c in range(T):
    N, M = map(int, sys.stdin.readline().strip().split(" "))
    for e in range(M):
        sys.stdin.readline().strip()
    print(N-1)