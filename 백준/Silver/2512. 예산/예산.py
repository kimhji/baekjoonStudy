import sys
N = int(sys.stdin.readline().strip())
local = list(map(int,sys.stdin.readline().strip().split(" ")))
nation = int(sys.stdin.readline().strip())

tnsTotal = 0
maxV = 0
for l in local:
    tnsTotal += l
    if maxV < l:
        maxV = l

while tnsTotal > nation:
    diff = (tnsTotal-nation)//N
    namuzi = (tnsTotal-nation)%N
    if namuzi > 0:
        diff += 1
    maxV -= diff
    tnsTotal = 0
    for l in local:
        if maxV < l:
            tnsTotal += maxV
        else:
            tnsTotal += l
print(maxV)