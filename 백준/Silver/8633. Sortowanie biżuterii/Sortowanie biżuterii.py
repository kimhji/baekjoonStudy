import sys
N = int(sys.stdin.readline())
result = []
for cycle in range(N):
    line = sys.stdin.readline().strip()
    result.append((len(line), line))
result.sort()
for cyclep in range(N):
    print(result[cyclep][1])