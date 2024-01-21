import sys

N = int(sys.stdin.readline())
numbers = list(map(int, sys.stdin.readline().split()))
operators = list(map(int, sys.stdin.readline().split()))

def rfindMax(numindex, num, operatorList):
    global maxR
    if numindex >= N:
        if maxR < num:
            maxR = num
    tmpOperators = list()
    for operator in operatorList:
        tmpOperators.append(operator)
    for operator in range(4):
        if tmpOperators[operator] == 0:
            continue
        tmpOperators[operator] -= 1
        tmpnum = num
        if operator == 0:
            tmpnum += numbers[numindex]
        elif operator == 1:
            tmpnum -= numbers[numindex]
        elif operator == 2:
            tmpnum *= numbers[numindex]
        else:
            if tmpnum < 0:
                tmpnum *= -1
                tmpnum //= numbers[numindex]
                tmpnum *= -1
            else:
                tmpnum //= numbers[numindex]
        rfindMax(numindex+1, tmpnum, tmpOperators)
        tmpOperators[operator] += 1


def rfindMin(numindex, num, operatorList):
    global minR
    if numindex >= N:
        if minR > num:
            minR = num
    tmpOperators = list()
    for operator in operatorList:
        tmpOperators.append(operator)
    for operator in range(4):
        if tmpOperators[operator] == 0:
            continue
        tmpOperators[operator] -= 1
        tmpnum = num
        if operator == 0:
            tmpnum += numbers[numindex]
        elif operator == 1:
            tmpnum -= numbers[numindex]
        elif operator == 2:
            tmpnum *= numbers[numindex]
        else:
            if tmpnum < 0:
                tmpnum *= -1
                tmpnum //= numbers[numindex]
                tmpnum *= -1
            else:
                tmpnum //= numbers[numindex]
        rfindMin(numindex+1, tmpnum, tmpOperators)
        tmpOperators[operator] += 1

maxR = -1000000001
minR = 1000000001
rfindMax(1, numbers[0], operators)
rfindMin(1, numbers[0], operators)
print(maxR)
print(minR)