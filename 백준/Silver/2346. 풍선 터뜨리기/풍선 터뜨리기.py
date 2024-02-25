import sys
N = int(sys.stdin.readline())
number = list(map(int, sys.stdin.readline().split()))
balloonList = list()
boomed = 0
for cycle in range(N):
    tmpIn = number[cycle]
    balloonList.append([number[cycle], False])
ind = 0
go = 0
while True:
    direction = False
    print(ind + 1, end=' ')
    balloonList[ind][1] = True
    boomed += 1
    if boomed == N:
        break
    go = balloonList[ind][0]
    if go < 0:
        direction = True
        go = abs(go)
    while go != 0:
        if direction:
            ind -= 1
            if ind < 0:
                ind += N
            if not balloonList[ind][1]:
                go -= 1
        else:
            ind += 1
            if ind >= N:
                ind -= N
            if not balloonList[ind][1]:
                go -= 1
