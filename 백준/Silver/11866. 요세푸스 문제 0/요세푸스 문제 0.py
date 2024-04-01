import sys
N, K = map(int, sys.stdin.readline().split())

List = [1 for i in range(N)]
result = list()
All0 = False

count = 0
while not All0:
    All0 = True
    for i in range(N):
        if List[i] == 1:
            count += 1
            All0 = False
            if count == K:
                count = 0
                List[i] = 0
                result.append(i+1)
print('<', end='')
for printC in range(N-1):
    print(result[printC], end=', ')
print(result[-1], end='>')