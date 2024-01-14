import sys
N, K = map(int, sys.stdin.readline().split())

Yo = list(number for number in range(1, N + 1))
num = N
index = -1

print("<", end='')
while num > 0:
    index += K
    if num <= index:
        index %= num
    if num == 1:
        print(Yo.pop(index), end='>')
        num -= 1
        index -= 1
    else:
        print(Yo.pop(index), end=', ')
        num -= 1
        index -= 1