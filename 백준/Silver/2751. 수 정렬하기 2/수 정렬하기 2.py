import sys
N = int(sys.stdin.readline())
numbers = list()
for inputC in range(N):
    numbers.append(int(sys.stdin.readline()))
numbers.sort()
for printC in numbers:
    print(printC)