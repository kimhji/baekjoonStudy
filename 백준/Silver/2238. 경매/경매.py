import sys
U, N = map(int, sys.stdin.readline().split())
numDict = dict()
PList = list()
for cycle in range(N):
    name, spend = sys.stdin.readline().split()
    spend = int(spend)
    PList.append((name, spend))
    if spend not in numDict:
        numDict[spend] = 1
    else:
        numDict[spend] += 1
minP = -1
minBag = set()
for check in numDict.keys():
    if minP < 0 or numDict[check] < minP:
        minP = numDict[check]
        minBag = set()
        minBag.add(check)
    elif numDict[check] == minP:
        minBag.add(check)
bag = list()
for check in PList:
    if check[1] in minBag:
        bag.append(check)
result = [-1, -1]
for check in bag:
    if result[1] == -1 or check[1] < result[1]:
        result[0] = check[0]
        result[1] = check[1]
print(f"{result[0]} {result[1]}")