import sys
n = int(sys.stdin.readline())
number = list(map(int, sys.stdin.readline().split()))
sumNum = [0 for c in range(n)]
m = int(sys.stdin.readline())
for check in range(n):
    if check == 0:
        sumNum[check] = number[check]
    else:
        sumNum[check] = sumNum[check-1]+number[check]

for cycle in range(m):
    s, e = map(int, sys.stdin.readline().split())
    if s==0:
        result = sumNum[e]
    else:
        result = sumNum[e] - sumNum[s-1]
    print(result)