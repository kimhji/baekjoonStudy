import sys
def maxCommonDivisor(N1, N2):
    if N2 == 0:
        return N1
    N3 = N1 % N2
    return maxCommonDivisor(N2, N3)

T = int(sys.stdin.readline())

for inputCycle in range(T):
    N1, N2 = map(int, sys.stdin.readline().split())
    commonDivisor = maxCommonDivisor(N1, N2)
    result = N1 * N2
    result //= commonDivisor
    print(result)