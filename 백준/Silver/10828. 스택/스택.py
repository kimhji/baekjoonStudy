import sys
stack = list()
N = int(sys.stdin.readline())
numOfStack = 0

for inputOrder in range(N):
    order = list(sys.stdin.readline().split())
    if order[0] == "push":
        num = int(order[1])
        stack.append(num)
        numOfStack += 1
    elif order[0] == "pop":
        if numOfStack > 0:
            num = stack.pop(-1)
            numOfStack -= 1
            print(num)
        else:
            print(-1)
    elif order[0] == "size":
        print(numOfStack)
    elif order[0] == "empty":
        if numOfStack > 0:
            print(0)
        else:
            print(1)
    elif order[0] == "top":
        if numOfStack > 0:
            num = stack[-1]
        else:
            num = -1
        print(num)