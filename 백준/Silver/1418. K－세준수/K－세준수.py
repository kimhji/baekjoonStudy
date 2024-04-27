import sys
N = int(sys.stdin.readline())
K = int(sys.stdin.readline())
num = 0
for cycle in range(1, N+1):
    M = 1
    if cycle <= K:
        num += 1
        continue
    tnsCycle = cycle
    noMore = False
    while not noMore:
        noMore = True
        for check in range(K, 1, -1):
            if tnsCycle % check == 0:
                M = check
                noMore = False
                tnsCycle //= check
        if tnsCycle == 1:
            break
    if tnsCycle == 1:
        num += 1
print(num)
