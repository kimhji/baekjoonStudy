import sys
N = int(sys.stdin.readline())
board = [[-1 for r in range(N)] for c in range(N)]
like = [() for likes in range(N**2+1)]
loc = [() for locs in range(N**2+1)]

for inputCycle in range(N**2):
    studentNumber, like1, like2, like3, like4 = map(int, sys.stdin.readline().split())
    like[studentNumber] = (like1, like2, like3, like4)
    bag = list()
    for xCycle in range(N):
        for yCycle in range(N):
            if board[xCycle][yCycle] != -1:
                continue
            surroundEmpty = 0
            surroundLike = 0
            if xCycle > 0:
                if board[xCycle-1][yCycle] == -1:
                    surroundEmpty += 1
                elif board[xCycle-1][yCycle] in like[studentNumber]:
                    surroundLike += 1
            if xCycle < N - 1:
                if board[xCycle+1][yCycle] == -1:
                    surroundEmpty += 1
                elif board[xCycle+1][yCycle] in like[studentNumber]:
                    surroundLike += 1
            if yCycle > 0:
                if board[xCycle][yCycle-1] == -1:
                    surroundEmpty += 1
                elif board[xCycle][yCycle-1] in like[studentNumber]:
                    surroundLike += 1
            if yCycle < N - 1:
                if board[xCycle][yCycle+1] == -1:
                    surroundEmpty += 1
                elif board[xCycle][yCycle+1] in like[studentNumber]:
                    surroundLike += 1
            bag.append([surroundLike, surroundEmpty, xCycle, yCycle])
    bag.sort(key=lambda x: (-x[0], -x[1], x[2], x[3]))
    place = bag[0]
    board[place[2]][place[3]] = studentNumber
sumOfScore = 0
for xCycle in range(N):
    for yCycle in range(N):
        studentNumber = board[xCycle][yCycle]
        surroundLike = 0
        if xCycle > 0:
            if board[xCycle - 1][yCycle] in like[studentNumber]:
                surroundLike += 1
        if xCycle < N - 1:
            if board[xCycle + 1][yCycle] in like[studentNumber]:
                surroundLike += 1
        if yCycle > 0:
            if board[xCycle][yCycle - 1] in like[studentNumber]:
                surroundLike += 1
        if yCycle < N - 1:
            if board[xCycle][yCycle + 1] in like[studentNumber]:
                surroundLike += 1
        if surroundLike == 1:
            sumOfScore += 1
        elif surroundLike == 2:
            sumOfScore += 10
        elif surroundLike == 3:
            sumOfScore += 100
        elif surroundLike == 4:
            sumOfScore += 1000
print(sumOfScore)