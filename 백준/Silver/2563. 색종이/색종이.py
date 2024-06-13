import sys
N = int(sys.stdin.readline())
board = [[0 for x in range(100)] for y in range(100)]

for cycle in range(N):
    l, b = map(int, sys.stdin.readline().split())
    for c1 in range(l, l+10):
        for c2 in range(b, b+10):
            board[c1][c2] = 1
result = 0
for check in range(100):
    result += sum(board[check])
print(result)