import sys, collections
N, M, T = map(int, sys.stdin.readline().split())
checkSet = set()
def findShortest(lists):
    global Board
    findTns = (0, 0, 0, False)
    while True:
        if lists == collections.deque() or findTns[2] > T:
            print("Fail")
            return
        findTns = lists.popleft()
        if findTns[0] == N-1 and findTns[1] == M-1:
            print(findTns[2])
            return
        else:
            haveSword = False
            if Board[findTns[0]][findTns[1]] == 2 or findTns[3]:
                haveSword = True
            if findTns[0] < N - 1 and (findTns[0]+1, findTns[1], haveSword) not in checkSet and (haveSword or Board[findTns[0]+1][findTns[1]] != 1):
                lists.append((findTns[0]+1, findTns[1], findTns[2]+1, haveSword))
                if findTns[0]+1 == N - 1 and findTns[1] == M - 1:
                    print(findTns[2]+1)
                    return
                checkSet.add((findTns[0]+1, findTns[1], haveSword))
            if findTns[1] < M - 1 and (findTns[0], findTns[1] + 1, haveSword) not in checkSet and (haveSword or Board[findTns[0]][findTns[1] + 1] != 1):
                lists.append((findTns[0], findTns[1] + 1, findTns[2] + 1, haveSword))
                if findTns[0] == N - 1 and findTns[1]+1 == M - 1:
                    print(findTns[2]+1)
                    return
                checkSet.add((findTns[0], findTns[1] + 1, haveSword))
            if findTns[0] > 0 and (findTns[0]-1, findTns[1], haveSword) not in checkSet and (haveSword or Board[findTns[0]-1][findTns[1]] != 1):
                lists.append((findTns[0]-1, findTns[1], findTns[2]+1, haveSword))
                if findTns[0]-1 == N - 1 and findTns[1] == M - 1:
                    print(findTns[2]+1)
                    return
                checkSet.add((findTns[0]-1, findTns[1], haveSword))
            if findTns[1] > 0 and (findTns[0], findTns[1] - 1, haveSword) not in checkSet and (haveSword or Board[findTns[0]][findTns[1] - 1] != 1):
                lists.append((findTns[0], findTns[1] - 1, findTns[2] + 1, haveSword))
                if findTns[0] == N - 1 and findTns[1]-1 == M - 1:
                    print(findTns[2]+1)
                    return
                checkSet.add((findTns[0], findTns[1] - 1, haveSword))

Board = list()
for setMap in range(N):
    line = list(map(int, sys.stdin.readline().split()))
    Board.append(line)
lists = collections.deque()
lists.append((0, 0, 0, False))
checkSet.add((0, 0, False))
findShortest(lists)