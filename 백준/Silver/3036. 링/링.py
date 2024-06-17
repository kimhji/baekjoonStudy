import sys

def gcp(x, y):
    if y == 0:
        return x
    return gcp(y, x%y)

N = int(sys.stdin.readline())
ring = list(map(int, sys.stdin.readline().split()))
for check in range(1, N):
    s = gcp(ring[0], ring[check])
    print(f"{ring[0]//s}/{ring[check]//s}")