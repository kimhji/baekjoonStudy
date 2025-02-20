import sys

N = int(sys.stdin.readline().strip())
boxes = list(map(int, sys.stdin.readline().strip().split(" ")))
sizeBag = set()
numDict = dict()
sizeBag.add(0)
numDict[0] = 0

maxV = 0
for i in range(N):
    for size in list(sizeBag):
        if size < boxes[i]:
            if boxes[i] not in sizeBag or numDict[boxes[i]] < numDict.get(size) + 1:
                numDict[boxes[i]] = numDict.get(size) + 1
                if maxV < numDict.get(boxes[i]):
                    maxV = numDict.get(boxes[i])
            sizeBag.add(boxes[i])

print(maxV)