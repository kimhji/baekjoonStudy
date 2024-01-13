import sys

N, M = map(int, sys.stdin.readline().split())
numList = list(map(int, sys.stdin.readline().split()))

numList.sort()
def permutation(num, cmpArray):
    for inputNum in numList:
        cmpArray.append(inputNum)
        if num == M:
            for printF in range(M):
                print(cmpArray[printF], end=' ')
            print()
        else:
            permutation(num + 1, cmpArray)
        cmpArray.pop()

permutation(1, list())
