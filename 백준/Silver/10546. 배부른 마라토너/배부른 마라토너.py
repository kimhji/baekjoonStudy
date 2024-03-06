import sys
N = int(sys.stdin.readline())
partici = list()
goalIn = list()
for inputC in range(N):
    partici.append(sys.stdin.readline())
for inputC in range(N-1):
    goalIn.append(sys.stdin.readline())
check = 0
partici.sort()
goalIn.sort()
while check < N-1:
    if partici[check] != goalIn[check]:
        break
    check += 1
print(partici[check])