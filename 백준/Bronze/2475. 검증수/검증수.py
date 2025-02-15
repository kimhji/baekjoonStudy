import sys

datas = list(map(int, sys.stdin.readline().strip().split(" ")))
result = 0
for one in datas:
    result += one*one
    result %= 10
print(result)