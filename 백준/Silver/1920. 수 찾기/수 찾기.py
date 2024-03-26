import sys
N = int(sys.stdin.readline())
num = set(list(map(int, sys.stdin.readline().split())))
M = int(sys.stdin.readline())
num2 = list(map(int, sys.stdin.readline().split()))
for inp in num2:
    if inp in num:
        print(1)
    else:
        print(0)