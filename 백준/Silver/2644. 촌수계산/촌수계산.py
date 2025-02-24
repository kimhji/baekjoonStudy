import sys

N = int(sys.stdin.readline().strip())
a, b = map(int, sys.stdin.readline().strip().split())
M = int(sys.stdin.readline().strip())
children = list([] for initChild in range(N+1))
parent = dict()
visited = list(False for initV in range(N+1))

for cycle in range(M):
    x, y = map(int, sys.stdin.readline().strip().split())
    children[x].append(y)
    parent[y] = x

bag = [a]
num = 1
result = 0
end = False
while num > 0:
    result += 1
    nextBag = []
    nextNum = 0
    for node in bag:
        for child in children[node]:
            if visited[child]:
                continue
            if child == b:
                end = True
                break
            nextBag.append(child)
            visited[child] = True
            nextNum += 1
        p = parent.get(node, None)
        if p is not None and not visited[p]:
            if p == b:
                end = True
                break
            nextBag.append(p)
            visited[p] = True
            nextNum += 1
        if end:
            break

    if end:
        break
    bag = nextBag
    num = nextNum
if not end:
    result = -1
print(result)