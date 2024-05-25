import sys
E, S, M = map(int, sys.stdin.readline().split())
while not(E==S and S==M):
    if E <= S and E <= M:
        E += 15
    elif S <= E and S <= M:
        S += 28
    elif M <= E and M <= S:
        M += 19
print(E)