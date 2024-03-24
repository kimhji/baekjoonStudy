import sys, collections
N = int(sys.stdin.readline())
Q = collections.deque()
num = 0
for inputC in range(N):
    order = list(sys.stdin.readline().split())
    if order[0] == 'push':
        Q.append(order[1])
        num += 1
    elif order[0] == 'pop':
        if num == 0:
            result = -1
        else:
            result = Q.popleft()
            num -= 1
        print(result)
    elif order[0] == 'size':
        print(num)
    elif order[0] == 'empty':
        if num == 0:
            print(1)
        else:
            print(0)
    elif order[0] == 'front':
        if num == 0:
            print(-1)
        else:
            print(Q[0])
    elif order[0] == 'back':
        if num == 0:
            print(-1)
        else:
            print(Q[-1])