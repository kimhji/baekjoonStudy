import sys, heapq
N = int(sys.stdin.readline())
NumHeap = 0
Heap = list()
for orderC in range(N):
    order = int(sys.stdin.readline())
    if order == 0:
        if NumHeap == 0:
            print(0)
        else:
            NumHeap -= 1
            print((heapq.heappop(Heap)) * (-1))
    else:
        heapq.heappush(Heap, (-1) * order)
        NumHeap += 1
