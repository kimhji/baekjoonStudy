import sys
T = int(sys.stdin.readline())
for testcase in range(T):
    M, N, K = map(int, sys.stdin.readline().split())
    Board = [[[0, True] for x in range(M)] for y in range(N)]
    plantBag = list()
    for inputC in range(K):
        x, y = map(int, sys.stdin.readline().split())
        Board[y][x] = [1, False]
        plantBag.append([x, y])
    result = 0
    for check in plantBag:
        if Board[check[1]][check[0]][1]:
            continue
        bag = [check]
        Board[check[1]][check[0]][1] = True
        tnsbag = []
        result += 1
        while bag:
            for cycleBag in bag:
                tx = cycleBag[0]
                ty = cycleBag[1]
                nextx = tx - 1
                nexty = ty
                if nextx >= 0 and not Board[nexty][nextx][1]:
                    tnsbag.append([nextx, nexty])
                    Board[nexty][nextx][1] = True
                nextx = tx
                nexty = ty + 1
                if nexty < N and not Board[nexty][nextx][1]:
                    tnsbag.append([nextx, nexty])
                    Board[nexty][nextx][1] = True
                nextx = tx + 1
                nexty = ty
                if nextx < M and not Board[nexty][nextx][1]:
                    tnsbag.append([nextx, nexty])
                    Board[nexty][nextx][1] = True
                nextx = tx
                nexty = ty - 1
                if nexty >= 0 and not Board[nexty][nextx][1]:
                    tnsbag.append([nextx, nexty])
                    Board[nexty][nextx][1] = True
            bag = tnsbag[:]
            tnsbag = list()
    print(result)