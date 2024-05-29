import sys
sys.setrecursionlimit(2000)

def cycleSearch(bag, value):
    global board, resultBoard, n, m
    bagNext = set()
    for check in bag:
        r = check[0]
        c = check[1]
        if board[r][c] == 0:
            resultBoard[r][c] = 0
            continue
        if resultBoard[r][c] == -1:
            resultBoard[r][c] = value
            if r>0:
                bagNext.add((r-1, c))
            if r<n-1:
                bagNext.add((r+1, c))
            if c > 0:
                bagNext.add((r, c-1))
            if c < m - 1:
                bagNext.add((r, c+1))
    if len(bagNext) != 0:
        cycleSearch(bagNext, value + 1)
    return

n, m = map(int, sys.stdin.readline().split())
board = list()
resultBoard = [[-1 for c1 in range(m)] for c2 in range(n)]
startLoc = (-1, -1)
for cycle in range(n):
    line = list(map(int, sys.stdin.readline().split()))
    if startLoc[0] == -1:
        for check in range(m):
            if line[check] == 2:
                startLoc = (cycle, check)
    board.append(line)
cycleSearch(list([startLoc]), 0)
for check in range(n):
    for check2 in range(m):
        if board[check][check2] == 0:
            resultBoard[check][check2] = 0
for cycle1 in range(n):
    for cycle2 in range(m):
        print(resultBoard[cycle1][cycle2], end=' ')
    print()