import sys
def checkMinCommon(x1, x2):
    if x2 == 0:
        return x1
    return checkMinCommon(x2, x1 % x2)

N = int(sys.stdin.readline())
Numbers = list(map(int, sys.stdin.readline().split()))
PrimeNumbers = list()
PrimeN = 0
for check in range(N):
    IsPrime = True
    for CheckPrime in range(2, int(Numbers[check]**(1/2))+1):
        if Numbers[check] % CheckPrime == 0:
            IsPrime = False
            break
    if IsPrime:
        PrimeNumbers.append(Numbers[check])
        PrimeN += 1

if PrimeN == 0:
    print(-1)
else:
    first = PrimeNumbers.pop()
    while PrimeNumbers != list():
        second = PrimeNumbers.pop()
        result = checkMinCommon(first, second)
        first = first * second
        first //= result
    print(first)