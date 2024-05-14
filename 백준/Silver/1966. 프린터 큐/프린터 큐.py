import sys, collections
T = int(sys.stdin.readline())
for cycle in range(T):
    N, M = map(int,sys.stdin.readline().split())
    inputList = collections.deque(map(int, sys.stdin.readline().split()))
    count = 0
    isEnd = False
    while not isEnd:
        maxNum = 0
        for x in range(1, N):
            if inputList[maxNum] < inputList[x]:
                maxNum = x
        for change in range(maxNum):
            tmp = inputList.popleft()
            inputList.append(tmp)
            M -= 1
            if M < 0:
                M += N
        if M == 0:
            isEnd = True
        inputList.popleft()
        M -= 1
        N -= 1
        count += 1
        if M < 0:
            M += N
    print(count)