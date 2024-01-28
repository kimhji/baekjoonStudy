import sys, collections
M, N = map(int, sys.stdin.readline().split())
def searchTomato(Board, dequeOf1):
    days = 0
    while dequeOf1 != collections.deque():
        index = dequeOf1.popleft()
        days = index[2]
        if index[0] > 0:
            if Board[index[0]-1][index[1]] == 0:
                Board[index[0]-1][index[1]] = 1
                dequeOf1.append((index[0]-1, index[1], index[2] + 1))
        if index[1] > 0:
            if Board[index[0]][index[1]-1] == 0:
                Board[index[0]][index[1]-1] = 1
                dequeOf1.append((index[0], index[1]-1, index[2] + 1))
        if index[0]<N-1:
            if Board[index[0]+1][index[1]] == 0:
                Board[index[0]+1][index[1]] = 1
                dequeOf1.append((index[0]+1, index[1], index[2] + 1))
        if index[1]<M-1:
            if Board[index[0]][index[1]+1] == 0:
                Board[index[0]][index[1]+1] = 1
                dequeOf1.append((index[0], index[1]+1, index[2] + 1))
    flag = 0
    for x in range(N):
        for y in range(M):
            if Board[x][y] == 0:
                flag = 1
    if flag == 1:
        days = -1

    print(days)



Board = list()
for inputCycle in range(N):
    line = list(map(int, sys.stdin.readline().split()))
    Board.append(line)

dequeOf1 = collections.deque()
for x in range(N):
    for y in range(M):
        if Board[x][y] == 1:
            dequeOf1.append((x, y, 0))
searchTomato(Board, dequeOf1)

