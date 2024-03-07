import sys
N, M = map(int, sys.stdin.readline().split())
noListen = set()
bothNo = list()
num = 0
for inputC in range(N):
    noListen.add(sys.stdin.readline().rstrip())
for scanC in range(M):
    noSight = sys.stdin.readline().rstrip()
    if noSight in noListen:
        bothNo.append(noSight)
        num += 1
if num > 0:
    bothNo.sort()
print(num)
for printC in bothNo:
    print(printC)