import sys, collections

N = int(sys.stdin.readline())
cards = collections.deque(x for x in range(1, N+1))
for cycle in range(N):
    print(cards.popleft(), end=' ')
    if len(cards) > 0:
        tns = cards[0]
        for change in range(N-cycle-2):
            cards[change] = cards[change+1]
        cards[N-cycle-2] = tns

