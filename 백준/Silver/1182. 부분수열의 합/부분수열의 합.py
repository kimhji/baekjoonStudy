import sys

def findValid(idx, value):
    global arr, N, S, result
    curV = value + arr[idx]
    if curV == S:
        result+=1

    for i in range(idx+1, N):
        findValid(i, curV)

result = 0
N, S = map(int, sys.stdin.readline().strip().split(" "))

arr = list(map(int, sys.stdin.readline().strip().split(" ")))
for i in range(N):
    findValid(i, 0)
print(result)