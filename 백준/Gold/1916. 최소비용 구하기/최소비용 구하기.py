import sys
N = int(sys.stdin.readline().strip())
M = int(sys.stdin.readline().strip())
edges = dict()
for init in range(M):
    start, end, cost = map(int, sys.stdin.readline().strip().split(" "))
    edges[start] = edges.get(start, [])
    edges[start].append([end, cost])
minV = list(-1 for init in range(N+1))

start, dest = map(int, sys.stdin.readline().strip().split(" "))
bag = set()
minV[start] = 0
bag.add(start)
isExist = True

while isExist:
    isExist = False
    tnsBag = set()
    for city in bag:
        for end, cost in edges.get(city, []):
            if minV[end] < 0 or minV[end] > minV[city]+cost:
                minV[end] = minV[city]+cost
                isExist = True
                tnsBag.add(end)
    bag = tnsBag

print(minV[dest])
