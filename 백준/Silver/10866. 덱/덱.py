import sys, collections
N = int(sys.stdin.readline())
Deque = collections.deque()
numOfDeque = 0

for orderCycle in range(N):
    order = list(sys.stdin.readline().split())
    if order[0] == "push_back":
        num = int(order[1])
        Deque.append(num)
        numOfDeque += 1
    elif order[0] == "push_front":
        num = int(order[1])
        Deque.appendleft(num)
        numOfDeque += 1
    elif order[0] == "pop_front":
        if numOfDeque == 0:
            num = -1
        else:
            num = Deque.popleft()
            numOfDeque -= 1
        print(num)
    elif order[0] == "pop_back":
        if numOfDeque == 0:
            num = -1
        else:
            num = Deque.pop()
            numOfDeque -= 1
        print(num)
    elif order[0] == "size":
        print(numOfDeque)
    elif order[0] == "empty":
        if numOfDeque == 0:
            print(1)
        else:
            print(0)
    elif order[0] == "front":
        if numOfDeque == 0:
            num = -1
        else:
            num = Deque[0]
        print(num)
    elif order[0] == "back":
        if numOfDeque == 0:
            num = -1
        else:
            num = Deque[-1]
        print(num)