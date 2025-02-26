import sys

N = int(sys.stdin.readline().strip())
numbers = list(map(int,sys.stdin.readline().strip().split(" ")))
average = 0
for num in numbers:
    average += num
average //= N
result = 0
for cycle in range(N-1):
    if numbers[cycle] == average:
        continue
    if numbers[cycle] < average:
        tns = average - numbers[cycle]
        numbers[cycle] = average
        numbers[cycle+1] -= tns
        result += tns
    else:
        tns = numbers[cycle] - average
        numbers[cycle] = average
        numbers[cycle + 1] += tns
        result += tns
print(result)