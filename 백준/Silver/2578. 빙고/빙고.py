import sys
def lineCheck(boardV):
    correctLine = 0
    for checkHori in range(5):
        for checks in range(5):
            if boardV[checkHori][checks] != -1:
                break
            if checks == 4:
                correctLine += 1
    for checkVerti in range(5):
        for checks in range(5):
            if boardV[checks][checkVerti] != -1:
                break
            if checks == 4:
                correctLine += 1
    for checkdiag1 in range(5):
        if boardV[checkdiag1][checkdiag1] != -1:
            break
        if checkdiag1 == 4:
            correctLine += 1
    for checkdiag2 in range(5):
        if boardV[4-checkdiag2][checkdiag2] != -1:
            break
        if checkdiag2 == 4:
            correctLine += 1
    return correctLine

board = list()
indexNumbers = [(-1, -1) for x in range(26)]
for inputC in range(5):
    lineInput = list(map(int, sys.stdin.readline().split()))
    board.append(lineInput)
    for oneNumIndex in range(5):
        indexNumbers[lineInput[oneNumIndex]] = (inputC, oneNumIndex)

resultNum = 0
indexNum = 0
for inputC in range(5):
    lineInput = list(map(int, sys.stdin.readline().split()))
    for check in lineInput:
        loc = indexNumbers[check]
        board[loc[0]][loc[1]] = -1
        indexNum += 1
        if resultNum == 0 and lineCheck(board) >= 3:
            resultNum = indexNum
print(resultNum)