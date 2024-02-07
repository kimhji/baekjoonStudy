import sys
N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
Room = [[i, i] for i in range(N+1)]

for cycle in range(M):
    x, y = map(int, sys.stdin.readline().split())
    case = Room[x][1]
    casecheck = set()
    for breakRoom in range(x, y+1):
        casecheck.add(Room[breakRoom][1])
        Room[breakRoom][1] = case

    for cycle in range(1, N + 1):
        if Room[cycle][1] in casecheck:
            Room[cycle][1] = case
check = set()
num = 0
for cycle in range(1, N+1):
    if Room[cycle][1] not in check:
        check.add(Room[cycle][1])
        num+=1
print(num)