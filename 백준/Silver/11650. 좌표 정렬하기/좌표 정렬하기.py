import sys
N = int(sys.stdin.readline())
dotlist = list()
for inputC in range(N):
    x, y = map(int, sys.stdin.readline().split())
    dotlist.append((x, y))
dotlist.sort(key=lambda x: (x[0], x[1]))
for printC in range(N):
    print(dotlist[printC][0], dotlist[printC][1])