import sys
T = int(sys.stdin.readline())
for testCase in range(T):
    west, east = map(int, sys.stdin.readline().split())
    numOfCase = 1
    firstX = east
    for x in range(west):
        numOfCase *= firstX
        firstX -= 1
    firstX = 1
    for x in range(west):
        numOfCase //= firstX
        firstX += 1
    print(numOfCase)