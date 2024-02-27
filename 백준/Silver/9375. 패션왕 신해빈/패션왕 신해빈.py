import sys
testcase = int(sys.stdin.readline())
for check_input in range(testcase):
    dictionaryC = {}
    keys = set()
    n = int(sys.stdin.readline())
    numOfClothes = []
    numOftype = 0
    result = 1
    for check_input2 in range(n):
        name, typeC = sys.stdin.readline().split()
        if typeC in keys:
            ind = dictionaryC[typeC]
            numOfClothes[ind] += 1
        else:
            keys.add(typeC)
            dictionaryC[typeC] = numOftype
            numOftype += 1
            numOfClothes.append(1)
    for cal_numOfCase in numOfClothes:
        result *= cal_numOfCase+1
    result -= 1
    print(result)