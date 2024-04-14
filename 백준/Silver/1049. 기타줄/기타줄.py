import sys
cost = 0
minG6 = 9999999999
minG1 = 9999999999
Cut, N = map(int, sys.stdin.readline().split())
for inputC in range(N):
    g6, g1 = map(int, sys.stdin.readline().split())
    if minG6 > g6:
        minG6 = g6
    if minG1 > g1:
        minG1 = g1
while Cut > 0:
    if Cut >= 6:
        if minG6 <= minG1 * 6:
            cost += minG6
            Cut -= 6
        else:
            cost += minG1 * 6
            Cut -= 6
    else:
        if minG6 <= minG1 * Cut:
            cost += minG6
            Cut = 0
        else:
            cost += minG1 * Cut
            Cut = 0
print(cost)