import sys
N = int(sys.stdin.readline())
board = list()
result = [[0 for x in range(N)] for y in range(N)]
for check in range(N):
    line = list(sys.stdin.readline())
    board.append(line)

for check1 in range(N):
    for check2 in range(N):
        if board[check1][check2] == '.':
            if check1 > 0 and check2 > 0 and board[check1-1][check2-1] != '.':
                result[check1][check2] += int(board[check1-1][check2-1])
            if check1 > 0 and board[check1 - 1][check2] != '.':
                result[check1][check2] += int(board[check1 - 1][check2])
            if check1 > 0 and check2 < N-1 and board[check1-1][check2+1] != '.':
                result[check1][check2] += int(board[check1-1][check2+1])
            if check2 < N-1 and board[check1][check2+1] != '.':
                result[check1][check2] += int(board[check1][check2+1])
            if check1 < N-1 and check2 < N-1 and board[check1+1][check2+1] != '.':
                result[check1][check2] += int(board[check1+1][check2+1])
            if check1 < N-1 and board[check1+1][check2] != '.':
                result[check1][check2] += int(board[check1+1][check2])
            if check1 < N-1 and check2 > 0 and board[check1+1][check2-1] != '.':
                result[check1][check2] += int(board[check1+1][check2-1])
            if check2 > 0 and board[check1][check2-1] != '.':
                result[check1][check2] += int(board[check1][check2-1])
        else:
            result[check1][check2] = -1

for check1 in range(N):
    for check2 in range(N):
        if result[check1][check2] == -1:
            print('*', end='')
        elif result[check1][check2] < 10:
            print(result[check1][check2], end='')
        else:
            print('M', end='')
    print()