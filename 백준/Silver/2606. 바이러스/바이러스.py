import sys
N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
computer = [[i, False] for i in range(N+1)]
computer[1][1] = True
edges = list()
for inputEdge in range(M):
    start, end = map(int, sys.stdin.readline().split())
    edges.append([start, end])
edges.sort(key=lambda x: (x[0], x[1]))
infection = set()
infection.add(1)
num = 0
beforeNum = -1
while num != beforeNum:
    beforeNum = num
    for searchEdge in edges:
        if searchEdge[0] in infection and computer[searchEdge[1]][1] == False:
            num += 1
            infection.add(searchEdge[1])
            computer[searchEdge[1]][1] = True
        elif searchEdge[1] in infection and computer[searchEdge[0]][1] == False:
            num += 1
            infection.add(searchEdge[0])
            computer[searchEdge[0]][1] = True
print(num)