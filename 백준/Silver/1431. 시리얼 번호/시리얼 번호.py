import sys
N = int(sys.stdin.readline())
numList = []
for cycle in range(N):
    length = 0
    str1 = sys.stdin.readline().strip()
    number = 0
    for check in str1:
        length += 1
        if check >= '0' and check <='9':
            number += int(check)
    numList.append((str1, length, number))
numList.sort(key=lambda x: (x[1], x[2], x[0]))
for p in numList:
    print(p[0])