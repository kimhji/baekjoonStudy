import sys
from collections import deque

input = sys.stdin.read
inp = input().strip().split('\n')

N = int(inp[0])
numb = list(map(int, inp[1].split()))

resCard = deque()

for i in range(1, N + 1):
    card = i
    order = numb.pop()
    if order == 1:
        resCard.appendleft(card)
    elif order == 2:
        if len(resCard) > 0:
            temp_card = resCard.popleft()
            resCard.appendleft(card)
            resCard.appendleft(temp_card)
        else:
            resCard.appendleft(card)
    elif order == 3:
        resCard.append(card)

print(" ".join(map(str, resCard)))
