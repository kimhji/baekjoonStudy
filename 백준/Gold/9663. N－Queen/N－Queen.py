import sys
N = int(sys.stdin.readline())

def NQueen(BeforeX, BeforeY, num, queenlisty, queenlist, queenlist2):
    global numOfCase
    if num == N:
        numOfCase += 1
        return
    x = BeforeX + 1
    for y in range(N):
        if not queenlisty[y]:
            case1 = x+y
            case2 = N-x-1+y
            if not queenlist[case1] and not queenlist2[case2]:
                queenlisty[y] = True
                queenlist[case1] = True
                queenlist2[case2] = True
                NQueen(x, y, num + 1, queenlisty, queenlist, queenlist2)
                queenlisty[y] = False
                queenlist[case1] = False
                queenlist2[case2] = False


numOfCase = 0
NQueen(-1, -1, 0, list(False for y in range(N)), list(False for n2 in range(2*N)), list(False for n2 in range(2*N)))

print(numOfCase)