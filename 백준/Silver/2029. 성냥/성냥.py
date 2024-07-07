import sys
board = list()
for inp in range(10):
    board.append(sys.stdin.readline().strip());

result1 = 0
result2 = 0
bag = []
for i in range(0, 10):
    for j in range(0, 10):
        if board[i][j] == '+':
            bag.append((i,j))
            if i == 0 or j == 0:
                if i == 0 and j != 0:
                    if board[i][j-1] != '-':
                        result2+=1
                elif i != 0 and j == 0:
                    if board[i-1][j] != '|':
                        result2+=1
                continue
            if board[i-1][j] == '|' and board[i][j-1] == '-':
                for check in bag:
                    if check[0] >= i or check[1] >= j:
                        continue
                    isValid = True
                    for cycle1 in range(check[0], i):
                        if board[cycle1][check[1]] != '|' and board[cycle1][check[1]] != '+':
                            isValid = False
                    for cycle2 in range(check[1], j):
                        if board[check[0]][cycle2] != '-' and board[check[0]][cycle2] != '+':
                            isValid = False
                    if isValid:
                        if i-check[0] == j-check[1]:
                            result1 += 1
            else:
                result2 += 1
                if board[i-1][j] != '|' and board[i][j-1] != '-':
                    result2 += 1

print(result2, result1)