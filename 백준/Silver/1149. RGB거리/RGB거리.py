import sys

N = int(sys.stdin.readline())
resultList = [[0, 0, 0] for init in range(N)]
costList = list()
for inputC in range(N):
    costList.append(list(map(int, sys.stdin.readline().split())))

for cycle in range(N):
    r=0
    g=0
    b=0
    if cycle != 0:
        r = min(resultList[cycle-1][1], resultList[cycle-1][2])
        g = min(resultList[cycle - 1][0], resultList[cycle - 1][2])
        b = min(resultList[cycle - 1][0], resultList[cycle - 1][1])
    r += costList[cycle][0]
    g += costList[cycle][1]
    b += costList[cycle][2]
    resultList[cycle] = [r,g,b]
print(min(resultList[-1]))