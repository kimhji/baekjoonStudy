import sys
def isPrime(number):
    if number < 2:
        return False
    end = number**0.5
    end = int(end)
    end += 1
    for check in range(2, end, 1):
        if number % check == 0:
            return False
    return True
def findNextPrime(n):
    num = n
    while True:
        if isPrime(num):
            break
        num += 1
    return num
N = int(sys.stdin.readline())
for testcase in range(N):
    testN = int(sys.stdin.readline().rstrip())
    result = findNextPrime(testN)
    print(result)