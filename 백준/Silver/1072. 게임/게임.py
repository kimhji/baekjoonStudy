import sys, math
X, Y = map(int, sys.stdin.readline().split())
curZ = int(Y* 100/X )
futZ = (int(curZ) + 1)
if futZ >= 100:
    print('-1')
else:
    i = (futZ * X-Y*100)/(100 - futZ)
    result = math.ceil(i)
    print(result)