import math

N, M, K = map(int, input().split())
lottery = 0
total = math.comb(N, M)
for i in range(K, M + 1):
    lottery += math.comb(M, i) * math.comb(N - M, M - i)
print(lottery / total)