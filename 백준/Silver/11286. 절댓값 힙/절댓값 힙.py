import sys, heapq
N = int(sys.stdin.readline())
Number = list()
num = 0

for inputC in range(N):
    inp = int(sys.stdin.readline())
    if inp != 0:
        heapq.heappush(Number, (abs(inp), inp))
        num+=1
    elif num == 0:
        print(0)
    else:
        x = heapq.heappop(Number)
        num -= 1
        print(x[1])