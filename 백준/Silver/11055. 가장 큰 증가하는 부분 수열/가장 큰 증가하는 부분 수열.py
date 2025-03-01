import sys

N = int(sys.stdin.readline().strip())
nums = list(map(int, sys.stdin.readline().strip().split(" ")))
maxV = list(0 for init in range(N))
result = 0
for cycle in range(N):
    beforeMaxIdx = -1
    tnsResult = 0
    for c2 in range(cycle-1, -1, -1):
        if nums[cycle] > nums[c2] and (beforeMaxIdx == -1 or maxV[beforeMaxIdx] <= maxV[c2]):
            beforeMaxIdx = c2
            tnsResult = maxV[beforeMaxIdx]

    tnsResult += nums[cycle]
    maxV[cycle] = tnsResult
    if result < tnsResult:
        result = tnsResult
print(result)