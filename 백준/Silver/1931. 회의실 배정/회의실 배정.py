import sys

N = int(sys.stdin.readline())
office = [[0, 0] for _ in range(N)]
inputOffice = [(0, 0) for _ in range(N)]
maxSum = 0
for cycle in range(N):
    a, b = map(int, sys.stdin.readline().split())
    inputOffice[cycle] = (a, b)
inputOffice.sort(key=lambda x : (x[1], x[0]))

checkOffi = [inputOffice[0][1], 1]
for c_offi in range(1, N):
    checkTimeS = inputOffice[c_offi][0]
    checkTimeT = inputOffice[c_offi][1]
    if checkOffi[0] <= checkTimeS:
        checkOffi[0] = checkTimeT
        checkOffi[1] += 1

print(checkOffi[1])

