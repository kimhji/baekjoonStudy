import sys

MinC = 0
n = int(sys.stdin.readline())
listC = [-1]
for inputCycle in range(n):
    listC.append(int(sys.stdin.readline()))
listC.sort()
for check in range(1, n+1):
    if check != listC[check]:
        MinC += abs(listC[check] - check)
print(MinC)