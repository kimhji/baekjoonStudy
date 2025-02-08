import sys

N, L = map(int, sys.stdin.readline().strip().split(" "))
curL = L
firstV = 0
while curL <= 100:
    middleV = N//curL
    times = curL//2
    bothV = middleV * 2
    firstV = middleV
    if curL % 2 == 0:
        middleV += middleV + 1
        bothV = middleV
        times -= 1
    firstV -= times
    sumV = middleV + bothV * times
    if sumV == N and firstV >= 0:
        break
    curL += 1

if curL > 100:
    print(-1)
else:
    arr = [(firstV + i) for i in range(0, curL)]
    print(" ".join(map(str, arr)))

