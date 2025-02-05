import sys

N, K = list(map(int, sys.stdin.readline().strip().split(" ")))
edges = {}
nodes = {}
for i in range(0, N-1):
    edge = list(map(int, sys.stdin.readline().strip().split(" ")))
    if edges.get(edge[0]):
        edges[edge[0]].append(edge[1])
    else:
        edges[edge[0]] = [edge[1]]

nodeName = list(map(int, sys.stdin.readline().strip().split(" ")))
for name in nodeName:
    nodes[name] = -1
bag = [0]
nodes[nodeName[0]] = 0
sizeBag = 1
curV = 0
while sizeBag > 0:
    nextBag = []
    sizeBag = 0
    curV += 1
    for node in bag:
        if not edges.get(node):
            continue
        for opposite in edges[node]:
            if nodes[nodeName[opposite]] < 0:
                nodes[nodeName[opposite]] = curV
                nextBag.append(opposite)
                sizeBag += 1
    bag = nextBag

print(nodes[K])