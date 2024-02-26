import heapq
import sys
N = int(sys.stdin.readline())
Q = []
for NInput in map(int, sys.stdin.readline().split()):
    heapq.heappush(Q, NInput)

for inputCycle in range(N-1):
    for NInput in map(int, sys.stdin.readline().split()):
        heapq.heappush(Q, NInput)
        heapq.heappop(Q)
print(heapq.heappop(Q))