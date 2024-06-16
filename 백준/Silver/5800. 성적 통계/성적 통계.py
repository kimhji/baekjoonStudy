import sys
N = int(sys.stdin.readline())
for cycle in range(N):
    inputs = list(map(int, sys.stdin.readline().split()))
    score = inputs[1:]
    numOfStudent = inputs[0]
    scoreGap = []
    score.sort()
    for check in range(numOfStudent-1):
        scoreGap.append(score[check+1]-score[check])

    print(f"Class {cycle+1}")
    print(f"Max {score[-1]}, Min {score[0]}, Largest gap {max(scoreGap)}")