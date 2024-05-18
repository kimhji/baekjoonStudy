import sys, collections
N, M = map(int, sys.stdin.readline().split())
player = collections.deque()
t_player = list()
for cycle in range(1, N+1):
    T = int(sys.stdin.readline())
    ind = 0
    if ind + 1 == T:
        t_player.append(cycle)
    while player:
        p = player.popleft()
        ind += 1
        t_player.append(p)
        if ind + 1 == T:
            t_player.append(cycle)
    player = collections.deque(t_player[:])
    t_player = list()

for remove in range(N-M):
    player.pop()
t_player = list()
player2 = collections.deque()
for cycle2 in range(M-1, -1, -1):
    T = int(sys.stdin.readline())
    ind = 0
    if ind + 1 == T:
        t_player.append(player[cycle2])
    while player2:
        p = player2.popleft()
        ind += 1
        t_player.append(p)
        if ind + 1 == T:
            t_player.append(player[cycle2])
    player2 = collections.deque(t_player[:])
    t_player = list()

print(player2[0])
print(player2[1])
print(player2[2])