import sys
N = int(sys.stdin.readline())
total = 1
for x in range(1, N+1):
    total *= x

num = 0
while total != 0:
    s = total % 10
    total //= 10
    if s == 0:
        num += 1
    else:
        break
print(num)