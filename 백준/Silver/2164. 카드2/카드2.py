import sys, collections

N = int(sys.stdin.readline())
card = collections.deque(number for number in range(1, N + 1))
num = N
while num > 1:
    card.popleft()
    firstCard = card.popleft()
    card.append(firstCard)
    num -= 1
LastCard = card.pop()
print(LastCard)