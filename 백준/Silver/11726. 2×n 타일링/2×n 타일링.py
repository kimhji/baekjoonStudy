import sys
sys.setrecursionlimit(100000)
listN = [0 for inputC in range(1001)]
def findNum(curIndex):
    if curIndex == 1:
        listN[curIndex] = 1
        return 1
    if curIndex == 2:
        listN[curIndex] = 2
        return 2
    if listN[curIndex] != 0:
        return listN[curIndex]

    listN[curIndex] = (findNum(curIndex - 1) + findNum(curIndex - 2))%10007
    return listN[curIndex]
n = int(sys.stdin.readline())

findNum(n)
print(listN[n])