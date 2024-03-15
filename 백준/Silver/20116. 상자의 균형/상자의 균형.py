import sys
sys.setrecursionlimit(100000000)
N, L = map(int, sys.stdin.readline().split())
Box = list(map(int, sys.stdin.readline().split()))
def checkCenterWeight(index):
    global isUnstable
    if index >= N:
        return Box[-1]

    weightSum = (checkCenterWeight(index + 1))
    weightCenter = weightSum / (N-index)
    if isUnstable == True or (weightCenter >= Box[index] + L or weightCenter <= Box[index] - L):
        isUnstable = True
    weightSum += Box[index]
    return weightSum
isUnstable = False
checkCenterWeight(0)
if isUnstable:
    print("unstable")
else:
    print("stable")
