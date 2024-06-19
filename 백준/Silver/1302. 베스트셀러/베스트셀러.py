import sys
N= int(sys.stdin.readline())
bookDict = dict()
for cycle in range(N):
    line = sys.stdin.readline().strip()
    if line in bookDict:
        bookDict[line] += 1
    else:
        bookDict[line] = 1
MaxVal = -1
keyR = list()
for ch in bookDict.keys():
    if bookDict[ch] > MaxVal:
        MaxVal = bookDict[ch]
        keyR = [ch]
    elif bookDict[ch] == MaxVal:
        keyR.append(ch)
keyR.sort()
print(keyR[0])