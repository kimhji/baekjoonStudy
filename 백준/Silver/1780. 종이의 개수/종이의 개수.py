import sys

def isOne(y,x, size):
    global Board
    standard = Board[y][x]
    for i in range(size):
        for j in range(size):
            if Board[y+i][x+j] != standard:
                return False
    return True

def solve(y,x,size):
    global Board, result

    if not isOne(y, x, size):
        nextSize = size//3
        for i in range(3):
            for j in range(3):
                solve(i*nextSize+y, j*nextSize+x, nextSize)
    else:
        standard = Board[y][x]
        result[1+standard] += 1


N = int(sys.stdin.readline().strip())
Board = []
for i in range(N):
    line = list(map(int, sys.stdin.readline().strip().split()))
    Board.append(line)
result = [0, 0, 0]
solve(0,0,N)

print("\n".join(map(str,result)))