import sys
Nx, Ny = map(int, sys.stdin.readline().split())
def nemonemo(Board, BeforeX, BeforeY):
    global numOfCase
    for x in range(BeforeX, Nx + 1):
        startY = 1
        if x == BeforeX:
            startY = BeforeY + 1
        for y in range(startY, Ny + 1):
            if Board[x][y] == 1:
                continue
            xi = x-1
            yi = y-1
            if Board[xi][yi] == 1 and Board[xi][y] == 1 and Board[x][yi] == 1:
                continue

            Board[x][y] = 1
            numOfCase += 1
            nemonemo(Board, x, y)
            Board[x][y] = 0


BoardEx = [[0 for Vy in range(Ny + 1)] for Vx in range(Nx + 1)]
numOfCase = 1
if Nx == 1:
    for x2 in range(Ny):
        numOfCase *= 2
elif Ny == 1:
    for x2 in range(Nx):
        numOfCase *= 2
else:
    nemonemo(BoardEx, 1, 0)

print(numOfCase)