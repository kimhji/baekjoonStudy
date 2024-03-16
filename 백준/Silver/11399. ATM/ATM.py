import sys
N = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split()))
num.sort()
numSum = [0 for nums in range(N+1)]
for SUM in range(N):
    numSum[SUM+1] = num[SUM] + numSum[SUM]

print(sum(numSum))