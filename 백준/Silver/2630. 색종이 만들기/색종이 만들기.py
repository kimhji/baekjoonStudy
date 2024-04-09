import sys, collections
def checkSameAll(x1, y1, x2, y2):
    global Board, result
    standardC = Board[x1][y1]
    for x in range(x1, x2+1):
        for y in range(y1, y2+1):
            if standardC != Board[x][y]:
                return False
    result[standardC] += 1
    return True

N = int(sys.stdin.readline())
Board = list()
result = [0, 0]
for inputC in range(N):
    Board.append(list(map(int, sys.stdin.readline().split())))

bag = collections.deque([(0, 0, N-1, N-1)])
num = 1
while num != 0:
    curCheck = bag.popleft()
    num -= 1
    if not checkSameAll(curCheck[0], curCheck[1], curCheck[2], curCheck[3]):
        interval = (curCheck[2]-curCheck[0])//2
        bag.append((curCheck[0], curCheck[1], interval+curCheck[0], interval + curCheck[1]))
        bag.append((interval+curCheck[0]+1, curCheck[1], curCheck[2], interval + curCheck[1]))
        bag.append((interval+curCheck[0]+1, interval + curCheck[1]+1, curCheck[2], curCheck[3]))
        bag.append((curCheck[0], interval + curCheck[1]+1, interval + curCheck[0], curCheck[3]))
        num += 4
print(result[0])
print(result[1])