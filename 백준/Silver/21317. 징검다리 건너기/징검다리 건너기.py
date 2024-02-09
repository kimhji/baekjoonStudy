import sys
N = int(sys.stdin.readline())
Jumpvalue = list()

def findMinValue(loc, val, isUsedVLJ):
    global minV
    if loc >= N:
        if minV > val:
            minV = val
        return
    if minV < val:
        return
    findMinValue(loc + 1, val + Jumpvalue[loc - 1][0], isUsedVLJ)
    if loc + 2 <= N:
        findMinValue(loc + 2, val + Jumpvalue[loc - 1][1], isUsedVLJ)
    if not isUsedVLJ and loc + 3 <= N:
        findMinValue(loc + 3, val + Jumpvalue[loc - 1][2], True)

minV = 100001
for Ncycle in range(N-1):
    sj, lj = map(int, sys.stdin.readline().split())
    Jumpvalue.append([sj, lj])
veryLargeJump = int(sys.stdin.readline())
for Ncycle in range(N-1):
    Jumpvalue[Ncycle].append(veryLargeJump)

findMinValue(1, 0, False)
print(minV)