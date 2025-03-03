import sys

T = int(sys.stdin.readline().strip())
for c in range(T):
    N, M = map(int, sys.stdin.readline().strip().split(" "))
    visited = list(False for init in range(N+1))
    visitedNum = 1
    visited[1] = True
    edges = []
    result = 0
    for e in range(M):
        edges.append(list(map(int, sys.stdin.readline().strip().split(" "))))
    while visitedNum < N:
        for one, two in edges:
            opposite = 0
            if visited[two]:
                opposite = one
            elif visited[one]:
                opposite = two
            else:
                continue
            if visited[opposite]:
                continue
            visited[opposite] = True
            visitedNum += 1
            result += 1
    print(result)

