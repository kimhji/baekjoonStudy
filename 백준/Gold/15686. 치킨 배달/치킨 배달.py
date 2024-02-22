import sys,collections
N, M = map(int, sys.stdin.readline().split())
Board = list()

for initBoard in range(N):
    Board.append(list(map(int, sys.stdin.readline().split())))

Chicken = list()
House = list()
def findMinD(n, val):
    global MinValue, houseValues, houseNum, chickenNum
    if n == M:
        result = sum(houseValues)
        if result < MinValue:
            MinValue = result
        return
    if val >= chickenNum:
        return
    for inputChick in range(val, chickenNum):
        bag = list()
        for Hvalue in range(houseNum):
            tmpV = abs(House[Hvalue][0] - Chicken[inputChick][0]) + abs(House[Hvalue][1] - Chicken[inputChick][1])
            if tmpV < houseValues[Hvalue]:
                bag.append([Hvalue, houseValues[Hvalue]])
                houseValues[Hvalue] = tmpV
        findMinD(n+1, inputChick + 1)
        while bag != list():
            beforeState = bag.pop()
            houseValues[beforeState[0]] = beforeState[1]

houseNum = 0
chickenNum = 0
for x in range(N):
    for y in range(N):
        if Board[x][y] == 1:
            House.append((x, y))
            houseNum += 1
        elif Board[x][y] == 2:
            Chicken.append((x, y))
            chickenNum += 1
houseValues = list(1000000 for Houses in range(houseNum))
MinValue = 1000000
findMinD(0, 0)

print(MinValue)