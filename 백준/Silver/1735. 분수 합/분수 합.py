import sys
def gcd(x, y):
    if y == 0:
        return x
    return gcd(y, x % y)

c1, p1 = map(int, sys.stdin.readline().split())
c2, p2 = map(int, sys.stdin.readline().split())

c = c1*p2 + c2*p1
p = p1*p2
x = gcd(c, p)
c //= x
p //= x

print(c, p)