import sys

N, M, R = map(int, sys.stdin.readline().strip().split(" "))
visitArr = [0 for init1 in range(N+1)]
edgeDict = [[] for init2 in range(N+1)]

for initEdge in range(M):
    edge = list(map(int, sys.stdin.readline().strip().split(" ")))
    edgeDict[edge[0]].append(edge[1])
    edgeDict[edge[1]].append(edge[0])

for initEdge in range(1, N+1):
    edgeDict[initEdge].sort(reverse=True)
bagNode = [R]
curV = 1
visitArr[R] = curV
isExistInBag = True
while isExistInBag:
    isExistInBag = False
    nextBagNode = []
    for node in bagNode:
        opposites = edgeDict[node]
        for opposite in opposites:
            if visitArr[opposite] == 0:
                curV += 1
                visitArr[opposite] = curV
                nextBagNode.append(opposite)
                isExistInBag = True
    bagNode = nextBagNode
for p in range(1, N+1):
    print(visitArr[p])