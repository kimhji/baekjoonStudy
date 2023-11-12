N = int(input())
Board = [[0 for _ in range(101)] for _ in range(101)]
DragonCurve = [[] for _ in range(N)]
for Input in range(N):
    InputCurve = list(map(int, input().split()))
    DragonCurve[Input].append((InputCurve[0], InputCurve[1], InputCurve[2], InputCurve[3]))
    for updateCurve in range(InputCurve[3]):
        for checkReverse in range(len(DragonCurve[Input])-1, -1,-1):
            nextX = DragonCurve[Input][-1][0]
            nextY = DragonCurve[Input][-1][1]
            nextD = DragonCurve[Input][checkReverse][2] + 1
            nextD %= 4
            if DragonCurve[Input][-1][2] == 0:
                nextX += 1
            elif DragonCurve[Input][-1][2] == 1:
                nextY -= 1
            elif DragonCurve[Input][-1][2] == 2:
                nextX -= 1
            elif DragonCurve[Input][-1][2] == 3:
                nextY += 1
            DragonCurve[Input].append((nextX, nextY, nextD))
for BoardUpdate in range(N):
    for _ in range(len(DragonCurve[BoardUpdate])):
        Board[DragonCurve[BoardUpdate][_][1]][DragonCurve[BoardUpdate][_][0]] += 1
    x = DragonCurve[BoardUpdate][-1][0]
    y = DragonCurve[BoardUpdate][-1][1]
    if DragonCurve[BoardUpdate][-1][2] == 0:
        x += 1
    elif DragonCurve[BoardUpdate][-1][2] == 1:
        y -= 1
    elif DragonCurve[BoardUpdate][-1][2] == 2:
        x -= 1
    elif DragonCurve[BoardUpdate][-1][2] == 3:
        y += 1
    Board[y][x] += 1
sum = 0
for search1 in range(100):
    for search2 in range(100):
        if Board[search1][search2] != 0 and Board[search1 + 1][search2] != 0 and Board[search1][search2 + 1] != 0 and Board[search1 + 1][search2 + 1] != 0:
            sum += 1
print(sum)