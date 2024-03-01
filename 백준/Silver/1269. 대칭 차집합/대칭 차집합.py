import sys
N, M = map(int, sys.stdin.readline().split())
bag = set()
both = 0
for ASearch in map(int, sys.stdin.readline().split()):
    bag.add(ASearch)
for BSearch in map(int, sys.stdin.readline().split()):
    if BSearch in bag:
        both += 1
result = N + M - both * 2
print(result)