import sys

N = int(sys.stdin.readline().strip())
strings = []
for i in range(N):
    strings.append(list(sys.stdin.readline().strip()))
length = len(strings[0])
result = 0

isValid = False
for i1 in range(N-1):
    for i2 in range(i1+1, N):
        dictBag = dict()
        changedSet = set()
        isValid = True
        for l in range(length):
            if strings[i1][l] in dictBag:
                if dictBag.get(strings[i1][l]) != strings[i2][l]:
                    isValid = False
                    break
            else:
                if strings[i2][l] in changedSet:
                    isValid = False
                    break
                dictBag[strings[i1][l]] = strings[i2][l]
                changedSet.add(strings[i2][l])
        if isValid:
            result += 1
print(result)