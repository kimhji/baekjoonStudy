import sys
def sliceINT(intValue):
    returnList = list()
    while(intValue != 0):
        inputV = intValue % 10000
        returnList.append(inputV)
        intValue //= 10000
    return returnList

N, M = map(int, sys.stdin.readline().split())
numList = list(map(int, sys.stdin.readline().split()))
numIndexList = set()
sameCheckList = set()
def permutation(num, cmpArray):
    for inputNum in range(N):
        if inputNum not in numIndexList:
            cmpArray.append(numList[inputNum])
            numIndexList.add(inputNum)
            if num == M:
                IntValue = 0
                for toInt in range(M):
                    IntValue *= 10000
                    IntValue += cmpArray[toInt]
                sameCheckList.add(IntValue)
            else:
                permutation(num + 1, cmpArray)
            cmpArray.pop()
            numIndexList.remove(inputNum)

permutation(1, list())
printList = list(sameCheckList)
printList2 = list()
for printF in printList:
    printList2.append(sliceINT(printF))
printList2.sort()
for printF in printList2:
    for pri in range(M):
        print(printF[pri],end=' ')
    print()