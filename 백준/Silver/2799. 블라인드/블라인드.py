import sys

M, N = map(int, sys.stdin.readline().split())
board = list()
ind = -1
for cycle in range(M*5+1):
    line = sys.stdin.readline()
    if cycle % 5 == 0:
        ind += 1
        board.append([0 for n in range(N)])
        continue
    for check in range(N):
        if line[1+check*5] == '*':
            board[ind][check] += 1
result = [0,0,0,0,0]
for ch1 in range(M):
    for ch2 in range(N):
        result[board[ch1][ch2]] += 1
print(result[0], result[1], result[2], result[3], result[4])



