import sys
N = int(sys.stdin.readline())

for check in range(N):
    checkVPS = list()
    inputVPS = sys.stdin.readline()
    num = 0
    for checkLine in inputVPS:
        if checkLine == '(':
            checkVPS.append('(')
            num += 1
        elif checkLine == ')':
            if num == 0:
                num = -1
                break
            checkVPS.pop(-1)
            num -= 1
    if num == 0:
        print("YES")
    else:
        print("NO")