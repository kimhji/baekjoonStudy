import sys
L = int(sys.stdin.readline())
S = list(map(int, sys.stdin.readline().split()))
n = int(sys.stdin.readline())
result = 0
S.sort()
num1 = list()
for cycle in range(n, 0, -1):
    if cycle in S:
        break
    num1.append(cycle)
num2 = list()
for cycle in range(n, S[-1]):
    if cycle in S:
        break
    num2.append(cycle)
for cycle1 in num1:
    for cycle2 in num2:
        if cycle1 < cycle2:
            result += 1
print(result)