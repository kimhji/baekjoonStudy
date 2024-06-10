import sys
N, M = map(int, sys.stdin.readline().split())
numbers = list(map(int, sys.stdin.readline().split()))
sumOfNumbers = [numbers[0]]
for check in range(1, N):
    sumOfNumbers.append(sumOfNumbers[check-1]+numbers[check])
result = 0
for cycle in range(N):
    if sumOfNumbers[cycle] == M:
        result += 1
    for cycle2 in range(cycle):
        if sumOfNumbers[cycle]-sumOfNumbers[cycle2] == M:
            result += 1
            break
print(result)