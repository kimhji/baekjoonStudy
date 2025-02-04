import sys

N = int(sys.stdin.readline().strip())
arr = []
length = 0
for i in range(0, N):
    order = list(map(int, sys.stdin.readline().strip().split(" ")))
    if order[0] == 1:
        arr.append(order[1])
        length += 1
    elif order[0] == 2:
        if length <= 0:
            print(-1)
        else:
            print(arr.pop())
            length -= 1
    elif order[0] == 3:
        print(length)
    elif order[0] == 4:
        if length <= 0:
            print(1)
        else:
            print(0)
    elif order[0] == 5:
        if length <= 0:
            print(-1)
        else:
            print(arr[length-1])