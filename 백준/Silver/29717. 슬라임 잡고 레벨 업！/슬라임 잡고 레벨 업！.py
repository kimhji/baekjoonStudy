import sys
import math

T = int(sys.stdin.readline().strip())
for _ in range(T):
    N = int(sys.stdin.readline().strip())

    total_sum = N * (N + 1) // 2
    X = int(math.sqrt(total_sum))

    if X * (X + 1) > total_sum:
        X -= 1

    print(X + 1)

