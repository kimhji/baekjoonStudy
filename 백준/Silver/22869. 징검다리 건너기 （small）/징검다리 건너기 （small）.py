import sys

Jumpvalue = list()
def findMinValue(loc):
    global K, isReachedEnd, visited
    if isReachedEnd:
        return
    if loc >= N:
        isReachedEnd = True
        return
    for DP in range(N - loc, 0, -1):
        if loc+DP in visited:
            continue
        calculateValue = DP * (1+abs(Jumpvalue[loc+DP-1] - Jumpvalue[loc-1]))
        if calculateValue <= K:
            visited.add(loc + DP)
            findMinValue(loc + DP)
        if isReachedEnd:
            return


N, K = map(int, sys.stdin.readline().split())
isReachedEnd = False
visited = set()
Jumpvalue = list(map(int, sys.stdin.readline().split()))
findMinValue(1)
if isReachedEnd:
    print("YES")
else:
    print("NO")