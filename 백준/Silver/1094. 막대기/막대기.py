import sys
n=int(sys.stdin.readline())
m=64
result = 0
while m >= 1:
    if n >= m:
        n -= m
        result += 1
    m //= 2
print(result)