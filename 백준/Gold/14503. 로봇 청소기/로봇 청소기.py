import sys

def isEmptyNear(r, c):
    global N, M, board
    if r > 0 and board[r-1][c] == "0":
        return True
    if r < N-1 and board[r+1][c] == "0":
        return True
    if c > 0 and board[r][c-1] == "0":
        return True
    if c < M-1 and board[r][c+1] == "0":
        return True
    return False

N, M = map(int,sys.stdin.readline().strip().split(" "))
r, c, d = map(int, sys.stdin.readline().strip().split(" "))
result = 0
board = []
for init in range(N):
    board.append(sys.stdin.readline().strip().split(" "))
isStopped = False
while not isStopped:
    if board[r][c] != "2":
        result += 1
    board[r][c] = "2"
    if isEmptyNear(r, c):
        d -= 1
        d %= 4
        if d == 2:
            if r < N-1 and board[r+1][c] == "0":
                r += 1
        elif d == 3:
            if c > 0 and board[r][c-1] == "0":
                c -= 1
        elif d == 0:
            if r > 0 and board[r-1][c] == "0":
                r -= 1
        elif d == 1:
            if c < M-1 and board[r][c+1] == "0":
                c += 1
    else:
        if d == 0:
            if r < N-1 and board[r+1][c] != "1":
                r += 1
            else:
                isStopped = True
        elif d == 1:
            if c > 0 and board[r][c-1] != "1":
                c -= 1
            else:
                isStopped = True
        elif d == 2:
            if r > 0 and board[r-1][c] != "1":
                r -= 1
            else:
                isStopped = True
        elif d == 3:
            if c < M-1 and board[r][c+1] != "1":
                c += 1
            else:
                isStopped = True
print(result)