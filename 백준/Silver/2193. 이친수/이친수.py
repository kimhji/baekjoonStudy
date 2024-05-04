import sys
def check(num, N):
    global result
    if num == N:
        return
    result.append([result[num][1], result[num][0]+result[num][1]])
    check(num+1, N)

N = int(sys.stdin.readline())
result = [[1, 0]]# 1인 경우의 수, 0인 경우의 수
check(0, N)
print(result[N-1][0]+result[N-1][1])