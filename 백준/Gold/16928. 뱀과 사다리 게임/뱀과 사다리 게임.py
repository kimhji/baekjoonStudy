import sys
N, M = map(int, sys.stdin.readline().split())
board = [[0, 0, False] for i in range(101)]

for inputLadder in range(N):
    start, end = map(int, sys.stdin.readline().split())
    board[start][1] = end
for inputSnake in range(M):
    start, end = map(int, sys.stdin.readline().split())
    board[start][1] = end

step = 0
isVisit100 = False
loc = 1
bag = [1]
board[1][0] = 0
board[1][2] = True
while board[loc][1] != 0:
    loc = board[loc][1]
    board[loc][0] = 0
    board[loc][2] = True
    if loc == 100:
        isVisit100 = True
bag = [loc]
#[0] = step
#[1] = snake or ladder arrival
while board[100][0] == 0 and not isVisit100:
    nextBag = list()
    for cycle in bag:
        curloc = cycle
        loc = curloc
        for dice in range(1, 7):
            nextLoc = loc + dice
            if nextLoc <= 100 and not board[nextLoc][2]:
                board[nextLoc][0] = board[curloc][0] + 1
                board[nextLoc][2] = True
                while board[nextLoc][1] != 0:
                    nextLoc = board[nextLoc][1]
                    if not board[nextLoc][2]:
                        board[nextLoc][0] = board[curloc][0] + 1
                        board[nextLoc][2] = True
                nextBag.append(nextLoc)
    bag = nextBag
    #bag.sort(key=lambda x:board[x][0])

print(board[100][0])