import sys, heapq
input = sys.stdin.readline
N, K = map(int, input().split())
student = list(map(int, input().split()))

sortedValues = [(-1, -1) for num0 in range(K - 1)]
if K > 1:
    for diffSearch in range(0, N - 1):
        diff = student[diffSearch + 1] - student[diffSearch]
        if sortedValues[0][0] < diff:
            heapq.heappop(sortedValues)
            heapq.heappush(sortedValues, (diff,diffSearch))
sortedValues.sort(key=lambda x: x[1])
sumCost = 0
frontV = student[0]
for StudentIndex in sortedValues:
    sumCost += student[StudentIndex[1]] - frontV
    frontV = student[StudentIndex[1] + 1]
sumCost += student[N - 1] - frontV
print(sumCost)