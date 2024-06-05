import sys
R, C = map(int, sys.stdin.readline().split())
board = list()
for check in range(R):
    board.append(list(map(int, sys.stdin.readline().split())))
m = -1
idx = (-1, -1)
for cycle1 in range(1, R-1):
    for cycle2 in range(1, C-1):
        x = 0
        x += board[cycle1][cycle2]
        x += board[cycle1-1][cycle2-1]
        x += board[cycle1-1][cycle2]
        x += board[cycle1-1][cycle2+1]
        x += board[cycle1][cycle2-1]
        x += board[cycle1][cycle2+1]
        x += board[cycle1+1][cycle2-1]
        x += board[cycle1+1][cycle2]
        x += board[cycle1+1][cycle2+1]
        if x > m:
            m = x
            idx = (cycle1, cycle2)
print(m)
print(idx[0], idx[1])