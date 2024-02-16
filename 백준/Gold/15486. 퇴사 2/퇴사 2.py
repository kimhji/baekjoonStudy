import sys
N = int(sys.stdin.readline())
consulting = list()
findValue = [0 for value in range(N)]
def findMaxMoney():
    for check in range(N-1, -1, -1):
        if check == N-1:
            if consulting[check][0] < 2:
                findValue[check] = consulting[check][1]
        elif check + consulting[check][0] < N:
            if consulting[check][1]+findValue[check+consulting[check][0]] > findValue[check+1]:
                findValue[check] = consulting[check][1]+findValue[check+consulting[check][0]]
            else:
                findValue[check] = findValue[check+1]
        elif check + consulting[check][0] == N:
            if consulting[check][1] > findValue[check + 1]:
                findValue[check] = consulting[check][1]
            else:
                findValue[check] = findValue[check + 1]
        else:
            findValue[check] = findValue[check + 1]


num = 0
for inputCycle in range(N):
    t, p = map(int, sys.stdin.readline().split())
    consulting.append((t, p))
findMaxMoney()
print(findValue[0])