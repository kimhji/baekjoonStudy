import sys
N = int(sys.stdin.readline())
stringSet = set()
for strings in range(N):
    stringInput = sys.stdin.readline().rstrip()
    num = len(stringInput)
    stringSet.add((stringInput, num))
stringList = list(stringSet)
stringList.sort(key=lambda x: (x[1], x[0]))
for prints in stringList:
    print(prints[0])