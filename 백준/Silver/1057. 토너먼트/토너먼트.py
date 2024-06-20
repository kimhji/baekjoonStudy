import sys
N, J, I = map(int, sys.stdin.readline().split())
existUnearned = False
result = -1
tResult = 0
while N > 1:
    existUnearned = False
    tResult += 1
    if abs(J-I) == 1 and J//2 != I//2:
        result = tResult
        break
    if N % 2 == 1:
        existUnearned = True
    if N == J and existUnearned:
        J = N//2 + 1
    else:
        J = (J + 1)//2
    if N == I and existUnearned:
        I = N//2 + 1
    else:
        I = (I + 1)//2
    N //= 2
    if existUnearned:
        N += 1
print(result)