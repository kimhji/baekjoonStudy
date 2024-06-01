import sys
length, n = map(int, sys.stdin.readline().split())
line = list(sys.stdin.readline().strip())
diff = ord('Z')-ord('A')+1
for check in range(n):
    order = list(map(int, sys.stdin.readline().split()))
    if order[0] == 1:
        num = 1
        for cycle in range(order[1], order[2]):
            if line[cycle-1] != line[cycle]:
                num += 1
        print(num)

    elif order[0] == 2:
        for cycle in range(order[1]-1, order[2]):
            x= ord(line[cycle])+1
            if x > ord('Z'):
                x-=diff
            line[cycle] = chr(x)
