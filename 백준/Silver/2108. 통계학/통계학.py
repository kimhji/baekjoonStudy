import sys
N = int(sys.stdin.readline())

numList = list()
dictionarys = dict()
SUM = 0
maxFrequency = 0
freqBag = list()
for inputC in range(N):
    num = int(sys.stdin.readline())
    numList.append(num)
    if num in dictionarys:
        dictionarys[num] += 1
    else:
        dictionarys[num] = 1
    if dictionarys[num] == maxFrequency:
        freqBag.append(num)
    elif dictionarys[num] > maxFrequency:
        maxFrequency = dictionarys[num]
        freqBag = [num]
    SUM += num
print(round(SUM/N))
centerList = numList[:]
centerList.sort()
if N % 2 == 1:
    print(centerList[N//2])
else:
    result = centerList[N//2] + centerList[N//2+1]
    result //= 2
    print(result)

freqBag.sort()
if len(freqBag) > 1:
    print(freqBag[1])
else:
    print(freqBag[0])
print(centerList[-1]-centerList[0])