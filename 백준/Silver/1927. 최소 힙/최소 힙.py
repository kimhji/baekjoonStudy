import sys, heapq
n = int(sys.stdin.readline())
heapList = list()
num = 0
for inputC in range(n):
    order = int(sys.stdin.readline())
    if order == 0:
        if num == 0:
            print(0)
        else:
            print(heapq.heappop(heapList))
            num -= 1
    else:
        heapq.heappush(heapList, order)
        num += 1