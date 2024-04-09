import sys
N = int(sys.stdin.readline())
List = list()
for inputC in range(N):
    num = int(sys.stdin.readline())
    if num == 0:
        List.pop()
    else:
        List.append(num)
print(sum(List))