import sys
N = int(sys.stdin.readline())
sizeList = list()
for inputC in range(N):
    tall, weight = map(int, sys.stdin.readline().split())
    sizeList.append((tall, weight))

for check1 in range(N):
    rank = 1
    for check2 in range(N):
        if check2 == check1:
            continue
        if sizeList[check1][0] < sizeList[check2][0] and sizeList[check1][1] < sizeList[check2][1]:
            rank += 1
    print(rank, end=' ')

