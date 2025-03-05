import sys
def findSumAndPrint(x1, y1, x2, y2):
    global N, Board
    SUM = Board[x2-1][y2-1]
    if x1 > 1:
        SUM -= Board[x1-2][y2-1]
    if y1 > 1:
        SUM -= Board[x2-1][y1-2]
    if x1 > 1 and y1 > 1:
        SUM += Board[x1-2][y1-2]
    print(SUM)

N, M = map(int, sys.stdin.readline().split())
Board = list([0 for init in range(N)] for init2 in range(N))

for setBoard in range(N):
    line = list(map(int, sys.stdin.readline().split()))
    sumV = 0
    for initB in range(N):
        sumV += line[initB]
        Board[setBoard][initB] = sumV
        if setBoard > 0:
            Board[setBoard][initB] += Board[setBoard-1][initB]

for tryBoard in range(M):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    findSumAndPrint(x1, y1, x2, y2)
