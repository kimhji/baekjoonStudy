import sys
def check(x, y):
    global W, H, X, Y, P
    result = False
    if x >= X and y >= Y and x <= X+W and y <= Y+H:
        result = True
    else:
        dist = (abs(X-x)**2 + abs((Y+H//2)-y)**2)**(1/2)
        if dist <= H//2:
            result = True
        dist = (abs((X+W) - x) ** 2 + abs((Y + H // 2) - y) ** 2) ** (1 / 2)
        if dist <= H//2:
            result = True
    return result

W, H, X, Y, P = map(int,sys.stdin.readline().split())
num = 0
for cycle in range(P):
    x,y = map(int, sys.stdin.readline().split())
    if check(x,y):
        num += 1
print(num)