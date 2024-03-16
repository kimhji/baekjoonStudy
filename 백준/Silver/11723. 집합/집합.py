import sys
M = int(sys.stdin.readline())
setR = [0 for number in range(21)]
for inputC in range(M):
    order = list(sys.stdin.readline().split())
    if order[0] == 'add':
        num = int(order[1])
        setR[num] = 1
    elif order[0] == 'remove':
        num = int(order[1])
        setR[num] = 0
    elif order[0] == 'check':
        num = int(order[1])
        if setR[num] == 1:
            print(1)
        else:
            print(0)
    elif order[0] == 'toggle':
        num = int(order[1])
        if setR[num] == 1:
            setR[num] = 0
        else:
            setR[num] = 1
    elif order[0] == 'all':
        setR = [1 for number in range(21)]
    else:
        setR = [0 for number in range(21)]