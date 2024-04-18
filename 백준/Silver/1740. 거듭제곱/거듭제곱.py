import sys
def square3(k):
    global List3
    if List3[k] == -1:
        List3[k] = square3(k-1) * 3
    return List3[k]
List3 = [-1 for cycle in range(10000000)]
List3[0] = 1
N = int(sys.stdin.readline())
x = bin(N)
x = x[2:]
num = 0
result = 0
while len(x) > 0:
    y = x[-1]
    x = x[:-1]
    if y == '1':
        result += square3(num)
    num += 1
print(result)