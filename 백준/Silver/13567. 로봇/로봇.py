import sys

M, n = list(map(int, sys.stdin.readline().strip().split(" ")))
loc = [0, 0]
dir = 0
fail = False
for i in range(0, n):
    order = sys.stdin.readline().strip().split(" ")
    if order[0] == "TURN":
        isRight = int(order[1])
        if isRight == 1:
            dir += 1
        else:
            dir -= 1
        dir %= 4
    elif order[0] == "MOVE":
        far = int(order[1])
        if dir == 0:
            loc[0] += far
        elif dir == 1:
            loc[1] -= far
        elif dir == 2:
            loc[0] -= far
        else:
            loc[1] += far
        if loc[0] < 0 or loc[1] < 0 or loc[0] >= M or loc[1] >= M:
            fail = True
            break
if fail:
    print(-1)
else:
    print(loc[0], loc[1])