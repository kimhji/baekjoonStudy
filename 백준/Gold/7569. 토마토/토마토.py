import sys, collections
M, N, H = map(int, sys.stdin.readline().split())
def searchTomato(Board, dequeOf1):
    days = 0
    while dequeOf1 != collections.deque():
        index = dequeOf1.popleft()
        days = index[3]
        if index[0] > 0:
            if Board[index[0]-1][index[1]][index[2]] == 0:
                Board[index[0]-1][index[1]][index[2]] = 1
                dequeOf1.append((index[0]-1, index[1], index[2], index[3] + 1))
        if index[1] > 0:
            if Board[index[0]][index[1]-1][index[2]] == 0:
                Board[index[0]][index[1]-1][index[2]] = 1
                dequeOf1.append((index[0], index[1]-1, index[2], index[3] + 1))
        if index[2] > 0:
            if Board[index[0]][index[1]][index[2]-1] == 0:
                Board[index[0]][index[1]][index[2]-1] = 1
                dequeOf1.append((index[0], index[1], index[2]-1, index[3] + 1))
        if index[0]<H-1:
            if Board[index[0]+1][index[1]][index[2]] == 0:
                Board[index[0]+1][index[1]][index[2]] = 1
                dequeOf1.append((index[0]+1, index[1], index[2], index[3] + 1))
        if index[1]<N-1:
            if Board[index[0]][index[1]+1][index[2]] == 0:
                Board[index[0]][index[1]+1][index[2]] = 1
                dequeOf1.append((index[0], index[1]+1, index[2], index[3] + 1))
        if index[2]<M-1:
            if Board[index[0]][index[1]][index[2]+1] == 0:
                Board[index[0]][index[1]][index[2]+1] = 1
                dequeOf1.append((index[0], index[1], index[2]+1, index[3] + 1))
    flag = 0
    for z in range(H):
        for x in range(N):
            for y in range(M):
                    if Board[z][x][y] == 0:
                        flag = 1
    if flag == 1:
        days = -1

    print(days)



Board = list([] for height in range(H))

for z in range(H):
    for inputCycle in range(N):
        line = list(map(int, sys.stdin.readline().split()))
        Board[z].append(line)

dequeOf1 = collections.deque()

for z in range(H):
    for x in range(N):
        for y in range(M):
                if Board[z][x][y] == 1:
                    dequeOf1.append((z, x, y, 0))
searchTomato(Board, dequeOf1)

