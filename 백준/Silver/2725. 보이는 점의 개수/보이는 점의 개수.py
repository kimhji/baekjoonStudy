# from math import gcd

# 1이 나오면 서로소
def gcd(a, b):
    while b:
        a, b = b, a % b
    return a


t = int(input())

ans = [0, 3]

for i in range(2, 1001):
    now_ans = 0
    for j in range(1, i):
        if gcd(i, j) == 1:
            now_ans += 1

    ans.append(ans[-1] + now_ans * 2)

# print(ans)

for _ in range(t):
    n = int(input())

    print(ans[n])