import sys

def findMax(A, B):
    if B == 0:
        return A
    R = A % B
    result = findMax(B, R)
    return result

N = int(sys.stdin.readline())
Num = list(map(int, sys.stdin.readline().split()))

X = int(sys.stdin.readline())
numOfResult = 0
SumOfNumbers = 0
for cy in range(N):
    result = findMax(X, Num[cy])
    if result == 1:
        numOfResult += 1
        SumOfNumbers += Num[cy]
result = SumOfNumbers / numOfResult
print(result)