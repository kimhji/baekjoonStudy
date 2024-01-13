import sys

N, M = map(int, sys.stdin.readline().split())
def permutation(num, cmpArray):
    for inputNum in range(1, N+1):
        cmpArray.append(inputNum)
        if num == M:
            for printF in range(M):
                print(cmpArray[printF], end=' ')
            print()
        else:
            permutation(num + 1, cmpArray)
        cmpArray.pop()

permutation(1, list())
