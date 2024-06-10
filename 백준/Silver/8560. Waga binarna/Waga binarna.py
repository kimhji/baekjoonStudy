import sys
N = int(sys.stdin.readline())
result = list()
for cycle in range(N):
    l, m = map(int, sys.stdin.readline().split())
    result.append((l, m))
result.sort(key=lambda x: x[0])
for p in range(N):
    print(result[p][0], result[p][1])