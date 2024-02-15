import sys
def make1(value, num):
    global MinV
    if MinV < num:
        return
    elif value == 1:
        MinV = num
        return
    if value % 3 == 0:
        make1(value//3, num+1)
    if value % 2 == 0:
        make1(value//2, num+1)
    make1(value-1, num+1)
N = int(sys.stdin.readline())
MinV = 1000001
make1(N, 0)
print(MinV)