import sys
N = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split()))
s = 0
m = max(num)
for n in num:
    s += n/m*100
print(float(s)/N)