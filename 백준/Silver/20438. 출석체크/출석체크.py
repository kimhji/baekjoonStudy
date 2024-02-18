import sys
N, K, Q, M = map(int, sys.stdin.readline().split())
sleeping = list(map(int, sys.stdin.readline().split()))
sendCode = list(map(int, sys.stdin.readline().split()))
student = [0 for att in range(N+3)]
sumStudent = [0 for students in range(N+3)]
for sleepCheck in sleeping:
    student[sleepCheck] = -1
for attend in sendCode:
    if student[attend] == -1:
        continue
    code = attend
    while code < N+3:
        if student[code] != -1:
            student[code] = 1
        code += attend
for checkSum in range(3, N+3):
    sumStudent[checkSum] = sumStudent[checkSum - 1]
    if student[checkSum] <= 0:
        sumStudent[checkSum] += 1
for inputCycle in range(M):
    start, end = map(int, sys.stdin.readline().split())
    print(sumStudent[end]-sumStudent[start-1])