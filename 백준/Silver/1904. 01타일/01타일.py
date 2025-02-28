import sys
N = int(sys.stdin.readline().strip())
datas = [0, 1, 2]
idx = 3
while idx <= N:
    datas.append((datas[idx-1] + datas[idx-2])%15746)
    idx += 1
print(datas[N])