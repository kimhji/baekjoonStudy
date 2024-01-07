import sys

a, b = map(int, sys.stdin.readline().split())
num = 0
while a != b:
    if b % 2 == 0 and b != 0:
        b //= 2
        num += 1
    elif b % 10 == 1:
        b //= 10
        num += 1
    else:
        break
if a == b:
    print(num+1)
else:
    print(-1)