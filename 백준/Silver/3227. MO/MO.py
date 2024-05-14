import sys
P, N = map(int, sys.stdin.readline().split())
board = [0 for Set in range(P+1)]
result = [0, 0]
for cycle in range(N):
    order = int(sys.stdin.readline())
    if cycle % 2 == 0:
        player = 1
    else:
        player = 2
    board[order] = player
    preind = -1
    for check in range(1, order):
        if board[check] == 0:
            preind = -1
        elif board[check] == player:
            preind = check+1
    if preind != -1:
        for change in range(preind, order):
            board[change] = 0
    preind = -1
    for check in range(order+1, P+1):
        if board[check] == 0:
            preind = -1
            break
        elif board[check] == player:
            preind = check-1
            break
    if preind != -1:
        for change in range(order+1, preind+1):
            board[change] = 0

for check in range(1, P+1):
    if board[check] == 1:
        result[0] += 1
    elif board[check] == 2:
        result[1] += 1
print(result[0], result[1])