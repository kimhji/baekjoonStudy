import sys

N, M = map(int, sys.stdin.readline().split())
num = list(map(int, sys.stdin.readline().split()))
tmpSum = 0
sumList = list()
for setSum in num:
    sumList.append(tmpSum)
    tmpSum += setSum
sumList.append(tmpSum)

for inputC in range(M):
    start, end = map(int, sys.stdin.readline().split())
    sumR = sumList[end] - sumList[start-1]
    print(sumR)