import sys
N, totalCost = map(int, sys.stdin.readline().split())
cost = list()
for inputC in range(N):
    cost.append(int(sys.stdin.readline()))

num = 0

for scanR in range(N):
    indexC = N-scanR-1
    if totalCost >= cost[indexC]:
        num += totalCost // cost[indexC]
        totalCost %= cost[indexC]
print(num)