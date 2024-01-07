import sys

inputString = sys.stdin.readline()

maxR = 0
minR = 0

Mnum = 0
M = 1
for maxCheck in inputString:
    if maxCheck == 'M':
        Mnum += 1
    elif maxCheck == 'K':
        Mnum += 1
        maxR *= 10
        for x10 in range(Mnum - 1):
            maxR *= 10
            M *= 10
        M *= 5
        maxR += M
        Mnum = 0
        M = 1
if Mnum >= 1:
    maxR *= 10
    for x10 in range(Mnum - 1):
        maxR *= 10
        M *= 10
        M += 1
    maxR += M

Mnum = 0
M = 1
for minCheck in inputString:
    if minCheck == 'M':
        Mnum += 1
    elif minCheck == 'K':
        for x10 in range(Mnum - 1):
            minR *= 10
            M *= 10
        if Mnum >= 1:
            minR *= 10
            minR += M
        minR *= 10
        minR += 5
        M = 1
        Mnum = 0
if Mnum >= 1:
    minR *= 10
    for x10 in range(Mnum - 1):
        minR *= 10
        M *= 10
    minR += M
print(maxR)
print(minR)