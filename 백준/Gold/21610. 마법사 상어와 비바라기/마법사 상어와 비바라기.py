Input = list(map(int, input().split()))
N = Input[0]
M = Input[1]
Board = [[0 for _ in range(N)] for _ in range(N)]
for BoardWater in range(N):
    Input = list(map(int, input().split()))
    for c in range(len(Input)):
        Board[BoardWater][c] = Input[c]

cloud = [(N, 1), (N, 2), (N-1, 1), (N-1, 2)]
beforeCloud = set()
SumWater = 0
for cycle in range(M):
    Input = list(map(int, input().split()))
    d = Input[0]
    s = Input[1]
    for cloudRCUpdate in range(len(cloud)):
        update = list(cloud[cloudRCUpdate])
        if d == 1:
            update[1] -= s
        elif d == 2:
            update[1] -= s
            update[0] -= s
        elif d == 3:
            update[0] -= s
        elif d == 4:
            update[1] += s
            update[0] -= s
        elif d == 5:
            update[1] += s
        elif d == 6:
            update[1] += s
            update[0] += s
        elif d == 7:
            update[0] += s
        elif d == 8:
            update[1] -= s
            update[0] += s
        while update[1] < 1:
            update[1] += N
        while update[0] < 1:
            update[0] += N
        if update[1] > N:
            update[1] %= N
        if update[0] > N:
            update[0] %= N
        if update[0] == 0:
            update[0] = N
        if update[1] == 0:
            update[1] = N
        cloud[cloudRCUpdate] = tuple(update)
        Board[update[0]-1][update[1]-1] += 1
    beforeCloud = set(cloud.copy())
    cloud.clear()
    for WaterBug in beforeCloud:
        r = WaterBug[0] - 1
        c = WaterBug[1] - 1
        if r-1 >= 0 and c-1 >= 0 and Board[r-1][c-1] > 0:
            Board[r][c] += 1
        if r-1 >= 0 and c+1 < N and Board[r-1][c+1] > 0:
            Board[r][c] += 1
        if r+1 < N and c+1 < N and Board[r+1][c+1] > 0:
            Board[r][c] += 1
        if r + 1 < N and c - 1 >= 0 and Board[r + 1][c - 1] > 0:
            Board[r][c] += 1
    for BoardWater1 in range(N):
        for BoardWater2 in range(N):
            if Board[BoardWater1][BoardWater2] >= 2 and (BoardWater1 + 1, BoardWater2 + 1) not in beforeCloud:
                cloud.append((BoardWater1 + 1, BoardWater2 + 1))
                Board[BoardWater1][BoardWater2] -= 2
            if cycle == M-1:
                SumWater += Board[BoardWater1][BoardWater2]
print(SumWater)