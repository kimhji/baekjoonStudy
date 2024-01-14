import sys, collections
N = int(sys.stdin.readline())
Queue = collections.deque()
numOfQueue = 0

for orderCheck in range(N):
    order = list(sys.stdin.readline().split())
    if order[0] == "push":
        num = int(order[1])
        Queue.append(num)
        numOfQueue += 1
    elif order[0] == "pop":
        if numOfQueue > 0:
            #deque는 앞 뒤에서 모두 pop이 가능한 자료 구조. list로 해버리면 pop(0)의 시간 복잡도가 최대 O(n)이 될 수 있다.
            num = Queue.popleft()
            numOfQueue -= 1
        else:
            num = -1
        print(num)
    elif order[0] == "size":
        print(numOfQueue)
    elif order[0] == "empty":
        if numOfQueue == 0:
            print(1)
        else:
            print(0)
    elif order[0] == "front":
        if numOfQueue > 0:
            num = Queue[0]
        else:
            num = -1
        print(num)
    elif order[0] == "back":
        if numOfQueue > 0:
            num = Queue[-1]
        else:
            num = -1
        print(num)