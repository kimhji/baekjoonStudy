import sys
N = int(sys.stdin.readline().strip())
levels = list()
for inp in range(N):
    levels.append(int(sys.stdin.readline().strip()))
result = 0
for check in range(N-2, -1, -1):
    while levels[check] >= levels[check+1]:
        levels[check] -= 1
        result += 1
print(result)