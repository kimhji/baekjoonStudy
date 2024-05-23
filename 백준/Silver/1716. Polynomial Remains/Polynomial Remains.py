import sys

n, k = map(int, sys.stdin.readline().split())
while (n != -1 or k != -1):
    inp = list(map(int, sys.stdin.readline().split()))
    a = inp[::-1]
    length = n+1
    for check in range(length-k):
        a[check+k] -= a[check]
    isprinted = False
    for check in range(length-1, length-k-1, -1):
        if a[check] == 0 and not isprinted:
            continue
        isprinted = True
        print(a[check], end=' ')
        if check <= 0:
            break
    if not isprinted:
        print(0)
    else:
        print()
    n, k = map(int, sys.stdin.readline().split())