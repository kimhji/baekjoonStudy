import sys

def is666in(num):
    inarow = 0
    while num > 0:
        if num % 10 == 6:
            inarow += 1
            if inarow >= 3:
                return True
        else:
            inarow = 0
        num //= 10
    return False

N = int(sys.stdin.readline())
N -= 1
result = 666
while N > 0:
    result += 1
    if is666in(result):
        N -= 1
print(result)
