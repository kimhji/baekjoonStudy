import sys

def findNumOfCases(x):
    global num
    if x == 0:
        num += 1
        return
    if x > 2:
        findNumOfCases(x - 3)
    if x > 1:
        findNumOfCases(x - 2)
    findNumOfCases(x - 1)

N = int(sys.stdin.readline())

for testCase in range(N):
    num = 0
    case = int(sys.stdin.readline())
    findNumOfCases(case)
    print(num)