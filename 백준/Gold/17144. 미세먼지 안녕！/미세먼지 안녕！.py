Input = list(map(int, input().split()))
R = Input[0]
C = Input[1]
T = Input[2]
# 각 좌표당 (현재 미세먼지, 들어올 미세먼지)로 저장
Board = [[[0, 0] for _ in range(C)] for _ in range(R)]
upClean = -1
downClean = -1
for BoardInput1 in range(R):
    Input = list(map(int, input().split()))
    for BoardInput2 in range(C):
        Board[BoardInput1][BoardInput2][0] = Input[BoardInput2]
        if Input[BoardInput2] == -1:
            if upClean == -1:
                upClean = BoardInput1
            else:
                downClean = BoardInput1
for cycle in range(T):
    for spread1 in range(R):
        for spread2 in range(C):
            n = 0
            Sum = int(Board[spread1][spread2][0]/5)
            if spread1 - 1 > -1 and Board[spread1 - 1][spread2][0] != -1:
                n += 1
                Board[spread1 - 1][spread2][1] += Sum
            if spread1 + 1 < R and Board[spread1 + 1][spread2][0] != -1:
                n += 1
                Board[spread1 + 1][spread2][1] += Sum
            if spread2 + 1 < C and Board[spread1][spread2 + 1][0] != -1:
                n += 1
                Board[spread1][spread2 + 1][1] += Sum
            if spread2 - 1 > -1 and Board[spread1][spread2 - 1][0] != -1:
                n += 1
                Board[spread1][spread2 - 1][1] += Sum
            Board[spread1][spread2][0] -= n * Sum
    for spread1 in range(R):
        for spread2 in range(C):
            Board[spread1][spread2] = [Board[spread1][spread2][0] + Board[spread1][spread2][1], 0]
    for upCleaning1 in range(upClean - 1, 0, -1):
        Board[upCleaning1][0] = Board[upCleaning1 - 1][0]
    for upCleaning2 in range(C - 1):
        Board[0][upCleaning2] = Board[0][upCleaning2 + 1]
    for upCleaning3 in range(upClean):
        Board[upCleaning3][C-1] = Board[upCleaning3 + 1][C-1]
    for upCleaning4 in range(C - 1, 1, -1):
        Board[upClean][upCleaning4] = Board[upClean][upCleaning4 - 1]
    Board[upClean][1] = [0, 0]

    for downClean1 in range(downClean + 1, R-1, 1):
        Board[downClean1][0] = Board[downClean1 + 1][0]
    for downClean2 in range(C - 1):
        Board[R-1][downClean2] = Board[R - 1][downClean2 + 1]
    for downClean3 in range(R-1, downClean, -1):
        Board[downClean3][C - 1] = Board[downClean3 - 1][C - 1]
    for downClean4 in range(C - 1, 1, -1):
        Board[downClean][downClean4] = Board[downClean][downClean4 - 1]
    Board[downClean][1] = [0, 0]
Sum = 0
for DustSum1 in range(R):
    for DustSum2 in range(C):
        if Board[DustSum1][DustSum2][0] != -1:
            Sum += Board[DustSum1][DustSum2][0]
print(Sum)