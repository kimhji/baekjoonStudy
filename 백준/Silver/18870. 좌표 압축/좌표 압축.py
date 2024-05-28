import sys
N = int(sys.stdin.readline())
numbers = list(map(int, sys.stdin.readline().split()))
result = dict()
tmpNumbers = list(set(numbers))
tmpNumbers.sort()

for check in range(len(tmpNumbers)):
    result[tmpNumbers[check]] = check

for p in numbers:
    print(result[p], end=' ')