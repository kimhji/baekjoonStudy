import sys
X = int(sys.stdin.readline())
y = 1
while X - y >0:
    X -= y
    y += 1

if (y-1)%2!=0:
    print(str(X)+'/'+str(y-X+1))
else:
    print(str(y-X+1) + '/' + str(X))