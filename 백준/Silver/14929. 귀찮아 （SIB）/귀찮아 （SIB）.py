import sys, collections
N = int(sys.stdin.readline())

inputX = collections.deque(map(int, sys.stdin.readline().split()))
Sum = 0
theOthers = sum(inputX)
for xaI in range(N-1):
    xa = inputX.popleft()
    theOthers = theOthers - xa
    Sum += xa * theOthers
print(Sum)