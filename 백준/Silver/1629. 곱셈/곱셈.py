import sys
N, M, K = map(int, sys.stdin.readline().split())
def calcul(x, y, z):
    if x == 1 or y == 1:
        return x%z
    elif y%2 == 0:
        return calcul(x, y//2, z)**2 % z
    else:
        return (calcul(x, y//2, z)**2 % z) * (x % z)
print(calcul(N,M, K)%K)