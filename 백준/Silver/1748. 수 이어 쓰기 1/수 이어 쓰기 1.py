import sys
N = int(sys.stdin.readline())
check = 9
ind = 1
res = 0
while N >= check:
    res += check * ind
    ind += 1
    N -= check
    check *= 10
res += ind * N
print(res)