import sys

N = int(sys.stdin.readline().strip())
words = []
for init in range(N):
    words.append(sys.stdin.readline().strip())

firstDict = dict()
firstSet = set()
for one in list(words[0]):
    firstDict[one] = (firstDict.get(one, 0)) + 1
    firstSet.add(one)
result = 0
for cycle in range(1, N):
    tnsSet = set()
    tnsDict = dict()
    for one in firstSet:
        tnsSet.add(one)
    for two in list(words[cycle]):
        tnsSet.add(two)
        tnsDict[two] = (tnsDict.get(two, 0))+1
    diff = 0
    isOK = True
    for ch in tnsSet:
        tnsDiff = tnsDict.get(ch, 0)-firstDict.get(ch, 0)
        diff += abs(tnsDiff)
        if abs(tnsDiff) > 1:
            isOK = False
            break
    if isOK and (diff < 2 or diff == 2 and len(words[cycle]) == len(words[0])):
        result += 1
print(result)