import sys
T = int(sys.stdin.readline())

for cycle in range(T):
    line = sys.stdin.readline().strip()
    n = int((len(line))**(1/2))
    board1 = [[0 for x1 in range(n)] for x2 in range(n)]
    ind = 0
    for x in range(n):
        for y in range(n-1, -1, -1):
            board1[y][x] = line[ind]
            ind += 1
    for y in range(n):
        for x in range(n):
            print(board1[y][x], end = '')
    print()