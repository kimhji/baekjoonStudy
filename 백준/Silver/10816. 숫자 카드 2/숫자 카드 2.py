import sys
N = int(sys.stdin.readline())
cards = list(map(int, sys.stdin.readline().split()))
numOfCards = dict()
for inputC in cards:
    if inputC in numOfCards:
        numOfCards[inputC] += 1
    else:
        numOfCards[inputC] = 1
M = int(sys.stdin.readline())
for orderC in list(map(int, sys.stdin.readline().split())):
    if orderC in numOfCards:
        print(numOfCards[orderC], end=' ')
    else:
        print(0, end=' ')