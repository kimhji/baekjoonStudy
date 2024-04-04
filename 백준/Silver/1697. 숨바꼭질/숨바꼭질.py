import sys
N, K = map(int, sys.stdin.readline().split())
board = [False for cycle in range(100001)]
bag = [N]
board[N] = True
tnsbag = list()
value = 0
result = 0
while bag:
    for check in bag:
        if check == K:
            tnsbag = list()
            result = value
            break
        nextloc = check + 1
        if nextloc <= 100000 and not board[nextloc]:
            tnsbag.append(nextloc)
            board[nextloc] = True
        nextloc = check - 1
        if nextloc >= 0 and not board[nextloc]:
            tnsbag.append(nextloc)
            board[nextloc] = True
        nextloc = check * 2
        if nextloc <= 100000 and not board[nextloc]:
            tnsbag.append(nextloc)
            board[nextloc] = True
    bag = tnsbag[:]
    tnsbag = list()
    value += 1
print(result)
