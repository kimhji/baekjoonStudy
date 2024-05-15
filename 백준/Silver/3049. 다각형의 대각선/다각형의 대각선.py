import sys
N=int(sys.stdin.readline())
result = 0
if N >3:
    result = 1
    for fac in range(4):
        result *= N-fac
    for dup in range(1, 5):
        result //= dup
print(result)