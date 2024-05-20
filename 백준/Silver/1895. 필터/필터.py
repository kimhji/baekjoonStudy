import sys
R, C = map(int, sys.stdin.readline().split())
board = list()
filtered = list()
for check in range(R):
    line = list(map(int, sys.stdin.readline().split()))
    board.append(line)
T = int(sys.stdin.readline())
for y in range(1, R-1):
    line = list()
    for x in range(1, C-1):
        bag = [board[y][x], board[y-1][x-1], board[y-1][x], board[y-1][x+1], board[y][x-1], board[y][x+1], board[y+1][x-1], board[y+1][x], board[y+1][x+1]]
        bag.sort()
        line.append(bag[4])
    filtered.append(line)
num = 0
for y in range(R-2):
    for x in range(C-2):
        if filtered[y][x] >= T:
            num+=1
print(num)