import sys
N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))

sortedA = sorted(A)
for cycle in range(N):
    ind = sortedA.index(A[cycle])
    print(ind, end=' ')
    sortedA[ind] = 0