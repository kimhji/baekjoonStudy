import sys
N = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split()))

def sumFunc(index):
    global maxValue, checkIndex
    val = num[index]
    if maxValue < val:
        maxValue = val
    if val < 0 or checkIndex >= index:
        return
    for _ in range(index+1, N):
        val += num[_]
        if val < 0:
            return
        if maxValue < val:
            maxValue = val
        checkIndex = _

maxValue = -1001
checkIndex = -1
for cycle in range(N):
    sumFunc(cycle)
print(maxValue)