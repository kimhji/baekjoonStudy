import sys


N = int(sys.stdin.readline().strip())
while N > 0:
    cards = []
    for i in range(N):
        cards.append(sys.stdin.readline().strip())
    for i in range(N//2):
        print(cards[i])
        print(cards[i+int(N/2+0.5)])
    if N%2 == 1:
        print(cards[N//2])

    N = int(sys.stdin.readline().strip())