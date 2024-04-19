import sys
N = int(sys.stdin.readline())
numList = set()
for inputC in range(N):
    numList.add(int(sys.stdin.readline()))
minV = -1
for check in numList:
    val = 0
    for check2 in range(1,5):
        if check+check2 not in numList:
            val += 1
    if minV < 0 or val < minV:
        minV = val
print(minV)
