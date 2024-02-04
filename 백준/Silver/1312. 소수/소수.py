import sys
A, B, N = map(int, sys.stdin.readline().split())
result = A % B
for x10 in range(N-1):
    result *= 10
    result %= B
result *= 10
printR = result // B
print(printR)
