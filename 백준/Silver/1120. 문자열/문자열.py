import sys
A, B = sys.stdin.readline().split()
nA = len(A)
nB = len(B)
diff = nB - nA
minV = -1
for cycle in range(0, diff+1):
    diStr = 0
    for cyA in range(nA):
        if A[cyA] != B[cyA + cycle]:
            diStr += 1
    if minV == -1 or minV > diStr:
        minV = diStr
print(minV)