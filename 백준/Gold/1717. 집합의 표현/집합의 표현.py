import sys
sys.setrecursionlimit(1000000)
def FindRoot(x):
    global n, numList
    if numList[x] == x:
        return x
    numList[x] = FindRoot(numList[x])
    return numList[x]
def unionList(a, b):
    global n, numList
    a = FindRoot(a)
    b = FindRoot(b)
    if a < b:
        numList[b] = a
    else:
        numList[a] = b

def CheckSet(a, b):
    global n, numList
    a = FindRoot(a)
    b = FindRoot(b)
    if a == b:
        sys.stdout.write("YES\n")
    else:
        sys.stdout.write("NO\n")

n, m = map(int, sys.stdin.readline().split())
numList = [ix for ix in range(n+1)]
for inputs in range(m):
    request, a, b = map(int, sys.stdin.readline().split())
    if request == 0:
        unionList(a, b)
    else:
        CheckSet(a, b)