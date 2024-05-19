import sys
n, p = map(int, sys.stdin.readline().split())
while n != 0 or p != 0:
    candidates = [0 for c in range(n)]
    plate = p
    ind = 0
    while True:
        if plate != 0:
            candidates[ind] += 1
            plate -= 1
            if candidates[ind] == p:
                break
        else:
            plate = candidates[ind]
            candidates[ind] = 0
        ind += 1
        ind %= n
    print(ind)
    n, p = map(int, sys.stdin.readline().split())