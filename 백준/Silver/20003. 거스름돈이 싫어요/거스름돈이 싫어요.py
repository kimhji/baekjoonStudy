import sys

def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)

N = int(sys.stdin.readline().strip())
resultP = 1
resultC = -1
sell = []

for i in range(N):
    child, parent = map(int, sys.stdin.readline().strip().split(" "))
    minCommon = gcd(child, parent)
    tnsParent = parent//minCommon

    commonP = gcd(tnsParent, resultP)
    resultP *= tnsParent // commonP
    sell.append([child//minCommon, tnsParent])

for oneSell in sell:
    oneSell[0] *= resultP//oneSell[1]
    if resultC < 0:
        resultC = oneSell[0]
    resultC = gcd(oneSell[0], resultC)

resultCommon = gcd(resultC, resultP)
print(resultC//resultCommon, resultP//resultCommon)

